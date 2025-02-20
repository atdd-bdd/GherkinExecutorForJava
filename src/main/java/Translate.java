
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Translate {
    private final Map<String, String> scenarios = new HashMap<>(); // used to check if duplicate scenario names
    private final Map<String, String> glueFunctions = new HashMap<>(); // used to make sure only one glue implementation
    private final Map<String, String> dataNames = new HashMap<>(); // used to check for duplicate data
    private final int stepCount = 0; // use to label duplicate scenarios
    private final String basePath = Configuration.testSubDirectory;
    private String glueClass = "";  // glue class name
    private String glueObject = "";  // glue object name
    private int stepNumberInScenario = 0;  // use to label variables in scenario
    private InputIterator dataIn = new InputIterator("");
    private boolean firstScenario = true; // If first scenario
    private boolean addBackground = false;  // Have seen Background
    private boolean addCleanup = false;  // have seen Cleanup

    private boolean inCleanup = false; // current scenario is cleanup
    private boolean finalCleanup = false; // for the last part of scenario
    // Create the output files, save names for deletions
//    private final String testFilename = basePath + "Test" + ".tmp";
    private FileWriter testFile;

    // private FileWriter aTestFile;  - to not create tmp file
    private boolean featureActedOn = false; // Have found a feature step
    private String featureName = "";

    private String directoryName = "";
    private final DataConstruct dataConstruct = new DataConstruct();

    private final TemplateConstruct templateConstruct = new TemplateConstruct();

    private final StepConstruct stepConstruct = new StepConstruct();
    public Translate() {
    }

    public void translateInTests(String name) {
        dataIn = new InputIterator(name);
        boolean eof = false;
        while (!eof) {
            String line = dataIn.next();
            if (line.equals(InputIterator.EOF)) {
                eof = true;
                continue;
            }
            actOnLine(line);
        }
        endUp();
    }

    private void actOnLine(String line) {
        Pair<List<String>, List<String>> splitLine = splitLine(line);
        List<String> words = splitLine.getFirst();
        List<String> comment = splitLine.getSecond();
        if (words.size() > 0) {
            String keyword = wordWithOutColon(words.get(0));
            // Note sure what the above is happening
            if (keyword.equals("*")) {
                keyword = "Star";
            }
            words.set(0, keyword);
            actOnKeyword(keyword, words, comment);
        }
    }

    private Pair<List<String>, List<String>> splitLine(String line) {
        String[] allWords = line.split(" ");
        List<String> words = new ArrayList<>();
        List<String> comment = new ArrayList<>();
        boolean inComment = false;
        for (String aWord : allWords) {
            String word = aWord.trim();
            if (word.isEmpty()) continue;
            if (word.endsWith(":")) {
                word = wordWithOutColon(word);
            }
            if (inComment) {
                comment.add(word);
                continue;
            }
            if (word.charAt(0) == '#') {
                inComment = true;
                word = wordWithOutHash(word);
                if (!word.isEmpty()) {
                    comment.add(word);
                }
                continue;
            }
            words.add(word);
        }
        return new Pair<>(words, comment);
    }
    private static String wordWithOutColon(String word) {
        return word.replaceAll("^:+|:+$", "");
    }

    private static String wordWithOutHash(String word) {
        return word.replaceAll("^#+|#+$", "");
    }

    private void actOnKeyword(String keyword, List<String> words, List<String> comment) {
        String fullName = String.join("_", words);
        trace("Act on keyword " + keyword + " " + fullName);
        switch (keyword) {
            case "Feature":
                actOnFeature(fullName);
                break;
            case "Scenario":
                actOnScenario(fullName, addBackground, false, addCleanup, inCleanup) ;
                inCleanup = false;
                break;
           case "Background":
                actOnScenario(fullName, false, true, false, inCleanup);
                addBackground = true;
                inCleanup = false;
                break;
            case "Cleanup":
                actOnScenario(fullName, false, false, false, inCleanup);
                addCleanup = true;
                inCleanup = true;
                break;
            case "Given":
            case "When":
            case "Then":
            case "And":
            case "Star":
            case "Arrange":
            case "Act":
            case "Assert":
            case "Rule":
            case "Calculation":
                stepConstruct.actOnStep(fullName, comment);
                break;
            case "Data":
                dataConstruct.actOnData(words);
                break;
            default:
                error("keyword not recognized " + keyword);
        }
    }

    private void actOnFeature(String fullName) {
        if (featureActedOn) {
            error("Feature keyword duplicated - it is ignored " + fullName);
            return;
        }
        featureName = fullName;

        featureActedOn = true;
        String testPathname = Configuration.testSubDirectory + featureName + "/" + featureName + ".java";
        System.out.println(" Writing " + testPathname);
        String dataDefinitionPathname = Configuration.testSubDirectory + featureName + "/" + featureName + "_data." + Configuration.dataDefinitionFileExtension;
        String templateFilename = Configuration.testSubDirectory + featureName + "/" + featureName + "_glue.tmpl";
//        cleanFiles();
        directoryName = Configuration.testSubDirectory + featureName;
        System.out.println("Directory " + directoryName + " ");
        try {
            boolean result = new File(directoryName).mkdirs();
            testFile = new FileWriter(testPathname, false);
            templateConstruct.glueTemplateFile = new FileWriter(templateFilename, false);
        } catch (IOException e) {
            error("IO Exception in setting up the files");
            error(" Writing " + dataDefinitionPathname);

        }
        glueClass = fullName + "_glue";
        glueObject = makeName(fullName) + "_glue_object";
        testPrint("package " + Configuration.packageName + "." + featureName + ";");
        testPrint("import org.junit.jupiter.api.Test;");
        testPrint("import org.junit.jupiter.api.TestInstance;");
        testPrint("import java.util.List;");
        if (Configuration.inTest) {
            testPrint("import java.io.FileWriter;");
            testPrint("import java.io.IOException;");
        }
        testPrint("@TestInstance(TestInstance.Lifecycle.PER_CLASS)");
        testPrint("class " + fullName + "{");
        testPrint(logIt(directoryName));
        testPrint("");

        templateConstruct.beginTemplate();
    }

    private String makeName(String input) {
        if (input.isEmpty()) return "NAME_IS_EMPTY";
        String temp = input.replace(' ', '_');
        return Character.toLowerCase(temp.charAt(0)) + temp.substring(1);
    }


//    private void cleanFiles()  {
//        try {
//            testFile.close();
//            dataDefinitionFile.close();
//            glueTemplateFile.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//    }



    private void actOnScenario(String fullName, boolean addBackground, boolean inBackground, boolean addCleanup, boolean inCleanup) {
        String fullNameToUse = fullName;
        if (scenarios.containsKey(fullName)) {
            fullNameToUse += stepCount;
            error("Scenario name duplicated renamed " + fullNameToUse);
        } else {
            scenarios.put(fullNameToUse, "");
        }
        stepNumberInScenario = 0;
        // To make sure cleanup is called for final scenario
        if (inCleanup)
            finalCleanup = false;
        else if (addCleanup)
            finalCleanup = true;
        if (firstScenario) {
            firstScenario = false;
        } else {
            // Finishing up previous scenario
            if (addCleanup && !inCleanup ) {
                testPrint("        test_Cleanup(); // from previous");
            }
            testPrint("        }"); // end previous scenario
        }
        testPrint("    @Test");
        testPrint("    void test_" + fullNameToUse + "(){");
        testPrint("         " + glueClass + " " + glueObject + " = new " + glueClass + "();");
        if (Configuration.inTest)
        {
            testPrint("        log(" + "\"" + fullNameToUse + "\"" +");");
        }
        if (addBackground) {
            testPrint("        test_Background();");
        }
    }


    private String logIt(String pathname) {
        if (Configuration.inTest) {
            String filename = directoryName + "/log.txt";
            System.out.println(" Filename " + filename);
            String logFunction =
                "void log(String value) {" + System.lineSeparator() +
                "    try {" +System.lineSeparator() +
                "        FileWriter mylog = new FileWriter(" +
                         "\"" + filename + "\"" + ", true);" +System.lineSeparator() +
                "        mylog.write(value + \"\\n\");" + System.lineSeparator() +
                "        mylog.close();" +System.lineSeparator() +
                "    } catch (IOException e) {" +System.lineSeparator() +
                "    System.out.println(\"**** Cannot write to log \");" +System.lineSeparator() +
                "    }" + System.lineSeparator() +
                "    }" + System.lineSeparator() ;
            return logFunction;
        }
        else
            return "";
    }
    private void trace(String value) {
        if (Configuration.traceOn) {
            System.out.println(value);
        }
    }

    private void error(String value) {
        System.out.println("*** " + value);
    }

    private void testPrint(String line) {
        try {
            testFile.write(line);
            testFile.write("\n");
        } catch (IOException e) {
            error("IO ERROR ");
        }
    }


    private List<String> parseLine(String line) {
        String lineShort = line.trim();
        if (lineShort.charAt(0) == '|') {
            lineShort = lineShort.substring(1);
        } else {
            error("table not begin with | " + line);
            return List.of("ERROR IN TABLE LINE " + line);
        }
        int last = lineShort.length() - 1;
        if (last < 0) {
            error("table format error " + line);
            return List.of("ERROR IN TABLE LINE " + line);
        }
        if (lineShort.charAt(last) == '|') {
            lineShort = lineShort.substring(0, last);
        } else {
            error("table not end with | " + line);
        }
        String[] elements = lineShort.split("\\|");
        List<String> elementsTrimmed = new ArrayList<>();
        for (String element : elements) {
            String current = element.trim();
            current = current.replace(Configuration.spaceCharacters, ' ');
            elementsTrimmed.add(current);
        }
        return elementsTrimmed;
    }

    private Pair<String, List<String>> lookForFollow() {
        String line = dataIn.peek();
        List<String> empty = new ArrayList<>();
        while (!line.isEmpty() && line.charAt(0) == '#') {
            dataIn.next();
            line = dataIn.peek();
        }
        line = line.trim();
        if (line.isEmpty()) return new Pair<>("NOTHING", empty);
        if (line.charAt(0) == '|') {
            List<String> retValue = readTable();
            trace("Table is " + retValue);
            return new Pair<>("TABLE", retValue);
        }
        if (line.equals("\"\"\"")) {
            List<String> retValue = readString();
            trace("Multi Line String is " + retValue);
            return new Pair<>("STRING", retValue);
        }
        return new Pair<>("NOTHING", empty);
    }

    private List<String> readTable() {
        List<String> retValue = new ArrayList<>();
        String line = dataIn.peek().trim();
        while (!line.isEmpty() && (line.charAt(0) == '|' || line.charAt(0) == '#')) {
            line = dataIn.next().trim();
            if (line.charAt(0) == '|' && line.endsWith("|")) {
                retValue.add(line);
            } else {
                error("Invalid line in table " + line);
            }
            line = dataIn.peek().trim();
        }
        return retValue;
    }

    private List<String> readString() {
        List<String> retValue = new ArrayList<>();
        String firstLine = dataIn.peek();
        int countIndent = countIndent(firstLine);
        dataIn.next();
        String line = dataIn.next();
        while (!line.trim().equals("\"\"\"")) {
            retValue.add(line.substring(countIndent));
            line = dataIn.next();
        }
        return retValue;
    }
    private int countIndent(String firstLine) {
        String line = firstLine.trim();
        return firstLine.length() - line.length();
    }

    public static void main(String[] args) {
        System.out.println("Gherkin Executor");
        Configuration.currentDirectory = System.getProperty("user.dir");
        System.out.println("Arguments");
        for (String arg : args) {
            System.out.println("   " + arg);
            Configuration.featureFiles.add(arg);
        }
        for (String name : Configuration.featureFiles) {
            Translate translate = new Translate();
            System.out.println("Translating " + name);
            translate.translateInTests(name);
        }
    }

    static class InputIterator {
        private final List<String> linesIn = new ArrayList<>();
        private int index = 0;


        public static final String EOF = "EOF";

        public InputIterator(String name) {
            index = 0;
            if (!name.isEmpty()) {
                readFile(name, 0);
            }
        }

        private void readFile(String fileName, int includeCount) {
            System.out.println("Reading file " + fileName);
            includeCount++;
            if (includeCount > 20) {
                error("Too many levels of include");
                return;
            }
            try {
                String filepath = Configuration.featureSubDirectory + fileName;
                System.out.println("Path is " + filepath);
                List<String> raw = java.nio.file.Files.readAllLines(java.nio.file.Paths.get(filepath));
                for (String line : raw) {
                    if (line.startsWith("Include")) {
                        String[] parts = line.split("\"");
                        trace("Parts are " + String.join(", ", parts));
                        if (parts.length < 2) {
                            error("Error filename not surrounded by quotes: " + line);
                            continue;
                        }
                        if (parts[1].isEmpty()) {
                            error("Error zero length filename " + line);
                            continue;
                        }
                        String includedFileName = parts[1].trim();
                        trace("Including " + includedFileName);
                        if (includedFileName.endsWith(".csv")) {
                            includeCSVFile(includedFileName);
                        } else {
                            readFile(includedFileName, includeCount);
                        }
                    } else {
                        if (!line.isEmpty() && line.charAt(0) != '#') {
                            linesIn.add(line.trim());
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            includeCount--;
        }

        private void includeCSVFile(String includedFileName) {
            try {
                List<String> raw = java.nio.file.Files.readAllLines(java.nio.file.Paths.get(Configuration.featureSubDirectory + includedFileName));
                for (String line : raw) {
                    if (line.isEmpty()) continue;
                    String contents = convertCSVtoTable(line);
                    linesIn.add(contents.trim());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public String convertCSVtoTable(String csvData) {
            String[] lines = csvData.split("\n");
            List<List<String>> data = new ArrayList<>();
            for (String line : lines) {
                data.add(parseCsvLine(line));
            }
            List<String> formattedData = new ArrayList<>();
            for (List<String> row : data) {
                formattedData.add("|" + String.join("|", row) + "|");
            }
            return String.join("\n", formattedData);
        }

        public List<String> parseCsvLine(String line) {
            List<String> result = new ArrayList<>();
            StringBuilder current = new StringBuilder();
            boolean inQuotes = false;

            int length = line.length();
            for (int i = 0; i < length; i++) {
                char c = line.charAt(i);
                if (c == '"') {
                    if (inQuotes && i + 1 < length && line.charAt(i + 1) == '"') {
                        current.append('"');
                        i++;
                    } else {
                        inQuotes = !inQuotes;
                    }
                } else if (c == ',' && !inQuotes) {
                    result.add(current.toString());
                    current.setLength(0);
                } else {
                    current.append(c);
                }
            }
            result.add(current.toString());
            return result;
        }

        public String peek() {
            if (index < linesIn.size()) {
                return linesIn.get(index);
            } else {
                return EOF;
            }
        }

        public String next() {
            if (index < linesIn.size()) {
                return linesIn.get(index++);
            } else {
                return EOF;
            }
        }

        private void trace(String value) {
            if (Configuration.traceOn) {
                System.out.println(value);
            }
        }

        private void error(String value) {
            System.out.println("*** " + value);
        }
    }

    static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getFirst() {
            return key;
        }

        public V getSecond() {
            return value;
        }

        @Override
        public String toString() {
            return "Pair{" + "key=" + key + ", value=" + value + '}';
        }
    }

    private void endUp()
    {
        if (finalCleanup) {
            testPrint("        test_Cleanup(); // at the end ");
        }
        testPrint("        }");   // End last scenario
        testPrint("    }"); // End the class
        testPrint("");
        try {
            testFile.close();
         } catch (IOException e) {
            error("Error in closing ");
        }

        templateConstruct.endTemplate();
    }

    class StepConstruct {
        private void actOnStep(String fullName, List<String> comment) {
            stepNumberInScenario += 1;
            Pair<String, List<String>> follow = lookForFollow();
            String followType = follow.getFirst();
            List<String> table = follow.getSecond();
            testPrint("");
            switch (followType) {
                case "TABLE":
                    createTheTable(comment, table, fullName);
                    break;
                case "NOTHING":
                    noParameter(fullName);
                    break;
                case "STRING":
                    createTheStringCode(comment, table, fullName);
                    break;
            }
        }


        private void createTheStringCode(List<String> comment, List<String> table, String fullName) {
            String option = "String";
            if (comment.size() > 0 && !comment.get(0).isEmpty()) option = comment.get(0);
            if (option.equals("ListOfString")) stringToList(table, fullName);
            else stringToString(table, fullName);
        }

        private void stringToList(List<String> table, String fullName) {
            String s = Integer.toString(stepNumberInScenario);
            String dataType = "List<String>";
            String dataTypeInitializer = "List.of";
            testPrint("        List<String> stringList" + s + " = " + dataTypeInitializer + "(");
            String comma = "";
            for (String line : table) {
                testPrint("            " + comma +"\"" + line + "\"");
                comma = ",";
            }
            testPrint("            );");
            testPrint("        " + glueObject + "." + fullName + "(stringList" + s + ");");
            templateConstruct.makeFunctionTemplate(dataType, fullName,true, "String");
        }

        private void stringToString(List<String> table, String fullName) {
            String s = Integer.toString(stepNumberInScenario);
            testPrint("        String string" + s + " =");
            testPrint("            \"\"\"");
            for (String line : table) {
                testPrint("            " + line);
            }
            testPrint("            \"\"\".stripIndent();");
            testPrint("        " + glueObject + "." + fullName + "(string" + s + ");");
            templateConstruct.makeFunctionTemplate("String", fullName, false, "");
        }

        private void tableToListOfList(List<String> table, String fullName) {
            String s = Integer.toString(stepNumberInScenario);
            String dataType = "List<List<String>>";
            String dataTypeInitializer = "List.of";

            testPrint("        List<List<String>> stringListList" + s + " = " + dataTypeInitializer + "(");
            String comma = "";
            for (String line : table) {
                convertBarLineToList(line, comma);
                comma = ",";
            }
            testPrint("            );");
            testPrint("        " + glueObject + "." + fullName + "(stringListList" + s + ");");
            templateConstruct.makeFunctionTemplate(dataType, fullName, true, "List<String>");
        }

//        Need to think about the use of this
//        private void tableToListOfListOfObject(List<String> table, String fullName, String objectName) {
//            String s = Integer.toString(stepNumberInScenario);
//            String dataType = "List<List<" + objectName + ">>";
//            String dataTypeInitializer = "Arrays.asList";
//
//            testPrint("        List<List<" + objectName + ">> objectListList" + s + " = " + dataTypeInitializer + "(");
//            for (String line : table) {
//                convertBarLineToListOfObject(line, objectName);
//            }
//            testPrint("            );");
//            testPrint("        " + glueObject + "." + fullName + "(objectListList" + s + ");");
//            templateConstruct.makeFunctionTemplate(dataType, fullName);
//        }


        private void createTheTable(List<String> comment, List<String> table, String fullName) {
            String option = "ListOfList";
            if (comment.size() > 0 && !comment.get(0).isEmpty()) option = comment.get(0);
            if (option.equals("ListOfList")) {
//                if (comment.size() > 1 && !comment.get(1).isEmpty()) {
//                    String objectName = comment.get(1);
//                    tableToListOfListOfObject(table, fullName, objectName);
//                } else {
                    tableToListOfList(table, fullName);
//                }
            } else if (option.equals("String") || option.equals("string")) {
                tableToString(table, fullName);
            } else if (option.equals("ListOfObject")) {
                if (comment.size() < 2) {
                    error("No class name specified");
                    return;
                }

                String className = comment.get(1);
                boolean transpose = false;
                boolean compare = false;
                if (comment.size() > 2) {
                    String action = comment.get(2);
                    if (action.equals("compare") || action.equals("Compare"))
                        compare = true;
                    else if (!(action.equals("transpose") || action.equals("Transpose"))) {
                        error("Action not recognized " + action);
                    } else {
                        transpose = true;
                    }
                }
                tableToListOfObject(table, fullName, className, transpose, compare);
            } else {
                error("Option not found, default to ListOfList " + option);
                tableToListOfList(table, fullName);
            }
        }


        private void tableToString(List<String> table, String fullName) {
            String s = Integer.toString(stepNumberInScenario);
            testPrint("        String table" + s + " = ");
            testPrint("            \"\"\"");
            for (String line : table) {
                testPrint("            " + line);
            }
            testPrint("            \"\"\".stripIndent();");
            testPrint("        " + glueObject + "." + fullName + "(table" + s + ");");
            // test_print("");
            templateConstruct.makeFunctionTemplate("String", fullName, false, "");
        }

        private void convertBarLineToList(String line, String commaIn) {

            testPrint("           " + commaIn + "List.of(");
            List<String> elements = parseLine(line);
            String comma = "";
            for (String element : elements) {
                testPrint("            " + comma + "\""+ element +"\"");
                comma = ",";
            }
            testPrint("            )");
        }

//        private void convertBarLineToListOfObject(String line, String objectName) {
//            testPrint("           listOf<" + objectName + ">(");
//            List<String> elements = parseLine(line);
//            for (String element : elements) {
//                testPrint("            " + objectName + "(\"" + element + "\"),");
//            }
//            testPrint("            ),");
//        }

        private void tableToListOfObject(List<String> table, String fullName, String className, boolean transpose, boolean compare) {
            trace("TableToListOfObject classNames " + className);
            String s = Integer.toString(stepNumberInScenario);
            String dataType = "List<" + className + ">";
            String dataTypeInitializer = "List.of(";
            //(List.of(
            testPrint("        List<" + className + "> objectList" + s + " = " + dataTypeInitializer + "");
            boolean inHeaderLine = true;
            List<List<String>> dataList = convertToListList(table, transpose);
            List<String> headers = new ArrayList<>();
            String comma = "";
            for (List<String> row : dataList) {
                if (inHeaderLine) {
                    headers = row;
                    inHeaderLine = false;
                    continue;
                }
                List<String> values = row;

                convertBarLineToParameter(headers, values, className, comma, compare);
                comma = ",";
            }
            testPrint("            );");
            testPrint("        " + glueObject + "." + fullName + "(objectList" + s + ");");
            templateConstruct.makeFunctionTemplate(dataType, fullName, true, className);
        }

        private List<List<String>> convertToListList(List<String> table, boolean transpose) {
            List<List<String>> temporary = new ArrayList<>();
            for (String line : table) {
                temporary.add(parseLine(line));
            }
            List<List<String>> result = temporary;
            if (transpose) {
                result = transpose(temporary);
            }
            return result;
        }

        private void convertBarLineToParameter(List<String> headers, List<String> values, String className, String comma, boolean compare) {
            trace("Headers " + headers);
            int size = headers.size();
            if (headers.size() > values.size()) {
                size = values.size();
                error("not sufficient values, using what is there" + values);
            }
            testPrint("            "+ comma +" new " + className + ".Builder()");
            if (compare)
                testPrint("             .setCompare()");
            for (int i = 0; i < size; i++) {
                String value = "\"" + values.get(i).replace(Configuration.spaceCharacters, ' ') + "\"";
                testPrint("                ." + makeName(headers.get(i)) + "(" + value + ")");
            }
            testPrint("                .build()");
            testPrint("                ");
        }

        private void noParameter(String fullName) {
            testPrint("        " + glueObject + "." + fullName + "();");
            templateConstruct.makeFunctionTemplate("", fullName, false, "");
        }






        public List<List<String>> transpose(List<List<String>> matrix) {
            List<List<String>> transposed = new ArrayList<>();
            for (int i = 0; i < matrix.get(0).size(); i++) {
                List<String> row = new ArrayList<>();
                for (int j = 0; j < matrix.size(); j++) {
                    row.add(matrix.get(j).get(i));
                }
                transposed.add(row);
            }
            return transposed;
        }


    }
    class TemplateConstruct {
//        private final String glueTemplateFilename = basePath + "Glue" + ".tmp";
        private FileWriter glueTemplateFile;
        private void templatePrint(String line) {
            try {
                glueTemplateFile.write(line);
                glueTemplateFile.write("\n");
            } catch (IOException e) {
                System.out.println("IO ERROR");
            }
        }
        private void makeFunctionTemplate(String dataType, String fullName, boolean isList, String listElement) {
            if (glueFunctions.containsKey(fullName)) {
                String currentDataType = glueFunctions.get(fullName);
                if (!currentDataType.equals(dataType)) {
                    error("function " + fullName + " datatype " + currentDataType + " not equals " + dataType);
                    return;
                }
                return; // already have a prototype
            }
            glueFunctions.put(fullName, dataType);
            if (dataType.isEmpty()) {
                templatePrint("    void " + fullName + "(){");
            } else {
                templatePrint("    void " + fullName + "(" + dataType + " value ) {");
            }
            templatePrint("        System.out.println(\"---  \" + " + "\"" +fullName +"\"" + ");");
            templatePrint("        System.out.println(\"*******\");");
            if (Configuration.inTest)
            {
                templatePrint("        log(\"---  \" + " + "\"" +fullName +"\"" + ");");
                templatePrint("        log(\"*******\");");
            if (!dataType.isEmpty()) {
                    templatePrint("        log(value.toString());");
                }
            }
            if (!dataType.isEmpty()) {
                templatePrint("        System.out.println(value);");
                if (isList) {
                    templatePrint("        for (" + listElement + " v : value){");
                    templatePrint("           System.out.println(v);");
//                    if (!dataType.equals("List<List<String>>")) {
//                        templatePrint("           " + listElement + "Internal i = v.to" + listElement + "Internal();");
//                        templatePrint("           System.out.println(i);");
//                    }
                    templatePrint("              };");
                }
            }
            if (!Configuration.inTest)
                templatePrint("        fail(\"Must implement\");");
            templatePrint("    }");
            templatePrint("");
        }
        private void beginTemplate() {
            templatePrint("package " + Configuration.packageName + "." + featureName + ";");
            templatePrint("import static org.junit.Assert.fail;");
            templatePrint("import static org.junit.jupiter.api.Assertions.assertEquals;");                    templatePrint("import java.util.List;");
            if (Configuration.inTest) {
                templatePrint("import java.io.FileWriter;");
                templatePrint("import java.io.IOException;");
            }           templatePrint("");
            templatePrint("class " + glueClass + " {");
            templatePrint(logIt(directoryName));

            templatePrint("");
        }
        private void endTemplate() {
            templatePrint("    }");   // End the class
            try {
                testFile.close();
                glueTemplateFile.close();
            } catch (IOException e) {
                error("Error in closing ");
            }
        }

    }
    class DataConstruct {
//        private final String dataDefinitionFilename = basePath + "DataDefinition" + ".tmp";
        private FileWriter dataDefinitionFile;

        public static class DataValues {
            public final String name;
            public final String defaultVal;
            public final String dataType;
            public final String notes;

            public DataValues(String name, String defaultVal, String dataType, String notes) {
                this.name = name;
                this.defaultVal = defaultVal;
                this.dataType = dataType;
                this.notes = notes;
            }

            public DataValues(String name, String defaultVal, String dataType) {
                this(name, defaultVal, dataType, "");
            }

            public DataValues(String name, String defaultVal) {
                this(name, defaultVal, "String", "");
            }
        }

        enum MakeDataValue {Name, Value}

        private void actOnData(List<String> words) {
            String internalClassName = "";
            if (words.size() < 2) {
                error("Need to specify data class name");
            }
            String className = words.get(1);
            if (words.size() > 2) internalClassName = words.get(2);
            else internalClassName = className + "Internal";
            Pair<String, List<String>> follow = lookForFollow();
            String followType = follow.getFirst();
            List<String> table = follow.getSecond();
            if (!followType.equals("TABLE")) {
                error("Error table does not follow data " + words.get(0) + " " + words.get(1));
                return;
            }
            if (dataNames.containsKey(className)) {
                error("Data name is duplicated, has been renamed " + className);
                className += stepCount;
            }
            trace("Creating class for " + className);
            dataNames.put(className, "");
            // Put each in a new file
            startDataFile(className);

            dataPrintLn("package " + Configuration.packageName + "." + featureName + ";");
            dataPrintLn("class " + className + "{");
            List<DataValues> variables = new ArrayList<>();
            boolean doInternal = createVariableList(table, variables);
            for (DataValues variable : variables) {
                dataPrintLn("    String " + makeName(variable.name) + " = \"" + variable.defaultVal + "\";");
            }
            createConstructor(variables, className);
            createEqualsMethod(variables, className);
            createBuilderMethod(variables, className);
            createToStringMethod(variables, className);
            if (doInternal)
                createConversionMethod(internalClassName, variables);
            dataPrintLn("    }");
            endDataFile();
            if (doInternal) {
                createInternalClass(internalClassName, className, variables);
            }
        }

        private void endDataFile() {
            try {
                dataDefinitionFile.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private void startDataFile(String className) {
            String dataDefinitionPathname = Configuration.testSubDirectory + featureName + "/" + className
                    + "." + Configuration.dataDefinitionFileExtension;
            System.out.println("Printing data on " + dataDefinitionPathname);
            try {
                dataDefinitionFile = new FileWriter(dataDefinitionPathname, false);
            } catch (IOException e) {
                error("IO Exception in setting up the files");
                error(" Writing " + dataDefinitionPathname);

            }
        }

        private void createConstructor(List<DataValues> variables, String className) {
            dataPrintLn("    public " + className + "(");
            String comma = "";
            for (DataValues variable : variables) {
                dataPrintLn("        " + comma + "String " + makeName(variable.name));
                comma = ",";
            }
            dataPrintLn("        ){");
            for (DataValues variable : variables) {
                dataPrintLn("        this." + makeName(variable.name) + " = " + makeName(variable.name) + ";");
            }
            dataPrintLn("        }");
        }

        private void createInternalConstructor(List<DataValues> variables, String className) {
            dataPrintLn("    public " + className + "(");
            String comma = "";
            for (DataValues variable : variables) {
                dataPrintLn("        " + comma + variable.dataType + " " + makeName(variable.name));
                comma = ",";
            }
            dataPrintLn("        ){");
            for (DataValues variable : variables) {
                dataPrintLn("        this." + makeName(variable.name) + " = " + variable.name + ";");
            }
            dataPrintLn("        }");
        }

        private void createToStringMethod(List<DataValues> variables, String className) {
            dataPrintLn("    @Override");
            dataPrintLn("    public String toString() {");
            dataPrintLn("        return " + quoteIt(className + " {"));
            String add = "+";

            for (DataValues variable : variables) {
                dataPrintLn("        " + add + quoteIt(makeName(variable.name) + " = ") + " + " + makeName(variable.name) + " + " + quoteIt(" "));
            }
            dataPrintLn("            + " + quoteIt("} ") + "; }  ");

        }

        private void createBuilderMethod(List<DataValues> variables, String className) {
            dataPrintLn("    public static class Builder {");
            for (DataValues variable : variables) {
                dataPrintLn("        private String " + variable.name + " = " + quoteIt(variable.defaultVal) + ";");
            }
            for (DataValues variable : variables) {
                dataPrintLn("        public Builder " + variable.name + "(String " + variable.name + ") {");
                dataPrintLn("            this." + variable.name + " = " + variable.name + ";");
                dataPrintLn("            return this;");
                dataPrintLn("            }");
            }
            dataPrintLn("        public " + "Builder " + " setCompare() {");
            for (DataValues variable : variables) {
                dataPrintLn("            " + variable.name + " = " + quoteIt(Configuration.doNotCompare) + ";");
            }
            dataPrintLn("            return this;");
            dataPrintLn("            }");

            dataPrintLn("        public " + className + " build(){");
            dataPrintLn("             return new " + className + "(");
            String comma = "";
            for (DataValues variable : variables) {
                dataPrintLn("                 " + comma + variable.name);
                comma = ",";
            }
            dataPrintLn("                );   } ");
            dataPrintLn("        } ");
        }

        private String quoteIt(String defaultVal) {
            return "\"" + defaultVal + "\"";
        }

        private void createEqualsMethod(List<DataValues> variables, String className) {
            dataPrintLn("    @Override");
            dataPrintLn("    public boolean equals (Object o) {");
            dataPrintLn("        if (this == o) return true;");
            dataPrintLn("            if (o == null || getClass() != o.getClass()) return false;");
            String variableName = "_" + className;
            dataPrintLn("            " + className + " " + variableName + " = (" + className + ") o;");
            for (DataValues variable : variables) {
                dataPrintLn("            if (");
                dataPrintLn("                !this." + variable.name + ".equals(" + quoteIt(Configuration.doNotCompare) + ")");
                dataPrintLn("                && !" + variableName + "." + variable.name + ".equals(" + quoteIt(Configuration.doNotCompare) + "))");
                dataPrintLn("                    if (! " + variableName + "." + variable.name + ".equals(this." + variable.name + "))");
                dataPrintLn("                        return false;");
            }
            dataPrintLn("             return true;  }");
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            ATest aTest = (ATest) o;
//            return
            //          if (!aTest.anInt.equals(Configuration. ..   && !
//                        if (!aTest.anInt.equals(anInt) return false;
//                            aTest.equals(aString) &&
//                            aTest.equals(aDouble);
//
        }

        private void createConversionMethod(String internalClassName, List<DataValues> variables) {

            dataPrintLn("    " + internalClassName + " to" + internalClassName + "() " + "{");
            dataPrintLn("        return new " + internalClassName + "(");
            String comma = "";
            for (DataValues variable : variables) {
                String initializer = makeValueFromString(variable, MakeDataValue.Name);
                System.out.println(" Initializing " + initializer);
                dataPrintLn("        " + comma + " " + initializer);
                comma = ",";
            }
            dataPrintLn("        ); }"); // end function

        }

        private String makeValueFromString(DataValues variable, MakeDataValue which) {
            String value = "NOT DETERMINED";
            if (which == MakeDataValue.Name)
                value = makeName(variable.name);
            else if (which == MakeDataValue.Value)
                value = quoteIt(variable.defaultVal);
            System.out.println("Data type " + variable.dataType);
            switch (variable.dataType) {
                case "String":
                    return value;
                case "int":
                    return "Integer.parseInt(" + value + ")";
                case "double":
                    return "Double.parseDouble(" + value + ")";
                case "byte":
                    return "Byte.parseByte(" + value + ")";
                case "short":
                    return "Short.parseShort(" + value + ")";
                case "long":
                    return "Long.parseLong(" + value + ")";
                case "float":
                    return "Float.parseFloat(" + value + ")";
                case "boolean":
                    return "Boolean.parseBoolean(" + value + ")";
                case "char":
                    return "( " + value + ".length() > 0 ?"
                            + value + ".charAt(0) : ' ')";
                case "Byte":
                    return "Byte.valueOf(" + value + ")";
                case "Short":
                    return "Short.valueOf(" + value + ")";
                case "Integer":
                    return "Integer.valueOf(" + value + ")";
                case "Long":
                    return "Long.valueOf(" + value + ")";
                case "Float":
                    return "Float.valueOf(" + value + ")";
                case "Double":
                    return "Double.valueOf(" + value + ")";
                case "Boolean":
                    return "Boolean.valueOf(" + value + ")";
                case "Character":
                    return "Character.valueOf( " + value + ".length() > 0 ?"
                            + value + ".charAt(0) : ' ')";
                default:
                    return makeName(variable.name) + "// Data type not found";

            }
        }

        private boolean createVariableList(List<String> table, List<DataValues> variables) {
            boolean headerLine = true;
            boolean doInternal = false;
            for (String line : table) {
                if (headerLine) {
                    List<String> headers = parseLine(line);
                    checkHeaders(headers);
                    headerLine = false;

                    if (headers.size() > 2) doInternal = true;
                    continue;
                }
                List<String> elements = parseLine(line);
                if (elements.size() < 2) {
                    error(" Data line has less than 2 entries " + line);
                    continue;
                }
                if (elements.size() > 3)
                    variables.add(new DataValues(makeName(elements.get(0)), elements.get(1), alterDataType(elements.get(2)), elements.get(3)));
                else if (elements.size() > 2)
                    variables.add(new DataValues(makeName(elements.get(0)), elements.get(1), alterDataType(elements.get(2))));
                else variables.add(new DataValues(makeName(elements.get(0)), elements.get(1)));
            }
            return doInternal;
        }

        private String alterDataType(String s) {
            // Will need to be altered to language specific types
            switch (s) {
                case "Int":
                    return "Integer";
                case "Char":
                    return "Character";
                default:
                    return s;
            }
        }

        private void checkHeaders(List<String> headers) {
            List<String> expected = List.of("Name", "Default", "Datatype", "Notes");
            if (!(headers.get(0).equals(expected.get(0)) && headers.get(1).equals(expected.get(1)))) {
                error("Headers should start with " + expected);
            }
        }

        private void createInternalClass(String className, String otherClassName, List<DataValues> variables) {
            String classNameInternal = className;
            if (dataNames.containsKey(classNameInternal)) {
                error("Data name is duplicated, has been renamed " + classNameInternal);
                classNameInternal += stepCount;
            }
            trace("Creating internal class for " + classNameInternal);
            dataNames.put(classNameInternal, "");
            startDataFile(className);
            dataPrintLn("package " + Configuration.packageName + "." + featureName + ";");
            dataPrintLn("class " + className + "{");
            for (DataValues variable : variables) {
                dataPrintLn("     " + variable.dataType + " " + makeName(variable.name) + " = " + makeValueFromString(variable, MakeDataValue.Value) + ";");
            }
            dataPrintLn("     ");

            createToStringObject(otherClassName, variables);
            createInternalConstructor(variables, className);
            createToStringMethod(variables, className);

            dataPrintLn("    }"); // end class
            endDataFile();
        }

        private void createToStringObject(String otherClassName, List<DataValues> variables) {
            dataPrintLn("    " + otherClassName + " to" + otherClassName + "() " + "{");
            dataPrintLn("        return new " + otherClassName + "(");
            String comma = "";
            for (DataValues variable : variables) {
                // **** Need to create one that uses Double.toString(value), etc.
                String method = makeValueToString(variable, MakeDataValue.Name);
                dataPrintLn("        " + comma + method);
                comma = ",";
            }
            dataPrintLn("        ); }"); // end function
        }

        private String makeValueToString(DataValues variable, MakeDataValue which) {
            String value = "NOT DETERMINED";
            if (which == MakeDataValue.Name)
                value = makeName(variable.name);
            else if (which == MakeDataValue.Value)
                value = quoteIt(variable.defaultVal);
            System.out.println("Data type " + variable.dataType);
            switch (variable.dataType) {
                case "String":
                    return value;
                case "int":
                case "double":
                case "byte":
                case "short":
                case "long":
                case "float":
                case "boolean":
                case "char":
                case "Byte":
                case "Short":
                case "Integer":
                case "Long":
                case "Float":
                case "Double":
                case "Boolean":
                case "Character":
                    return "String.valueOf(" + value + ")";
                default:
                    return value + ".toString()";

            }
        }


        private void dataPrintLn(String line) {
            try {
                dataDefinitionFile.write(line);
                dataDefinitionFile.write("\n");
            } catch (IOException e) {
                error("IO ERROR");
            }
        }
    }

    static class Configuration {

        public static final boolean  inTest = true;  // switch to true for development of Translator
        public static final boolean traceOn = true; // Set to true to see trace
        public static final char spaceCharacters = '~'; // Will replace with space in tables

        public static final String doNotCompare = "?DNC?";  // Value used for not comparing an attribute
        public static String currentDirectory = "";
        public static final String featureSubDirectory = "src/test/java/";
        public static final String packageName = "gherkinexecutor";
        public static final String testSubDirectory = "src/test/java/" + packageName + "/";
        public static final String dataDefinitionFileExtension = "java"; // "tmpl"; // change to java if altering data file
        public static final List<String> featureFiles = new ArrayList<>();

        static {
//            featureFiles.add("SimpleTest.feature");
              featureFiles.add("background.feature");
              featureFiles.add("examples.feature");
              featureFiles.add("ParseCSV.feature");
              featureFiles.add("tablesandstrings.feature");
              featureFiles.add("fulltest.feature");
              featureFiles.add("include.feature");
              featureFiles.add("datatype.feature");
              featureFiles.add("tictactoe.feature");
              featureFiles.add("data_definition.feature");
//                featureFiles.add("GherkinTranslatorFullTest.feature");
        }
    }
}




import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Translate {
    private Map<String, String> scenarios = new HashMap<>(); // used to check if duplicate scenario names
    private Map<String, String> glueFunctions = new HashMap<>(); // used to make sure only one glue implementation
    private Map<String, String> dataNames = new HashMap<>(); // used to check for duplicate data
    private int stepCount = 0; // use to label duplicate scenarios
    private String basePath = Configuration.testSubDirectory;
    private String glueClass = "";  // glue class name
    private String glueObject = "";  // glue object name
    private int stepNumberInScenario = 0;  // use to label variables in scenario
    private InputIterator dataIn = new InputIterator("");
    private boolean firstScenario = true; // If first scenario
    private boolean background = false;  // Have seen background
    private boolean cleanup = false; // Have seen cleanup

    // Create the output files, save names for deletions
    private String testFilename = basePath + "Test" + ".tmp";
    private FileWriter testFile;

    // private FileWriter aTestFile;  - to not create tmp file
    private String glueTemplateFilename = basePath + "Glue" + ".tmp";
    private FileWriter glueTemplateFile;
    private String dataDefinitionFilename = basePath + "DataDefinition" + ".tmp";
    private FileWriter dataDefinitionFile;
    private boolean featureActedOn = false; // Have found a feature step

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


    private void actOnKeyword(String keyword, List<String> words, List<String> comment) {
        String fullName = String.join("_", words);
        trace("Act on keyword " + keyword + " " + fullName);
        switch (keyword) {
            case "Feature":
                actOnFeature(fullName);
                break;
            case "Scenario":
                actOnScenario(fullName, true);
                break;
            case "Background":
                actOnScenario(fullName, false);
                background = true;
                break;
            case "Cleanup":
                actOnScenario(fullName, false);
                cleanup = true;
                break;
            case "Given":
            case "When":
            case "Then":
            case "And":
            case "Star":
            case "Arrange":
            case "Act":
            case "Assert":
                actOnStep(fullName, comment);
                break;
            case "Data":
                actOnData(words);
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
        String featureName = fullName;
        featureActedOn = true;
        String testPathname = Configuration.testSubDirectory + featureName + "/" + featureName + ".java";
        System.out.println(" Writing " + testPathname);
        String dataDefinitionPathname = Configuration.testSubDirectory + featureName + "/" + featureName + "_data." + Configuration.dataDefinitionFileExtension;
        String templateFilename = Configuration.testSubDirectory + featureName + "/" + featureName + "_glue.tmpl";
//        cleanFiles();
        try {
            System.out.println();
            String directoryName = Configuration.testSubDirectory + featureName;
            boolean result = new File(directoryName).mkdirs();
            System.out.println("Directory " + directoryName + " " + result);
            testFile = new FileWriter(testPathname, false);
            glueTemplateFile = new FileWriter(templateFilename, false);
            trace(" Writing " + dataDefinitionPathname);
            dataDefinitionFile = new FileWriter(dataDefinitionPathname, false);
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

        testPrint("@TestInstance(TestInstance.Lifecycle.PER_CLASS)");
        testPrint("class " + fullName + "{");
        testPrint("");

        templatePrint("package " + Configuration.packageName + "." + featureName + ";");
        templatePrint("import kotlin.test.fail;");
        templatePrint("");
        templatePrint("class " + glueClass + " {");
        templatePrint("");
        dataDefinitionPrint("package " + Configuration.packageName + "." + featureName);
    }

    private String makeName(String input) {
        if (input.isEmpty()) return "NAME_IS_EMPTY";
        String temp = input.replace(' ', '_');
        return temp.charAt(0) + temp.substring(1);
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



    private void actOnScenario(String fullName, boolean addBackground) {
        String fullNameToUse = fullName;
        if (scenarios.containsKey(fullName)) {
            fullNameToUse += stepCount;
            error("Scenario name duplicated renamed " + fullNameToUse);
        } else {
            scenarios.put(fullNameToUse, "");
        }
        stepNumberInScenario = 0;
        if (firstScenario) {
            firstScenario = false;
        } else {
            if (cleanup && addBackground) {
                testPrint("        test_Cleanup()");
            }
            testPrint("        }"); // end previous scenario
        }
        testPrint("    @Test");
        testPrint("    void test_" + fullNameToUse + "(){");
        testPrint("         " + glueClass + " " + glueObject + " = " + glueClass + "()");
        if (background && addBackground) {
            testPrint("        test_Background()");
        }
    }

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

    private void createTheStringCode(List<String> comment, List<String> table, String fullName) {
        String option = "String";
        if (comment.size() > 0 && !comment.get(0).isEmpty()) option = comment.get(0);
        if (option.equals("ListOfString")) stringToList(table, fullName);
        else stringToString(table, fullName);
    }

    private void stringToList(List<String> table, String fullName) {
        String s = Integer.toString(stepNumberInScenario);
        String dataType = "List<String>";
        String dataTypeInitializer = "Arrays.asList";

        testPrint("        List<String> stringList" + s + " = " + dataTypeInitializer + "(");
        for (String line : table) {
            testPrint("            \"" + line + "\",");
        }
        testPrint("            );");
        testPrint("        " + glueObject + "." + fullName + "(stringList" + s + ");");
        makeFunctionTemplate(dataType, fullName);
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
        makeFunctionTemplate("String", fullName);
    }

    private void tableToListOfList(List<String> table, String fullName) {
        String s = Integer.toString(stepNumberInScenario);
        String dataType = "List<List<String>>";
        String dataTypeInitializer = "Arrays.asList";

        testPrint("        List<List<String>> stringListList" + s + " = " + dataTypeInitializer + "(");
        for (String line : table) {
            convertBarLineToList(line);
        }
        testPrint("            );");
        testPrint("        " + glueObject + "." + fullName + "(stringListList" + s + ");");
        makeFunctionTemplate(dataType, fullName);
    }

    private void tableToListOfListOfObject(List<String> table, String fullName, String objectName) {
        String s = Integer.toString(stepNumberInScenario);
        String dataType = "List<List<" + objectName + ">>";
        String dataTypeInitializer = "Arrays.asList";

        testPrint("        List<List<" + objectName + ">> objectListList" + s + " = " + dataTypeInitializer + "(");
        for (String line : table) {
            convertBarLineToListOfObject(line, objectName);
        }
        testPrint("            );");
        testPrint("        " + glueObject + "." + fullName + "(objectListList" + s + ");");
        makeFunctionTemplate(dataType, fullName);
    }


    private boolean createTheTable(List<String> comment, List<String> table, String fullName) {
        String option = "ListOfList";
        if (comment.size() > 0 && !comment.get(0).isEmpty()) option = comment.get(0);
        if (option.equals("ListOfList")) {
            if (comment.size() > 1 && !comment.get(1).isEmpty()) {
                String objectName = comment.get(1);
                tableToListOfListOfObject(table, fullName, objectName);
            } else {
                tableToListOfList(table, fullName);
            }
        } else if (option.equals("String") || option.equals("string")) {
            tableToString(table, fullName);
        } else if (option.equals("ListOfObject")) {
            if (comment.size() < 2) {
                error("No class name specified");
                return true;
            }

            String className = comment.get(1);
            boolean transpose = false;
            if (comment.size() > 2) {
                String action = comment.get(2);
                if (!(action.equals("transpose") || action.equals("Transpose"))) {
                    error("Action not recognized " + action);
                } else {
                    transpose = true;
                }
            }
            tableToListOfObject(table, fullName, className, transpose);
        } else {
            error("Option not found, default to ListOfList " + option);
            tableToListOfList(table, fullName);
        }
        return false;
    }


    private void tableToString(List<String> table, String fullName) {
        String s = Integer.toString(stepNumberInScenario);
        testPrint("        val table" + s + " =");
        testPrint("            \"\"\"");
        for (String line : table) {
            testPrint("            " + line);
        }
        testPrint("            \"\"\".trimIndent()");
        testPrint("        " + glueObject + "." + fullName + "(table" + s + ")");
        // test_print("");
        makeFunctionTemplate("String", fullName);
    }

    private void convertBarLineToList(String line) {
        testPrint("           listOf<String>(");
        List<String> elements = parseLine(line);
        for (String element : elements) {
            testPrint("            \"" + element + "\",");
        }
        testPrint("            ),");
    }

    private void convertBarLineToListOfObject(String line, String objectName) {
        testPrint("           listOf<" + objectName + ">(");
        List<String> elements = parseLine(line);
        for (String element : elements) {
            testPrint("            " + objectName + "(\"" + element + "\"),");
        }
        testPrint("            ),");
    }

    private void tableToListOfObject(List<String> table, String fullName, String className, boolean transpose) {
        trace("TableToListOfObject classNames " + className);
        String s = Integer.toString(stepNumberInScenario);
        String dataType = "List<" + className + ">";
        String dataTypeInitializer = "List.of(";
        //(List.of(
        testPrint("        List<" + className + "> objectList" + s + " = " + dataTypeInitializer + "");
        boolean inHeaderLine = true;
        List<List<String>> dataList = convertToListList(table, transpose);
        List<String> headers = new ArrayList<>();
        for (List<String> row : dataList) {
            if (inHeaderLine) {
                headers = row;
                inHeaderLine = false;
                continue;
            }
            List<String> values = row;
            convertBarLineToParameter(headers, values, className);
        }
        testPrint("            )");
        testPrint("        " + glueObject + "." + fullName + "(objectList" + s + ")");
        makeFunctionTemplate(dataType, fullName);
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

    private void convertBarLineToParameter(List<String> headers, List<String> values, String className) {
        trace("Headers " + headers);
        int size = headers.size();
        if (headers.size() > values.size()) {
            size = values.size();
            error("not sufficient values, using what is there" + values);
        }

        testPrint("            new " + className + ".Builder()");
        for (int i = 0; i < size; i++) {
            String value = "\"" + values.get(i).replace(Configuration.spaceCharacters, ' ') + "\"";
            testPrint("                ." + makeName(headers.get(i)) + "(" + value + ")");
        }
        testPrint("                ),");
    }

    private void noParameter(String fullName) {
        testPrint("        " + glueObject + "." + fullName + "()");
        makeFunctionTemplate("", fullName);
    }

    private void makeFunctionTemplate(String dataType, String fullName) {
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
            templatePrint("    fun " + fullName + "(){");
        } else {
            templatePrint("    fun " + fullName + "( value " + ": " + dataType + ") {");
        }
        templatePrint("        println(\"*******\")");
        if (!dataType.isEmpty()) {
            templatePrint("        println(value)");
        }
        templatePrint("        fail(\"Must implement\")");
        templatePrint("    }");
        templatePrint("");
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

    public static class DataValues {
        public String name;
        public String defaultVal;
        public String dataType;
        public String notes;

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
        dataDefinitionPrint("data class " + className + "(");
        List<DataValues> variables = new ArrayList<>();
        boolean doInternal = createVariableList(table, variables);
        for (DataValues variable : variables) {
            dataDefinitionPrint("    val " + makeName(variable.name) + ": String = \"" + variable.defaultVal + "\",");
        }

        dataDefinitionPrint("    )");

        if (doInternal) {
            createConversionMethod(internalClassName, variables);
            createInternalClass(internalClassName, className, variables);
        }
    }

    private void createConversionMethod(String internalClassName, List<DataValues> variables) {
        dataDefinitionPrint(" {");
        dataDefinitionPrint("    fun to" + internalClassName + "() : " + internalClassName + "{");
        dataDefinitionPrint("        return " + internalClassName + "(");
        for (DataValues variable : variables) {
            dataDefinitionPrint("        " + makeName(variable.name) + ".to" + variable.dataType + "(),");
        }
        dataDefinitionPrint("        ) }"); // end function

        dataDefinitionPrint("    }"); // end class
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
                variables.add(new DataValues(elements.get(0), elements.get(1), elements.get(2), elements.get(3)));
            else if (elements.size() > 2)
                variables.add(new DataValues(elements.get(0), elements.get(1), elements.get(2)));
            else variables.add(new DataValues(elements.get(0), elements.get(1)));
        }
        return doInternal;
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
        dataDefinitionPrint("data class " + classNameInternal + "(");
        for (DataValues variable : variables) {
            dataDefinitionPrint("    val " + makeName(variable.name) + ": " + variable.dataType + "= \"" + variable.defaultVal + "\".to" + variable.dataType + "(),");
        }
        dataDefinitionPrint("    ) {");
        dataDefinitionPrint("    fun to" + otherClassName + "() : " + otherClassName + "{");
        dataDefinitionPrint("        return " + otherClassName + "(");
        for (DataValues variable : variables) {
            dataDefinitionPrint("        " + makeName(variable.name) + ".toString(),");
        }
        dataDefinitionPrint("        ) }"); // end function

        dataDefinitionPrint("    }"); // end class
    }

    private void endUp() {
        if (cleanup) {
            testPrint("        test_Cleanup()");
        }
        testPrint("        }");   // End last scenario
        testPrint("    }"); // End the class
        testPrint("");
        templatePrint("    }");   // End the class
        try {
            testFile.close();
            glueTemplateFile.close();
            dataDefinitionFile.close();
        } catch (IOException e) {
            error("Error in closing ");
        }
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

    private static String wordWithOutColon(String word) {
        return word.replaceAll("^:+|:+$", "");
    }

    private static String wordWithOutHash(String word) {
        return word.replaceAll("^#+|#+$", "");
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
        }
    }

    private void templatePrint(String line) {
        try {
            glueTemplateFile.write(line);
            glueTemplateFile.write("\n");
        } catch (IOException e) {
        }
    }

    private void dataDefinitionPrint(String line) {
        try {
            dataDefinitionFile.write(line);
            dataDefinitionFile.write("\n");
        } catch (IOException e) {
        }
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

    class InputIterator {
        private List<String> linesIn = new ArrayList<>();
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

    class Pair<K, V> {
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

    static class Configuration {
        public static boolean traceOn = true; // Set to true to see trace
        public static char spaceCharacters = '^'; // Will replace with space in tables
        public static String currentDirectory = "";
        public static String featureSubDirectory = "src/test/java/";
        public static String packageName = "gherkinexecutor";
        public static String testSubDirectory = "src/test/java/" + packageName + "/";
        public static String dataDefinitionFileExtension = "tmpl"; // change to kt if altering data file
        public static List<String> featureFiles = new ArrayList<>();

        static {
            featureFiles.add("SimpleTest.feature");
//                featureFiles.add("tablesandstrings.feature");
//                featureFiles.add("data_definition.feature");
//                featureFiles.add("GherkinTranslatorFullTest.feature");
        }
    }

}


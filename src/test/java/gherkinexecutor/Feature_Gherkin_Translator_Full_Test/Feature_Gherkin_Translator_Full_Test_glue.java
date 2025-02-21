package gherkinexecutor.Feature_Gherkin_Translator_Full_Test;

import gherkinexecutor.Translate;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

class Feature_Gherkin_Translator_Full_Test_glue {
    String featureFileName = "";
    String subDirectory = "src/test/java/";

    void log(String value) {
        try {
            FileWriter myLog = new FileWriter("src/test/java/gherkinexecutor/Feature_Gherkin_Translator_Full_Test/log.txt", true);
            myLog.write(value + "\n");
            myLog.close();
        } catch (IOException e) {
            System.err.println("*** Cannot write to log ");
        }
    }


    void Given_feature_file_is(List<List<String>> values) {
        System.out.println("---  " + "Given_feature_file_is");
        log("---  " + "Given_feature_file_is");
        String currentDirectory = System.getProperty("user.dir");
        System.out.println("*** Current directory " + currentDirectory);
        featureFileName = values.get(0).get(0);
    }

    void When_translated() {
        System.out.println("---  " + "When_translated");
        log("---  " + "When_translated");
        System.out.println("*** Translating " + featureFileName);
        new Translate().translateInTests(featureFileName);

    }

    void Then_test_file_should_match_expected(List<FileNames> values) {
        System.out.println("---  " + "Then_test_file_should_match_expected");
        log("---  " + "Then_test_file_should_match_expected");

        try {
            // Step 2: Call Files.readAllLines() to read the file content

            System.out.println("*** Expected " + values.get(0).expected);
            System.out.println("*** Actual " + values.get(0).actual);
            Path filePathe = Paths.get(subDirectory + values.get(0).expected);
            System.out.println("filePathe " + filePathe);
            List<String> expected = Files.readAllLines(filePathe);
            Path filePatha = Paths.get(subDirectory + values.get(0).actual);
            System.out.println("filePatha " + filePatha);
            List<String> actual = Files.readAllLines(filePatha);
            assertEquals(expected, actual);
        } catch (IOException e) {
            System.err.println("File Read Error ");
        }
    }

    void And_glue_template_file_should_match_expected(List<FileNames> values) {
        System.out.println("---  " + "And_glue_template_file_should_match_expected");
        log("---  " + "And_glue_template_file_should_match_expected");
        System.out.println("***Expected " + values.get(0).expected);
        System.out.println("***Actual " + values.get(0).actual);
        try {
            Path filePathe = Paths.get(subDirectory + values.get(0).expected);
            System.out.println("File path e" + filePathe);
            List<String> expected = Files.readAllLines(filePathe);
            Path filePatha = Paths.get(subDirectory + values.get(0).actual);
            System.out.println("File path a" + filePatha);
            List<String> actual = Files.readAllLines(filePatha);

            // System.out.println("*** expected" + expected.toString());
            assertEquals(expected, actual);
        } catch (IOException e) {
            System.err.println("File Read Error ");
        }
    }

}

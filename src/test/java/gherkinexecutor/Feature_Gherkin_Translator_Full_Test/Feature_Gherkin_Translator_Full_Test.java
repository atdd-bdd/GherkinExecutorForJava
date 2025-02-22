package gherkinexecutor.Feature_Gherkin_Translator_Full_Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Feature_Gherkin_Translator_Full_Test{
void log(String value) {
    try {
        FileWriter myLog = new FileWriter("src/test/java/gherkinexecutor/Feature_Gherkin_Translator_Full_Test/log.txt", true);
        myLog.write(value + "\n");
        myLog.close();
    } catch (IOException e) {
    System.err.println("*** Cannot write to log ");
    }
    }


    @Test
    void test_Scenario_Run_the_Test_and_check_the_output(){
         Feature_Gherkin_Translator_Full_Test_glue feature_Gherkin_Translator_Full_Test_glue_object = new Feature_Gherkin_Translator_Full_Test_glue();
        log("Scenario_Run_the_Test_and_check_the_output");

        List<List<String>> stringListList1 = List.of(
           List.of(
            "full_test.feature"
            )
            );
        feature_Gherkin_Translator_Full_Test_glue_object.Given_feature_file_is(stringListList1);

        feature_Gherkin_Translator_Full_Test_glue_object.When_translated();

        List<FileNames> objectList3 = List.of(
             new FileNames.Builder()
                .expected("gherkinexecutor/Feature_Full_Test/Feature_Full_Test.exp")
                .actual("gherkinexecutor/Feature_Full_Test/Feature_Full_Test.java")
                .build()
            );
        feature_Gherkin_Translator_Full_Test_glue_object.Then_test_file_should_match_expected(objectList3);

        List<FileNames> objectList4 = List.of(
             new FileNames.Builder()
                .expected("gherkinexecutor/Feature_Full_Test/Feature_Full_Test_glue.exp")
                .actual("gherkinexecutor/Feature_Full_Test/Feature_Full_Test_glue.tmpl")
                .build()
            );
        feature_Gherkin_Translator_Full_Test_glue_object.And_glue_template_file_should_match_expected(objectList4);
        }
    }


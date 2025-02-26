package gherkinexecutor.Feature_Gherkin_Translator_Full_Test;
import org.junit.jupiter.api.Test;
import java.util.List;
class Feature_Gherkin_Translator_Full_Test{


    @Test
    void test_Scenario_Run_the_Test_and_check_the_output(){
         Feature_Gherkin_Translator_Full_Test_glue feature_Gherkin_Translator_Full_Test_glue_object = new Feature_Gherkin_Translator_Full_Test_glue();

        List<List<String>> stringListList1 = List.of(
           List.of(
            "full_test.feature.sav"
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


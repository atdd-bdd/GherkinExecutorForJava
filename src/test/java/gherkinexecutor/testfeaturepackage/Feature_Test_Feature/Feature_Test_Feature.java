package gherkinexecutor.testfeaturepackage.Feature_Test_Feature;
import org.junit.jupiter.api.Test;
import java.util.List;
class Feature_Test_Feature{


    @Test
    void test_Scenario_Include_something(){
         Feature_Test_Feature_glue feature_Test_Feature_glue_object = new Feature_Test_Feature_glue();

        String string1 =
            """
            This is an include string from the local directory
            """.stripIndent();
        feature_Test_Feature_glue_object.Given_local_include(string1);

        String string2 =
            """
            This is an include string from the local directory
            """.stripIndent();
        feature_Test_Feature_glue_object.Then_string_equals(string2);

        String string3 =
            """
            This is an include string from the main directory
            """.stripIndent();
        feature_Test_Feature_glue_object.Given_global_include(string3);

        String string4 =
            """
            This is an include string from the main directory
            """.stripIndent();
        feature_Test_Feature_glue_object.Then_string_equals(string4);
        }
    }


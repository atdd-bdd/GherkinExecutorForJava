package gherkinexecutor.Feature_Include;
import org.junit.jupiter.api.Test;
import java.util.List;
class Feature_Include{


    @Test
    void test_Scenario_An_include(){
         Feature_Include_glue feature_Include_glue_object = new Feature_Include_glue();

        String string1 =
            """
            This is an include string from the main directory
            """.stripIndent();
        feature_Include_glue_object.Given_a_string_include(string1);
        }
    @Test
    void test_Scenario_An_include_of_CSV_file(){
         Feature_Include_glue feature_Include_glue_object = new Feature_Include_glue();

        List<List<String>> stringListList1 = List.of(
           List.of(
            "a"
            ,"b,c"
            ,"d,"
            )
           ,List.of(
            "1"
            ,"2"
            ,"3"
            )
            );
        feature_Include_glue_object.Given_a_table(stringListList1);
        }
    }


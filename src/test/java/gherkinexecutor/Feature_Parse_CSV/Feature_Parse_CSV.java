package gherkinexecutor.Feature_Parse_CSV;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.List;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Feature_Parse_CSV{

    @Test
    void test_Scenario_Convert_a_CSV_file_to_Gherkin_Table(){
         Feature_Parse_CSV_glue feature_Parse_CSV_glue_object = new Feature_Parse_CSV_glue();

        String string1 =
            """
            a,"b,c","c"","
            1,2,"3,""b,"",,"
            """.stripIndent();
        feature_Parse_CSV_glue_object.Given(string1);

        String string2 =
            """
            |a|b,c|c",|
            |1|2|3,"b,",,|
            """.stripIndent();
        feature_Parse_CSV_glue_object.When_converted_result_is(string2);
        }
    @Test
    void test_Scenario_Transpose_a_table(){
         Feature_Parse_CSV_glue feature_Parse_CSV_glue_object = new Feature_Parse_CSV_glue();

        List<List<String>> stringListList1 = List.of(
           List.of(
            "a"
            ,"b"
            ,"c"
            )
           ,List.of(
            "d"
            ,"e"
            ,"f"
            )
            );
        feature_Parse_CSV_glue_object.Given_input_table(stringListList1);

        List<List<String>> stringListList2 = List.of(
           List.of(
            "a"
            ,"d"
            )
           ,List.of(
            "b"
            ,"e"
            )
           ,List.of(
            "c"
            ,"f"
            )
            );
        feature_Parse_CSV_glue_object.When_transposed_result_is(stringListList2);
        }
    }


package gherkinexecutor.Feature_Parse_CSV;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Feature_Parse_CSV{
void log(String value) {
    try {
        FileWriter myLog = new FileWriter("src/test/java/gherkinexecutor/Feature_Parse_CSV/log.txt", true);
        myLog.write(value + "\n");
        myLog.close();
    } catch (IOException e) {
    System.err.println("*** Cannot write to log ");
    }
    }


    @Test
    void test_Scenario_Convert_a_CSV_file_to_Gherkin_Table(){
         Feature_Parse_CSV_glue feature_Parse_CSV_glue_object = new Feature_Parse_CSV_glue();
        log("Scenario_Convert_a_CSV_file_to_Gherkin_Table");

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
        log("Scenario_Transpose_a_table");

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


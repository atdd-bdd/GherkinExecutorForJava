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

        String string2 =
            """
            This is an include string from the main directory
            """.stripIndent();
        feature_Include_glue_object.Then_should_be_equal_to(string2);
        }
    @Test
    void test_Scenario_An_include_from_base_directory(){
         Feature_Include_glue feature_Include_glue_object = new Feature_Include_glue();

        String string1 =
            """
            This is an include string from the main directory
            """.stripIndent();
        feature_Include_glue_object.Given_a_string_include(string1);

        String string2 =
            """
            This is an include string from the main directory
            """.stripIndent();
        feature_Include_glue_object.Then_should_be_equal_to(string2);
        }
    @Test
    void test_Scenario_An_include_of_CSV_file(){
         Feature_Include_glue feature_Include_glue_object = new Feature_Include_glue();

        List<CSVContents> objectList1 = List.of(
             new CSVContents.Builder()
                .a("a")
                .b("b,c")
                .c("d,")
                .build()
            , new CSVContents.Builder()
                .a("1")
                .b("2")
                .c("3")
                .build()
            );
        feature_Include_glue_object.Given_a_table(objectList1);

        List<CSVContents> objectList2 = List.of(
             new CSVContents.Builder()
                .a("a")
                .b("b,c")
                .c("d,")
                .build()
            , new CSVContents.Builder()
                .a("1")
                .b("2")
                .c("3")
                .build()
            );
        feature_Include_glue_object.Then_Should_be_equal_to_table(objectList2);
        }
    }


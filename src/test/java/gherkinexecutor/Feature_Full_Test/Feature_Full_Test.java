package gherkinexecutor.Feature_Full_Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.List;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Feature_Full_Test{

    @Test
    void test_Scenario_Some_scenario_here(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();

        String string1 =
            """
            This is an include string
            """.stripIndent();
        feature_Full_Test_glue_object.Given_a_string(string1);

        List<List<String>> stringListList2 = List.of(
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
        feature_Full_Test_glue_object.Then_a_table(stringListList2);
        }
    @Test
    void test_Scenario_Convert_a_CSV_file_to_Gherkin_Table(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();

        String string1 =
            """
            a,"b,c","c"","
            1,2,"3,""b,"",,"
            """.stripIndent();
        feature_Full_Test_glue_object.Given(string1);

        String string2 =
            """
            |a|b,c|c",|
            |1|2|3,"b,",,|
            """.stripIndent();
        feature_Full_Test_glue_object.When_converted_result_is(string2);
        }
    @Test
    void test_Scenario_Transpose_a_table(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();

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
        feature_Full_Test_glue_object.Given_input_table(stringListList1);

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
        feature_Full_Test_glue_object.When_transposed_result_is(stringListList2);
        }
    @Test
    void test_Background(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();

        feature_Full_Test_glue_object.Given_Background_Function();
        }
    @Test
    void test_Cleanup(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();

        feature_Full_Test_glue_object.Given_Cleanup_Function();
        test_Cleanup();
        }
    @Test
    void test_Scenario_Should_have_Background_and_Cleanup(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        test_Background();

        feature_Full_Test_glue_object.Given_a_regular_function();
        test_Cleanup();
        }
    @Test
    void test_Scenario_Should_also_have_Background_and_Cleanup(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        test_Background();

        feature_Full_Test_glue_object.Given_a_regular_function();
        test_Cleanup();
        }
    @Test
    void test_Scenario_Simple(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        test_Background();

        List<ATest> objectList1 = List.of(
             new ATest.Builder()
                .anInt("1")
                .aString("something")
                .aDouble("1.2")
                .build()
                
            );
        feature_Full_Test_glue_object.Given_table_is(objectList1);
        test_Cleanup();
        }
    @Test
    void test_Scenario_One_with_Data(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        test_Background();

        List<MyClass> objectList1 = List.of(
             new MyClass.Builder()
                .one("v1")
                .two("v2")
                .build()
                
            , new MyClass.Builder()
                .one("v1a")
                .two("v1b")
                .build()
                
            );
        feature_Full_Test_glue_object.Given_a_step(objectList1);
        test_Cleanup();
        }
    @Test
    void test_Scenario_One_with_Data_Transpose(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        test_Background();

        List<MyClass> objectList1 = List.of(
             new MyClass.Builder()
                .one("v1")
                .two("v2")
                .build()
                
            , new MyClass.Builder()
                .one("v1a")
                .two("v1b")
                .build()
                
            );
        feature_Full_Test_glue_object.Given_a_step(objectList1);
        test_Cleanup();
        }
    @Test
    void test_Scenario_Temperature(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        test_Background();
        test_Cleanup();
        }
    @Test
    void test_Scenario_Domain_Term_ID(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        test_Background();
        test_Cleanup();
        }
    @Test
    void test_Scenario_Filter_Data(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        test_Background();

        List<LabelValue> objectList1 = List.of(
             new LabelValue.Builder()
                .label("a")
                .value("1")
                .build()
                
            , new LabelValue.Builder()
                .label("b")
                .value("2")
                .build()
                
            , new LabelValue.Builder()
                .label("a")
                .value("3")
                .build()
                
            );
        feature_Full_Test_glue_object.Given_list_of_numbers(objectList1);

        List<List<String>> stringListList2 = List.of(
           List.of(
            "a"
            )
            );
        feature_Full_Test_glue_object.When_filtered_by_Label_with_value(stringListList2);

        List<List<String>> stringListList3 = List.of(
           List.of(
            "4"
            )
            );
        feature_Full_Test_glue_object.Then_sum_is(stringListList3);
        test_Cleanup();
        }
    @Test
    void test_Scenario_Here_are_string_options(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        test_Background();

        String string1 =
            """
            One line
            Two line
            """.stripIndent();
        feature_Full_Test_glue_object.Star_A_multiline_string_to_a_string(string1);

        List<String> stringList2 = List.of(
            "Three line",
            "Four line",
            );
        feature_Full_Test_glue_object.Star_A_multiline_string_to_a_List_of_String(stringList2);
        test_Cleanup();
        }
    @Test
    void test_Scenario_Here_are_table_options(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        test_Background();

        List<List<String>> stringListList1 = List.of(
           List.of(
            "aa"
            ,"bb"
            )
           ,List.of(
            "cc"
            ,"dd"
            )
            );
        feature_Full_Test_glue_object.Star_A_table_to_List_of_List_of_String(stringListList1);

        List<ExampleClass> objectList2 = List.of(
             new ExampleClass.Builder()
                .fieldA("a")
                .fieldB("b")
                .build()
                
            , new ExampleClass.Builder()
                .fieldA("c")
                .fieldB("d")
                .build()
                
            );
        feature_Full_Test_glue_object.Star_A_table_to_List_of_Object(objectList2);

        List<ExampleClass> objectList3 = List.of(
             new ExampleClass.Builder()
                .fieldA("a")
                .fieldB("b")
                .build()
                
            , new ExampleClass.Builder()
                .fieldA("c")
                .fieldB("d")
                .build()
                
            );
        feature_Full_Test_glue_object.Star_A_table_to_List_of_Object(objectList3);

        List<ExampleClass> objectList4 = List.of(
             new ExampleClass.Builder()
                .fieldA("a")
                .build()
                
            , new ExampleClass.Builder()
                .fieldA("c")
                .build()
                
            );
        feature_Full_Test_glue_object.Star_A_table_to_List_of_Object_with_Defaults(objectList4);

        List<ExampleClassWithBlanks> objectList5 = List.of(
             new ExampleClassWithBlanks.Builder()
                .field_1(" ")
                .field_2("b")
                .build()
                
            , new ExampleClassWithBlanks.Builder()
                .field_1("c")
                .field_2(" ")
                .build()
                
            );
        feature_Full_Test_glue_object.Star_A_table_to_List_of_Object_with_Blanks_in_Name(objectList5);

        val table6 =
            """
            | aa  | bb  |
            | cc  | dd  |
            """.trimIndent();
        feature_Full_Test_glue_object.Star_A_table_to_String(table6);
        test_Cleanup();
        }
    }


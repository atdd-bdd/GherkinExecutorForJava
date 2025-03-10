package gherkinexecutor.Feature_Full_Test;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
class Feature_Full_Test{
void log(String value) {
    try {
        FileWriter myLog = new FileWriter("src/test/java/gherkinexecutor/Feature_Full_Test/log.txt", true);
        myLog.write(value + "\n");
        myLog.close();
    } catch (IOException e) {
    System.err.println("*** Cannot write to log ");
    }
    }


    void test_Background(Feature_Full_Test_glue feature_Full_Test_glue_object){
        log("Background");

        List<List<String>> stringListList1 = List.of(
           List.of(
            "Background Here"
            )
            );
        feature_Full_Test_glue_object.Given_Background_function_sets_a_value(stringListList1);
        }
    void test_Cleanup(Feature_Full_Test_glue feature_Full_Test_glue_object){
        log("Cleanup");

        List<List<String>> stringListList1 = List.of(
           List.of(
            "Cleanup Here"
            )
            );
        feature_Full_Test_glue_object.Given_value_for_cleanup_should_be_set_to(stringListList1);
        }
    @Test
    void test_Scenario_Should_have_Background_and_Cleanup(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        log("Scenario_Should_have_Background_and_Cleanup");
        test_Background(feature_Full_Test_glue_object);

        feature_Full_Test_glue_object.Given_a_regular_function();

        List<List<String>> stringListList2 = List.of(
           List.of(
            "Background Here"
            )
            );
        feature_Full_Test_glue_object.Then_background_should_set_value_to(stringListList2);

        List<List<String>> stringListList3 = List.of(
           List.of(
            "Cleanup Here"
            )
            );
        feature_Full_Test_glue_object.And_set_a_value_for_cleanup(stringListList3);
        test_Cleanup(feature_Full_Test_glue_object); // from previous
        }
    @Test
    void test_Scenario_Should_also_have_Background_and_Cleanup(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        log("Scenario_Should_also_have_Background_and_Cleanup");
        test_Background(feature_Full_Test_glue_object);

        feature_Full_Test_glue_object.Given_a_regular_function();

        List<List<String>> stringListList2 = List.of(
           List.of(
            "Background Here"
            )
            );
        feature_Full_Test_glue_object.Then_background_should_set_value_to(stringListList2);

        List<List<String>> stringListList3 = List.of(
           List.of(
            "Cleanup Here"
            )
            );
        feature_Full_Test_glue_object.And_set_a_value_for_cleanup(stringListList3);
        test_Cleanup(feature_Full_Test_glue_object); // from previous
        }
    @Test
    void test_Scenario_Simple_Comparison(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        log("Scenario_Simple_Comparison");
        test_Background(feature_Full_Test_glue_object);

        List<ATest> objectList1 = List.of(
             new ATest.Builder()
                .setAnInt("1")
                .setAString("something")
                .setADouble("1.2")
                .build()
            );
        feature_Full_Test_glue_object.Given_table_is(objectList1);

        List<ATest> objectList2 = List.of(
             new ATest.Builder()
             .setCompare()
                .setAString("something")
                .build()
            );
        feature_Full_Test_glue_object.When_compared_to(objectList2);

        List<List<String>> stringListList3 = List.of(
           List.of(
            "true"
            )
            );
        feature_Full_Test_glue_object.Then_result_is(stringListList3);

        List<ATest> objectList4 = List.of(
             new ATest.Builder()
             .setCompare()
                .setAString("something else")
                .build()
            );
        feature_Full_Test_glue_object.When_compared_to(objectList4);

        List<List<String>> stringListList5 = List.of(
           List.of(
            "false"
            )
            );
        feature_Full_Test_glue_object.Then_result_is(stringListList5);
        test_Cleanup(feature_Full_Test_glue_object); // from previous
        }
    @Test
    void test_Scenario_Simple_Table_with_int_bad(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        log("Scenario_Simple_Table_with_int_bad");
        test_Background(feature_Full_Test_glue_object);

        List<ATest> objectList1 = List.of(
             new ATest.Builder()
                .setAnInt("q")
                .setAString("something")
                .setADouble("1.1")
                .build()
            );
        feature_Full_Test_glue_object.Given_table_is(objectList1);
        test_Cleanup(feature_Full_Test_glue_object); // from previous
        }
    @Test
    void test_Scenario_Simple_Table_with_double_bad(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        log("Scenario_Simple_Table_with_double_bad");
        test_Background(feature_Full_Test_glue_object);

        List<ATest> objectList1 = List.of(
             new ATest.Builder()
                .setAnInt("1")
                .setAString("something")
                .setADouble("r")
                .build()
            );
        feature_Full_Test_glue_object.Given_table_is(objectList1);
        test_Cleanup(feature_Full_Test_glue_object); // from previous
        }
    @Test
    void test_Scenario_Simple_Table_with_initializer_bad(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        log("Scenario_Simple_Table_with_initializer_bad");
        test_Background(feature_Full_Test_glue_object);

        List<ATestBad> objectList1 = List.of(
             new ATestBad.Builder()
                .setAnInt("1")
                .build()
            );
        feature_Full_Test_glue_object.Given_table_is_bad_initializer(objectList1);
        test_Cleanup(feature_Full_Test_glue_object); // from previous
        }
    @Test
    void test_Scenario_Simple_Replacement(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        log("Scenario_Simple_Replacement");
        test_Background(feature_Full_Test_glue_object);

        List<IDValue> objectList1 = List.of(
             new IDValue.Builder()
                .setID("A")
                .setValue("100")
                .build()
            , new IDValue.Builder()
                .setID("B")
                .setValue("1")
                .build()
            );
        feature_Full_Test_glue_object.Given_this_data(objectList1);

        List<IDValue> objectList2 = List.of(
             new IDValue.Builder()
                .setID("A")
                .setValue("100")
                .build()
            , new IDValue.Builder()
                .setID("B")
                .setValue("1")
                .build()
            );
        feature_Full_Test_glue_object.Then_should_be_equal_to_data(objectList2);
        test_Cleanup(feature_Full_Test_glue_object); // from previous
        }
    @Test
    void test_Scenario_Try_out_replacements_with_a_calculation(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        log("Scenario_Try_out_replacements_with_a_calculation");
        test_Background(feature_Full_Test_glue_object);

        List<IDValue> objectList1 = List.of(
             new IDValue.Builder()
                .setID("A")
                .setValue("100")
                .build()
            , new IDValue.Builder()
                .setID("B")
                .setValue("1")
                .build()
            , new IDValue.Builder()
                .setID("C")
                .setValue("(1 + 100)/2")
                .build()
            );
        feature_Full_Test_glue_object.Given_this_data(objectList1);

        List<IDValue> objectList2 = List.of(
             new IDValue.Builder()
                .setID("A")
                .setValue("100")
                .build()
            , new IDValue.Builder()
                .setID("B")
                .setValue("1")
                .build()
            , new IDValue.Builder()
                .setID("C")
                .setValue("(1 + 100)/2")
                .build()
            );
        feature_Full_Test_glue_object.Then_should_be_equal_to_data(objectList2);
        test_Cleanup(feature_Full_Test_glue_object); // from previous
        }
    @Test
    void test_Scenario_Temperature(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        log("Scenario_Temperature");
        test_Background(feature_Full_Test_glue_object);

        List<TemperatureCalculation> objectList1 = List.of(
             new TemperatureCalculation.Builder()
                .setF("32")
                .setC("0")
                .setNotes("Freezing")
                .build()
            , new TemperatureCalculation.Builder()
                .setF("212")
                .setC("100")
                .setNotes("Boiling")
                .build()
            , new TemperatureCalculation.Builder()
                .setF("-40")
                .setC("-40")
                .setNotes("Below zero")
                .build()
            );
        feature_Full_Test_glue_object.Calculation_Convert_F_to_C(objectList1);
        test_Cleanup(feature_Full_Test_glue_object); // from previous
        }
    @Test
    void test_Scenario_Domain_Term_ID(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        log("Scenario_Domain_Term_ID");
        test_Background(feature_Full_Test_glue_object);

        List<ValueValid> objectList1 = List.of(
             new ValueValid.Builder()
                .setValue("Q1234")
                .setValid("true")
                .setNotes("")
                .build()
            , new ValueValid.Builder()
                .setValue("Q123")
                .setValid("false")
                .setNotes("Too short")
                .build()
            , new ValueValid.Builder()
                .setValue("Q12345")
                .setValid("false")
                .setNotes("Too long")
                .build()
            , new ValueValid.Builder()
                .setValue("A1234")
                .setValid("false")
                .setNotes("Must begin with Q")
                .build()
            );
        feature_Full_Test_glue_object.Rule_ID_must_have_exactly_5_letters_and_begin_with_Q(objectList1);
        test_Cleanup(feature_Full_Test_glue_object); // from previous
        }
    @Test
    void test_Scenario_Filter_Data(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        log("Scenario_Filter_Data");
        test_Background(feature_Full_Test_glue_object);

        List<LabelValue> objectList1 = List.of(
             new LabelValue.Builder()
                .setID("Q1234")
                .setValue("1")
                .build()
            , new LabelValue.Builder()
                .setID("Q9999")
                .setValue("2")
                .build()
            , new LabelValue.Builder()
                .setID("Q1234")
                .setValue("3")
                .build()
            );
        feature_Full_Test_glue_object.Given_list_of_numbers(objectList1);

        List<List<String>> stringListList2 = List.of(
           List.of(
            "Q1234"
            )
            );
        feature_Full_Test_glue_object.When_filtered_by_ID_with_value(stringListList2);

        List<List<String>> stringListList3 = List.of(
           List.of(
            "4"
            )
            );
        feature_Full_Test_glue_object.Then_sum_is(stringListList3);
        test_Cleanup(feature_Full_Test_glue_object); // from previous
        }
    @Test
    void test_Scenario_Filter_Data_Another_Way(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        log("Scenario_Filter_Data_Another_Way");
        test_Background(feature_Full_Test_glue_object);

        List<LabelValue> objectList1 = List.of(
             new LabelValue.Builder()
                .setID("Q1234")
                .setValue("1")
                .build()
            , new LabelValue.Builder()
                .setID("Q9999")
                .setValue("2")
                .build()
            , new LabelValue.Builder()
                .setID("Q1234")
                .setValue("3")
                .build()
            );
        feature_Full_Test_glue_object.Given_list_of_numbers(objectList1);

        List<FilterValue> objectList2 = List.of(
             new FilterValue.Builder()
                .setName("ID")
                .setValue("Q1234")
                .build()
            );
        feature_Full_Test_glue_object.When_filtered_by(objectList2);

        List<ResultValue> objectList3 = List.of(
             new ResultValue.Builder()
                .setSum("4")
                .build()
            );
        feature_Full_Test_glue_object.Then_result(objectList3);
        test_Cleanup(feature_Full_Test_glue_object); // from previous
        }
    @Test
    void test_Scenario_Use_an_import(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        log("Scenario_Use_an_import");
        test_Background(feature_Full_Test_glue_object);

        List<ImportData> objectList1 = List.of(
             new ImportData.Builder()
                .setMyPattern("a.*")
                .setMyWeekday("MONDAY")
                .setMyBigInt("1")
                .build()
            , new ImportData.Builder()
                .setMyPattern("[ab]")
                .setMyWeekday("SUNDAY")
                .setMyBigInt("10000000000")
                .build()
            );
        feature_Full_Test_glue_object.Given_this_data_should_be_okay(objectList1);
        test_Cleanup(feature_Full_Test_glue_object); // from previous
        }
    @Test
    void test_Scenario_Should_fail(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        log("Scenario_Should_fail");
        test_Background(feature_Full_Test_glue_object);

        List<ImportData> objectList1 = List.of(
             new ImportData.Builder()
                .setMyPattern("a.*")
                .setMyWeekday("SOMEONE")
                .setMyBigInt("1")
                .build()
            , new ImportData.Builder()
                .setMyPattern("[ab]")
                .setMyWeekday("SUNDAY")
                .setMyBigInt("2")
                .build()
            );
        feature_Full_Test_glue_object.Given_this_data_should_fail(objectList1);
        test_Cleanup(feature_Full_Test_glue_object); // from previous
        }
    @Test
    void test_Scenario_Should_also_fail(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        log("Scenario_Should_also_fail");
        test_Background(feature_Full_Test_glue_object);

        List<ImportData> objectList1 = List.of(
             new ImportData.Builder()
                .setMyPattern("a.*")
                .setMyWeekday("MONDAY")
                .setMyBigInt("1")
                .build()
            , new ImportData.Builder()
                .setMyPattern("[ab]")
                .setMyWeekday("SUNDAY")
                .setMyBigInt("A.2")
                .build()
            );
        feature_Full_Test_glue_object.Given_this_data_should_fail(objectList1);
        test_Cleanup(feature_Full_Test_glue_object); // from previous
        }
    @Test
    void test_Scenario_An_include(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        log("Scenario_An_include");
        test_Background(feature_Full_Test_glue_object);

        String string1 =
            """
            This is an include string from the main directory
            """.stripIndent();
        feature_Full_Test_glue_object.Given_a_string_include(string1);

        String string2 =
            """
            This is an include string from the main directory
            """.stripIndent();
        feature_Full_Test_glue_object.Then_should_be_equal_to(string2);
        test_Cleanup(feature_Full_Test_glue_object); // from previous
        }
    @Test
    void test_Scenario_An_include_from_base_directory(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        log("Scenario_An_include_from_base_directory");
        test_Background(feature_Full_Test_glue_object);

        String string1 =
            """
            This is an include string from the main directory
            """.stripIndent();
        feature_Full_Test_glue_object.Given_a_string_include(string1);

        String string2 =
            """
            This is an include string from the main directory
            """.stripIndent();
        feature_Full_Test_glue_object.Then_should_be_equal_to(string2);
        test_Cleanup(feature_Full_Test_glue_object); // from previous
        }
    @Test
    void test_Scenario_An_include_of_CSV_file(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        log("Scenario_An_include_of_CSV_file");
        test_Background(feature_Full_Test_glue_object);

        List<CSVContents> objectList1 = List.of(
             new CSVContents.Builder()
                .setA("a")
                .setB("b,c")
                .setC("d,")
                .build()
            , new CSVContents.Builder()
                .setA("1")
                .setB("2")
                .setC("3")
                .build()
            );
        feature_Full_Test_glue_object.Given_a_table(objectList1);

        List<CSVContents> objectList2 = List.of(
             new CSVContents.Builder()
                .setA("a")
                .setB("b,c")
                .setC("d,")
                .build()
            , new CSVContents.Builder()
                .setA("1")
                .setB("2")
                .setC("3")
                .build()
            );
        feature_Full_Test_glue_object.Then_Should_be_equal_to_table(objectList2);
        test_Cleanup(feature_Full_Test_glue_object); // from previous
        }
    @Test
    void test_Scenario_Simple(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        log("Scenario_Simple");
        test_Background(feature_Full_Test_glue_object);

        List<ATest> objectList1 = List.of(
             new ATest.Builder()
                .setAnInt("1")
                .setAString("something")
                .setADouble("1.2")
                .build()
            );
        feature_Full_Test_glue_object.Given_table_is(objectList1);
        test_Cleanup(feature_Full_Test_glue_object); // from previous
        }
    @Test
    void test_Scenario_Here_are_string_options(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        log("Scenario_Here_are_string_options");
        test_Background(feature_Full_Test_glue_object);

        String string1 =
            """
            One line
            Two line
            """.stripIndent();
        feature_Full_Test_glue_object.Star_A_multiline_string_to_a_string(string1);

        List<String> stringList2 = List.of(
            "Three line"
            ,"Four line"
            );
        feature_Full_Test_glue_object.Star_A_multiline_string_to_a_List_of_String(stringList2);
        test_Cleanup(feature_Full_Test_glue_object); // from previous
        }
    @Test
    void test_Scenario_Check_String_Variations(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        log("Scenario_Check_String_Variations");
        test_Background(feature_Full_Test_glue_object);

        String string1 =
            """
            One line
            Two line
            """.stripIndent();
        feature_Full_Test_glue_object.Given_multiline_string(string1);

        List<String> stringList2 = List.of(
            "One line"
            ,"Two line"
            );
        feature_Full_Test_glue_object.Then_should_be_equal_to_this_list(stringList2);
        test_Cleanup(feature_Full_Test_glue_object); // from previous
        }
    @Test
    void test_Scenario_Here_are_table_options(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        log("Scenario_Here_are_table_options");
        test_Background(feature_Full_Test_glue_object);

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

        List<List<String>> stringListList2 = List.of(
           List.of(
            "1"
            ,"2"
            )
           ,List.of(
            "3"
            ,"4"
            )
           ,List.of(
            "5"
            ,"6"
            )
            );
        feature_Full_Test_glue_object.Star_A_Table_to_List_Of_List_Of_Object(stringListList2);

        List<ExampleClass> objectList3 = List.of(
             new ExampleClass.Builder()
                .setFieldA("a")
                .setFieldB("b")
                .build()
            , new ExampleClass.Builder()
                .setFieldA("c")
                .setFieldB("d")
                .build()
            );
        feature_Full_Test_glue_object.Star_A_table_to_List_of_Object(objectList3);

        List<ExampleClass> objectList4 = List.of(
             new ExampleClass.Builder()
                .setFieldA("a")
                .setFieldB("b")
                .build()
            , new ExampleClass.Builder()
                .setFieldA("c")
                .setFieldB("d")
                .build()
            );
        feature_Full_Test_glue_object.Star_A_table_to_List_of_Object(objectList4);

        List<ExampleClass> objectList5 = List.of(
             new ExampleClass.Builder()
                .setFieldA("a")
                .build()
            , new ExampleClass.Builder()
                .setFieldA("c")
                .build()
            );
        feature_Full_Test_glue_object.Star_A_table_to_List_of_Object_with_Defaults(objectList5);

        List<ExampleClassWithBlanks> objectList6 = List.of(
             new ExampleClassWithBlanks.Builder()
                .setField_1(" ")
                .setField_2("b")
                .build()
            , new ExampleClassWithBlanks.Builder()
                .setField_1("c")
                .setField_2(" ")
                .build()
            );
        feature_Full_Test_glue_object.Star_A_table_to_List_of_Object_with_Blanks_in_Values(objectList6);

        List<ExampleClassWithBlanks> objectList7 = List.of(
             new ExampleClassWithBlanks.Builder()
                .setField_1(" ")
                .build()
            , new ExampleClassWithBlanks.Builder()
                .setField_1("c")
                .build()
            );
        feature_Full_Test_glue_object.Star_A_table_to_List_of_Object_with_Blanks_in_Defaults(objectList7);

        String table8 =
            """
            | aa  | bb  |
            | cc  | dd  |
            """.stripIndent();
        feature_Full_Test_glue_object.Star_A_table_to_String(table8);
        test_Cleanup(feature_Full_Test_glue_object); // from previous
        }
    @Test
    void test_Scenario_Table_to_String(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        log("Scenario_Table_to_String");
        test_Background(feature_Full_Test_glue_object);

        String table1 =
            """
            | aa  | bb  |
            | cc  | dd  |
            """.stripIndent();
        feature_Full_Test_glue_object.Given_A_table_to_String(table1);

        String string2 =
            """
            | aa  | bb  |
            | cc  | dd  |
            """.stripIndent();
        feature_Full_Test_glue_object.Then_string_should_be_same_as(string2);
        test_Cleanup(feature_Full_Test_glue_object); // from previous
        }
    @Test
    void test_Scenario_Table_without_all_fields_uses_defaults(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        log("Scenario_Table_without_all_fields_uses_defaults");
        test_Background(feature_Full_Test_glue_object);

        List<ExampleClass> objectList1 = List.of(
             new ExampleClass.Builder()
                .setFieldA("a")
                .build()
            , new ExampleClass.Builder()
                .setFieldA("c")
                .build()
            );
        feature_Full_Test_glue_object.Given_A_table_to_List_of_Object_with_Defaults(objectList1);

        List<ExampleClass> objectList2 = List.of(
             new ExampleClass.Builder()
                .setFieldA("a")
                .setFieldB("x")
                .build()
            , new ExampleClass.Builder()
                .setFieldA("c")
                .setFieldB("x")
                .build()
            );
        feature_Full_Test_glue_object.Then_table_should_be_same_as(objectList2);
        test_Cleanup(feature_Full_Test_glue_object); // from previous
        }
    @Test
    void test_Scenario_Transpose_Table(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        log("Scenario_Transpose_Table");
        test_Background(feature_Full_Test_glue_object);

        List<ExampleClass> objectList1 = List.of(
             new ExampleClass.Builder()
                .setFieldA("a")
                .setFieldB("b")
                .build()
            , new ExampleClass.Builder()
                .setFieldA("c")
                .setFieldB("d")
                .build()
            );
        feature_Full_Test_glue_object.Given_A_table_to_List_of_Object(objectList1);

        List<ExampleClass> objectList2 = List.of(
             new ExampleClass.Builder()
                .setFieldA("a")
                .setFieldB("b")
                .build()
            , new ExampleClass.Builder()
                .setFieldA("c")
                .setFieldB("d")
                .build()
            );
        feature_Full_Test_glue_object.Then_transposed_table_to_List_of_Object_should_be_the_same(objectList2);
        test_Cleanup(feature_Full_Test_glue_object); // from previous
        }
    @Test
    void test_Scenario_Make_a_move(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        log("Scenario_Make_a_move");
        test_Background(feature_Full_Test_glue_object);

        List<List<String>> stringListList1 = List.of(
           List.of(
            ""
            ,""
            ,""
            )
           ,List.of(
            ""
            ,""
            ,""
            )
           ,List.of(
            ""
            ,""
            ,""
            )
            );
        feature_Full_Test_glue_object.Given_board_is(stringListList1);

        List<Move> objectList2 = List.of(
             new Move.Builder()
                .setRow("1")
                .setColumn("2")
                .setMark("X")
                .build()
            );
        feature_Full_Test_glue_object.When_move_is(objectList2);

        String table3 =
            """
            |   | X  |   |
            |   |    |   |
            |   |    |   |
            """.stripIndent();
        feature_Full_Test_glue_object.Then_board_is_now(table3);
        test_Cleanup(feature_Full_Test_glue_object); // from previous
        }
    @Test
    void test_Scenario_Make_a_move_using_single_element(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        log("Scenario_Make_a_move_using_single_element");
        test_Background(feature_Full_Test_glue_object);

        List<List<String>> stringListList1 = List.of(
           List.of(
            ""
            ,""
            ,""
            )
           ,List.of(
            ""
            ,""
            ,""
            )
           ,List.of(
            ""
            ,""
            ,""
            )
            );
        feature_Full_Test_glue_object.Given_board_is(stringListList1);

        List<List<String>> stringListList2 = List.of(
           List.of(
            "1,2,X"
            )
            );
        feature_Full_Test_glue_object.When_one_move_is(stringListList2);

        String table3 =
            """
            |   | X  |   |
            |   |    |   |
            |   |    |   |
            """.stripIndent();
        feature_Full_Test_glue_object.Then_board_is_now(table3);
        test_Cleanup(feature_Full_Test_glue_object); // from previous
        }
    @Test
    void test_Scenario_Make_multiple_moves(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        log("Scenario_Make_multiple_moves");
        test_Background(feature_Full_Test_glue_object);

        List<List<String>> stringListList1 = List.of(
           List.of(
            ""
            ,""
            ,""
            )
           ,List.of(
            ""
            ,""
            ,""
            )
           ,List.of(
            ""
            ,""
            ,""
            )
            );
        feature_Full_Test_glue_object.Given_board_is(stringListList1);

        List<Move> objectList2 = List.of(
             new Move.Builder()
                .setRow("1")
                .setColumn("2")
                .setMark("X")
                .build()
            , new Move.Builder()
                .setRow("2")
                .setColumn("3")
                .setMark("O")
                .build()
            );
        feature_Full_Test_glue_object.When_moves_are(objectList2);

        String table3 =
            """
            |   | X  |    |
            |   |    | O  |
            |   |    |    |
            """.stripIndent();
        feature_Full_Test_glue_object.Then_board_is_now(table3);
        test_Cleanup(feature_Full_Test_glue_object); // from previous
        }
    @Test
    void test_Scenario_check_the_prints_to_see_how_it_works(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        log("Scenario_check_the_prints_to_see_how_it_works");
        test_Background(feature_Full_Test_glue_object);

        List<List<String>> stringListList1 = List.of(
           List.of(
            "0"
            ,"x"
            ,"0"
            )
           ,List.of(
            "x"
            ,"0"
            ,"x"
            )
           ,List.of(
            "0"
            ,"x"
            ,"0"
            )
            );
        feature_Full_Test_glue_object.Given_board_is(stringListList1);

        String table2 =
            """
            | 0  | x  | 0  |
            | x  | 0  | x  |
            | 0  | x  | 0  |
            """.stripIndent();
        feature_Full_Test_glue_object.Then_board_is_now(table2);
        test_Cleanup(feature_Full_Test_glue_object); // from previous
        }
    @Test
    void test_Scenario_Convert_to_Json(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        log("Scenario_Convert_to_Json");
        test_Background(feature_Full_Test_glue_object);

        List<SimpleClass> objectList1 = List.of(
             new SimpleClass.Builder()
                .setAnInt("1")
                .setAString("B")
                .build()
            );
        feature_Full_Test_glue_object.Given_one_object_is(objectList1);

        String string2 =
            """
            {anInt:"1",aString:"B"}
            """.stripIndent();
        feature_Full_Test_glue_object.Then_Json_should_be(string2);
        test_Cleanup(feature_Full_Test_glue_object); // from previous
        }
    @Test
    void test_Scenario_Convert_from_Json(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        log("Scenario_Convert_from_Json");
        test_Background(feature_Full_Test_glue_object);

        String string1 =
            """
            {anInt:  "1"   ,   aString:"B"  }
            """.stripIndent();
        feature_Full_Test_glue_object.Given_Json_is(string1);

        List<SimpleClass> objectList2 = List.of(
             new SimpleClass.Builder()
                .setAnInt("1")
                .setAString("B")
                .build()
            );
        feature_Full_Test_glue_object.Then_the_converted_object_is(objectList2);
        test_Cleanup(feature_Full_Test_glue_object); // from previous
        }
    @Test
    void test_Scenario_Convert_to_Json_Array(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        log("Scenario_Convert_to_Json_Array");
        test_Background(feature_Full_Test_glue_object);

        List<SimpleClass> objectList1 = List.of(
             new SimpleClass.Builder()
                .setAnInt("1")
                .setAString("B")
                .build()
            , new SimpleClass.Builder()
                .setAnInt("2")
                .setAString("C")
                .build()
            );
        feature_Full_Test_glue_object.Given_a_table_is(objectList1);

        String string2 =
            """
            [ {anInt:"1",aString:"B"}
            , {anInt:"2",aString:"C"}
            ]
            """.stripIndent();
        feature_Full_Test_glue_object.Then_Json_for_table_should_be(string2);
        test_Cleanup(feature_Full_Test_glue_object); // from previous
        }
    @Test
    void test_Scenario_Convert_from_Json_Array(){
         Feature_Full_Test_glue feature_Full_Test_glue_object = new Feature_Full_Test_glue();
        log("Scenario_Convert_from_Json_Array");
        test_Background(feature_Full_Test_glue_object);

        String string1 =
            """
            [    {anInt:  "1"   ,   aString:"B"  },
            {anInt:  "2"   ,   aString:"C"  }
            ]
            """.stripIndent();
        feature_Full_Test_glue_object.Given_Json_for_table_is(string1);

        List<SimpleClass> objectList2 = List.of(
             new SimpleClass.Builder()
                .setAnInt("1")
                .setAString("B")
                .build()
            , new SimpleClass.Builder()
                .setAnInt("2")
                .setAString("C")
                .build()
            );
        feature_Full_Test_glue_object.Then_the_converted_table_should_be(objectList2);
        test_Cleanup(feature_Full_Test_glue_object); // at the end
        }
    }


package gherkinexecutor.Feature_Full_Test;
import java.util.*;
import java.util.regex.Pattern;
import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

class Feature_Full_Test_glue {
    final String DNCString = "?DNC?";
    void log(String value) {
        try {
            FileWriter myLog = new FileWriter("src/test/java/gherkinexecutor/Feature_Full_Test/log.txt", true);
            myLog.write(value + "\n");
            myLog.close();
        } catch (IOException e) {
            System.err.println("*** Cannot write to log ");
        }
    }


    void Given_Background_function_sets_a_value(List<List<String>> values ) {
        System.out.println("---  " + "Given_Background_function_sets_a_value");
        log("---  " + "Given_Background_function_sets_a_value");
        log(values.toString());
        for (List<String> value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void Given_value_for_cleanup_should_be_set_to(List<List<String>> values ) {
        System.out.println("---  " + "Given_value_for_cleanup_should_be_set_to");
        log("---  " + "Given_value_for_cleanup_should_be_set_to");
        log(values.toString());
        for (List<String> value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void Given_a_regular_function(){
        System.out.println("---  " + "Given_a_regular_function");
        log("---  " + "Given_a_regular_function");
    }

    void Then_background_should_set_value_to(List<List<String>> values ) {
        System.out.println("---  " + "Then_background_should_set_value_to");
        log("---  " + "Then_background_should_set_value_to");
        log(values.toString());
        for (List<String> value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void And_set_a_value_for_cleanup(List<List<String>> values ) {
        System.out.println("---  " + "And_set_a_value_for_cleanup");
        log("---  " + "And_set_a_value_for_cleanup");
        log(values.toString());
        for (List<String> value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void Given_table_is(List<ATest> values ) {
        System.out.println("---  " + "Given_table_is");
        log("---  " + "Given_table_is");
        log(values.toString());
        for (ATest value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            ATestInternal i = value.toATestInternal();
        }
    }

    void When_compared_to(List<ATest> values ) {
        System.out.println("---  " + "When_compared_to");
        log("---  " + "When_compared_to");
        log(values.toString());
        for (ATest value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            ATestInternal i = value.toATestInternal();
        }
    }

    void Then_result_is(List<List<String>> values ) {
        System.out.println("---  " + "Then_result_is");
        log("---  " + "Then_result_is");
        log(values.toString());
        for (List<String> value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void Given_table_is_bad_initializer(List<ATestBad> values ) {
        System.out.println("---  " + "Given_table_is_bad_initializer");
        log("---  " + "Given_table_is_bad_initializer");
        log(values.toString());
        for (ATestBad value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            ATestBadInternal i = value.toATestBadInternal();
        }
    }

    void Given_this_data(List<IDValue> values ) {
        System.out.println("---  " + "Given_this_data");
        log("---  " + "Given_this_data");
        log(values.toString());
        for (IDValue value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void Then_should_be_equal_to_data(List<IDValue> values ) {
        System.out.println("---  " + "Then_should_be_equal_to_data");
        log("---  " + "Then_should_be_equal_to_data");
        log(values.toString());
        for (IDValue value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void Calculation_Convert_F_to_C(List<FandC> values ) {
        System.out.println("---  " + "Calculation_Convert_F_to_C");
        log("---  " + "Calculation_Convert_F_to_C");
        log(values.toString());
        for (FandC value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            FandCInternal i = value.toFandCInternal();
        }
    }

    void Rule_ID_must_have_exactly_5_letters_and_begin_with_Q(List<ValueValid> values ) {
        System.out.println("---  " + "Rule_ID_must_have_exactly_5_letters_and_begin_with_Q");
        log("---  " + "Rule_ID_must_have_exactly_5_letters_and_begin_with_Q");
        log(values.toString());
        for (ValueValid value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            ValueValidInternal i = value.toValueValidInternal();
        }
    }

    void Given_list_of_numbers(List<LabelValue> values ) {
        System.out.println("---  " + "Given_list_of_numbers");
        log("---  " + "Given_list_of_numbers");
        log(values.toString());
        for (LabelValue value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            LabelValueInternal i = value.toLabelValueInternal();
        }
    }

    void When_filtered_by_ID_with_value(List<List<String>> values ) {
        System.out.println("---  " + "When_filtered_by_ID_with_value");
        log("---  " + "When_filtered_by_ID_with_value");
        log(values.toString());
        for (List<String> value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void Then_sum_is(List<List<String>> values ) {
        System.out.println("---  " + "Then_sum_is");
        log("---  " + "Then_sum_is");
        log(values.toString());
        for (List<String> value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void When_filtered_by(List<FilterValue> values ) {
        System.out.println("---  " + "When_filtered_by");
        log("---  " + "When_filtered_by");
        log(values.toString());
        for (FilterValue value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            FilterValueInternal i = value.toFilterValueInternal();
        }
    }

    void Then_result(List<ResultValue> values ) {
        System.out.println("---  " + "Then_result");
        log("---  " + "Then_result");
        log(values.toString());
        for (ResultValue value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            ResultValueInternal i = value.toResultValueInternal();
        }
    }

    void Given_this_data_should_be_okay(List<ImportData> values ) {
        System.out.println("---  " + "Given_this_data_should_be_okay");
        log("---  " + "Given_this_data_should_be_okay");
        log(values.toString());
        for (ImportData value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            ImportDataInternal i = value.toImportDataInternal();
        }
    }

    void Given_this_data_should_fail(List<ImportData> values ) {
        System.out.println("---  " + "Given_this_data_should_fail");
        log("---  " + "Given_this_data_should_fail");
        log(values.toString());
        for (ImportData value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            ImportDataInternal i = value.toImportDataInternal();
        }
    }

    void Given_a_string_include(String value ) {
        System.out.println("---  " + "Given_a_string_include");
        log("---  " + "Given_a_string_include");
        log(value.toString());
        System.out.println(value);
    }

    void Then_should_be_equal_to(String value ) {
        System.out.println("---  " + "Then_should_be_equal_to");
        log("---  " + "Then_should_be_equal_to");
        log(value.toString());
        System.out.println(value);
    }

    void Given_a_table(List<CSVContents> values ) {
        System.out.println("---  " + "Given_a_table");
        log("---  " + "Given_a_table");
        log(values.toString());
        for (CSVContents value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void Then_Should_be_equal_to_table(List<CSVContents> values ) {
        System.out.println("---  " + "Then_Should_be_equal_to_table");
        log("---  " + "Then_Should_be_equal_to_table");
        log(values.toString());
        for (CSVContents value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void Star_A_multiline_string_to_a_string(String value ) {
        System.out.println("---  " + "Star_A_multiline_string_to_a_string");
        log("---  " + "Star_A_multiline_string_to_a_string");
        log(value.toString());
        System.out.println(value);
    }

    void Star_A_multiline_string_to_a_List_of_String(List<String> values ) {
        System.out.println("---  " + "Star_A_multiline_string_to_a_List_of_String");
        log("---  " + "Star_A_multiline_string_to_a_List_of_String");
        log(values.toString());
        for (String value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void Given_multiline_string(String value ) {
        System.out.println("---  " + "Given_multiline_string");
        log("---  " + "Given_multiline_string");
        log(value.toString());
        System.out.println(value);
    }

    void Then_should_be_equal_to_this_list(List<String> values ) {
        System.out.println("---  " + "Then_should_be_equal_to_this_list");
        log("---  " + "Then_should_be_equal_to_this_list");
        log(values.toString());
        for (String value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void Star_A_table_to_List_of_List_of_String(List<List<String>> values ) {
        System.out.println("---  " + "Star_A_table_to_List_of_List_of_String");
        log("---  " + "Star_A_table_to_List_of_List_of_String");
        log(values.toString());
        for (List<String> value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void Star_A_Table_to_List_Of_List_Of_Object(List<List<String>> values ) {
        List<List<Integer>> is = convertList(values);
        System.out.println(is);
        log("---  " + "Star_A_Table_to_List_Of_List_Of_Object");
    }

    void Star_A_table_to_List_of_Object(List<ExampleClass> values ) {
        System.out.println("---  " + "Star_A_table_to_List_of_Object");
        log("---  " + "Star_A_table_to_List_of_Object");
        log(values.toString());
        for (ExampleClass value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void Star_A_table_to_List_of_Object_with_Defaults(List<ExampleClass> values ) {
        System.out.println("---  " + "Star_A_table_to_List_of_Object_with_Defaults");
        log("---  " + "Star_A_table_to_List_of_Object_with_Defaults");
        log(values.toString());
        for (ExampleClass value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void Star_A_table_to_List_of_Object_with_Blanks_in_Values(List<ExampleClassWithBlanks> values ) {
        System.out.println("---  " + "Star_A_table_to_List_of_Object_with_Blanks_in_Values");
        log("---  " + "Star_A_table_to_List_of_Object_with_Blanks_in_Values");
        log(values.toString());
        for (ExampleClassWithBlanks value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void Star_A_table_to_List_of_Object_with_Blanks_in_Defaults(List<ExampleClassWithBlanks> values ) {
        System.out.println("---  " + "Star_A_table_to_List_of_Object_with_Blanks_in_Defaults");
        log("---  " + "Star_A_table_to_List_of_Object_with_Blanks_in_Defaults");
        log(values.toString());
        for (ExampleClassWithBlanks value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void Star_A_table_to_String(String value ) {
        System.out.println("---  " + "Star_A_table_to_String");
        log("---  " + "Star_A_table_to_String");
        log(value.toString());
        System.out.println(value);
    }

    void Given_A_table_to_String(String value ) {
        System.out.println("---  " + "Given_A_table_to_String");
        log("---  " + "Given_A_table_to_String");
        log(value.toString());
        System.out.println(value);
    }

    void Then_string_should_be_same_as(String value ) {
        System.out.println("---  " + "Then_string_should_be_same_as");
        log("---  " + "Then_string_should_be_same_as");
        log(value.toString());
        System.out.println(value);
    }

    void Given_A_table_to_List_of_Object_with_Defaults(List<ExampleClass> values ) {
        System.out.println("---  " + "Given_A_table_to_List_of_Object_with_Defaults");
        log("---  " + "Given_A_table_to_List_of_Object_with_Defaults");
        log(values.toString());
        for (ExampleClass value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void Then_table_should_be_same_as(List<ExampleClass> values ) {
        System.out.println("---  " + "Then_table_should_be_same_as");
        log("---  " + "Then_table_should_be_same_as");
        log(values.toString());
        for (ExampleClass value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void Given_A_table_to_List_of_Object(List<ExampleClass> values ) {
        System.out.println("---  " + "Given_A_table_to_List_of_Object");
        log("---  " + "Given_A_table_to_List_of_Object");
        log(values.toString());
        for (ExampleClass value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void Then_transposed_table_to_List_of_Object_should_be_the_same(List<ExampleClass> values ) {
        System.out.println("---  " + "Then_transposed_table_to_List_of_Object_should_be_the_same");
        log("---  " + "Then_transposed_table_to_List_of_Object_should_be_the_same");
        log(values.toString());
        for (ExampleClass value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void Given_board_is(List<List<String>> values ) {
        System.out.println("---  " + "Given_board_is");
        log("---  " + "Given_board_is");
        log(values.toString());
        for (List<String> value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void When_move_is(List<Move> values ) {
        System.out.println("---  " + "When_move_is");
        log("---  " + "When_move_is");
        log(values.toString());
        for (Move value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            MoveInternal i = value.toMoveInternal();
        }
    }

    void Then_board_is_now(String value ) {
        System.out.println("---  " + "Then_board_is_now");
        log("---  " + "Then_board_is_now");
        log(value.toString());
        System.out.println(value);
    }

    void When_one_move_is(List<List<String>> values ) {
        System.out.println("---  " + "When_one_move_is");
        log("---  " + "When_one_move_is");
        log(values.toString());
        for (List<String> value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void When_moves_are(List<Move> values ) {
        System.out.println("---  " + "When_moves_are");
        log("---  " + "When_moves_are");
        log(values.toString());
        for (Move value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            MoveInternal i = value.toMoveInternal();
        }
    }

    void Given_one_object_is(List<SimpleClass> values ) {
        System.out.println("---  " + "Given_one_object_is");
        log("---  " + "Given_one_object_is");
        log(values.toString());
        for (SimpleClass value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            SimpleClassInternal i = value.toSimpleClassInternal();
        }
    }

    void Then_Json_should_be(String value ) {
        System.out.println("---  " + "Then_Json_should_be");
        log("---  " + "Then_Json_should_be");
        log(value.toString());
        System.out.println(value);
    }

    void Given_Json_is(String value ) {
        System.out.println("---  " + "Given_Json_is");
        log("---  " + "Given_Json_is");
        log(value.toString());
        System.out.println(value);
    }

    void Then_the_converted_object_is(List<SimpleClass> values ) {
        System.out.println("---  " + "Then_the_converted_object_is");
        log("---  " + "Then_the_converted_object_is");
        log(values.toString());
        for (SimpleClass value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            SimpleClassInternal i = value.toSimpleClassInternal();
        }
    }

    void Given_a_table_is(List<SimpleClass> values ) {
        System.out.println("---  " + "Given_a_table_is");
        log("---  " + "Given_a_table_is");
        log(values.toString());
        for (SimpleClass value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            SimpleClassInternal i = value.toSimpleClassInternal();
        }
    }

    void Then_Json_for_table_should_be(String value ) {
        System.out.println("---  " + "Then_Json_for_table_should_be");
        log("---  " + "Then_Json_for_table_should_be");
        log(value.toString());
        System.out.println(value);
    }

    void Given_Json_for_table_is(String value ) {
        System.out.println("---  " + "Given_Json_for_table_is");
        log("---  " + "Given_Json_for_table_is");
        log(value.toString());
        System.out.println(value);
    }

    void Then_the_converted_table_should_be(List<SimpleClass> values ) {
        System.out.println("---  " + "Then_the_converted_table_should_be");
        log("---  " + "Then_the_converted_table_should_be");
        log(values.toString());
        for (SimpleClass value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            SimpleClassInternal i = value.toSimpleClassInternal();
        }
    }

    public static List<List<Integer>> convertList(List<List<String>> stringList) {
        List<List<Integer>> classList = new ArrayList<>();
        for (List<String> innerList : stringList) {
            List<Integer> innerClassList = new ArrayList<>();
            for (String s : innerList) {
                innerClassList.add(Integer.valueOf(s));
            }
            classList.add(innerClassList);
        }
        return classList;
    }

}

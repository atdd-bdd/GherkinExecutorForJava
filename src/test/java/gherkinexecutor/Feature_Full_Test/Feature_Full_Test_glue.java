package gherkinexecutor.Feature_Full_Test;
import java.util.*;
import java.util.regex.Pattern;
import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class Feature_Full_Test_glue {
    final String DNCString = "?DNC?";


    void Given_Background_function_sets_a_value(List<List<String>> values ) {
        System.out.println("---  " + "Given_Background_function_sets_a_value");
        for (List<String> value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
        fail("Must implement");
    }

    void Given_value_for_cleanup_should_be_set_to(List<List<String>> values ) {
        System.out.println("---  " + "Given_value_for_cleanup_should_be_set_to");
        for (List<String> value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
        fail("Must implement");
    }

    void Given_a_regular_function(){
        System.out.println("---  " + "Given_a_regular_function");
        fail("Must implement");
    }

    void Then_background_should_set_value_to(List<List<String>> values ) {
        System.out.println("---  " + "Then_background_should_set_value_to");
        for (List<String> value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
        fail("Must implement");
    }

    void And_set_a_value_for_cleanup(List<List<String>> values ) {
        System.out.println("---  " + "And_set_a_value_for_cleanup");
        for (List<String> value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
        fail("Must implement");
    }

    void Given_table_is(List<ATest> values ) {
        System.out.println("---  " + "Given_table_is");
        for (ATest value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            ATestInternal i = value.toATestInternal();
        }
        fail("Must implement");
    }

    void When_compared_to(List<ATest> values ) {
        System.out.println("---  " + "When_compared_to");
        for (ATest value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            ATestInternal i = value.toATestInternal();
        }
        fail("Must implement");
    }

    void Then_result_is(List<List<String>> values ) {
        System.out.println("---  " + "Then_result_is");
        for (List<String> value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
        fail("Must implement");
    }

    void Given_table_is_bad_initializer(List<ATestBad> values ) {
        System.out.println("---  " + "Given_table_is_bad_initializer");
        for (ATestBad value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            ATestBadInternal i = value.toATestBadInternal();
        }
        fail("Must implement");
    }

    void Given_this_data(List<IDValue> values ) {
        System.out.println("---  " + "Given_this_data");
        for (IDValue value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
        fail("Must implement");
    }

    void Then_should_be_equal_to_data(List<IDValue> values ) {
        System.out.println("---  " + "Then_should_be_equal_to_data");
        for (IDValue value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
        fail("Must implement");
    }

    void Calculation_Convert_F_to_C(List<FandC> values ) {
        System.out.println("---  " + "Calculation_Convert_F_to_C");
        for (FandC value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            FandCInternal i = value.toFandCInternal();
        }
        fail("Must implement");
    }

    void Rule_ID_must_have_exactly_5_letters_and_begin_with_Q(List<ValueValid> values ) {
        System.out.println("---  " + "Rule_ID_must_have_exactly_5_letters_and_begin_with_Q");
        for (ValueValid value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            ValueValidInternal i = value.toValueValidInternal();
        }
        fail("Must implement");
    }

    void Given_list_of_numbers(List<LabelValue> values ) {
        System.out.println("---  " + "Given_list_of_numbers");
        for (LabelValue value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            LabelValueInternal i = value.toLabelValueInternal();
        }
        fail("Must implement");
    }

    void When_filtered_by_ID_with_value(List<List<String>> values ) {
        System.out.println("---  " + "When_filtered_by_ID_with_value");
        for (List<String> value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
        fail("Must implement");
    }

    void Then_sum_is(List<List<String>> values ) {
        System.out.println("---  " + "Then_sum_is");
        for (List<String> value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
        fail("Must implement");
    }

    void When_filtered_by(List<FilterValue> values ) {
        System.out.println("---  " + "When_filtered_by");
        for (FilterValue value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            FilterValueInternal i = value.toFilterValueInternal();
        }
        fail("Must implement");
    }

    void Then_result(List<ResultValue> values ) {
        System.out.println("---  " + "Then_result");
        for (ResultValue value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            ResultValueInternal i = value.toResultValueInternal();
        }
        fail("Must implement");
    }

    void Given_this_data_should_be_okay(List<ImportData> values ) {
        System.out.println("---  " + "Given_this_data_should_be_okay");
        for (ImportData value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            ImportDataInternal i = value.toImportDataInternal();
        }
        fail("Must implement");
    }

    void Given_this_data_should_fail(List<ImportData> values ) {
        System.out.println("---  " + "Given_this_data_should_fail");
        for (ImportData value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            ImportDataInternal i = value.toImportDataInternal();
        }
        fail("Must implement");
    }

    void Given_a_string_include(String value ) {
        System.out.println("---  " + "Given_a_string_include");
        System.out.println(value);
        fail("Must implement");
    }

    void Then_should_be_equal_to(String value ) {
        System.out.println("---  " + "Then_should_be_equal_to");
        System.out.println(value);
        fail("Must implement");
    }

    void Given_a_table(List<CSVContents> values ) {
        System.out.println("---  " + "Given_a_table");
        for (CSVContents value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
        fail("Must implement");
    }

    void Then_Should_be_equal_to_table(List<CSVContents> values ) {
        System.out.println("---  " + "Then_Should_be_equal_to_table");
        for (CSVContents value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
        fail("Must implement");
    }

    void Star_A_multiline_string_to_a_string(String value ) {
        System.out.println("---  " + "Star_A_multiline_string_to_a_string");
        System.out.println(value);
        fail("Must implement");
    }

    void Star_A_multiline_string_to_a_List_of_String(List<String> values ) {
        System.out.println("---  " + "Star_A_multiline_string_to_a_List_of_String");
        for (String value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
        fail("Must implement");
    }

    void Given_multiline_string(String value ) {
        System.out.println("---  " + "Given_multiline_string");
        System.out.println(value);
        fail("Must implement");
    }

    void Then_should_be_equal_to_this_list(List<String> values ) {
        System.out.println("---  " + "Then_should_be_equal_to_this_list");
        for (String value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
        fail("Must implement");
    }

    void Star_A_table_to_List_of_List_of_String(List<List<String>> values ) {
        System.out.println("---  " + "Star_A_table_to_List_of_List_of_String");
        for (List<String> value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
        fail("Must implement");
    }

    void Star_A_Table_to_List_Of_List_Of_Object(List<List<String>> values ) {
        List<List<Integer>> is = convertList(values);
        System.out.println(is);
        fail("Must implement");
    }

    void Star_A_table_to_List_of_Object(List<ExampleClass> values ) {
        System.out.println("---  " + "Star_A_table_to_List_of_Object");
        for (ExampleClass value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
        fail("Must implement");
    }

    void Star_A_table_to_List_of_Object_with_Defaults(List<ExampleClass> values ) {
        System.out.println("---  " + "Star_A_table_to_List_of_Object_with_Defaults");
        for (ExampleClass value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
        fail("Must implement");
    }

    void Star_A_table_to_List_of_Object_with_Blanks_in_Values(List<ExampleClassWithBlanks> values ) {
        System.out.println("---  " + "Star_A_table_to_List_of_Object_with_Blanks_in_Values");
        for (ExampleClassWithBlanks value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
        fail("Must implement");
    }

    void Star_A_table_to_List_of_Object_with_Blanks_in_Defaults(List<ExampleClassWithBlanks> values ) {
        System.out.println("---  " + "Star_A_table_to_List_of_Object_with_Blanks_in_Defaults");
        for (ExampleClassWithBlanks value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
        fail("Must implement");
    }

    void Star_A_table_to_String(String value ) {
        System.out.println("---  " + "Star_A_table_to_String");
        System.out.println(value);
        fail("Must implement");
    }

    void Given_A_table_to_String(String value ) {
        System.out.println("---  " + "Given_A_table_to_String");
        System.out.println(value);
        fail("Must implement");
    }

    void Then_string_should_be_same_as(String value ) {
        System.out.println("---  " + "Then_string_should_be_same_as");
        System.out.println(value);
        fail("Must implement");
    }

    void Given_A_table_to_List_of_Object_with_Defaults(List<ExampleClass> values ) {
        System.out.println("---  " + "Given_A_table_to_List_of_Object_with_Defaults");
        for (ExampleClass value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
        fail("Must implement");
    }

    void Then_table_should_be_same_as(List<ExampleClass> values ) {
        System.out.println("---  " + "Then_table_should_be_same_as");
        for (ExampleClass value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
        fail("Must implement");
    }

    void Given_A_table_to_List_of_Object(List<ExampleClass> values ) {
        System.out.println("---  " + "Given_A_table_to_List_of_Object");
        for (ExampleClass value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
        fail("Must implement");
    }

    void Then_transposed_table_to_List_of_Object_should_be_the_same(List<ExampleClass> values ) {
        System.out.println("---  " + "Then_transposed_table_to_List_of_Object_should_be_the_same");
        for (ExampleClass value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
        fail("Must implement");
    }

    void Given_board_is(List<List<String>> values ) {
        System.out.println("---  " + "Given_board_is");
        for (List<String> value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
        fail("Must implement");
    }

    void When_move_is(List<Move> values ) {
        System.out.println("---  " + "When_move_is");
        for (Move value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            MoveInternal i = value.toMoveInternal();
        }
        fail("Must implement");
    }

    void Then_board_is_now(String value ) {
        System.out.println("---  " + "Then_board_is_now");
        System.out.println(value);
        fail("Must implement");
    }

    void When_one_move_is(List<List<String>> values ) {
        System.out.println("---  " + "When_one_move_is");
        for (List<String> value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
        fail("Must implement");
    }

    void When_moves_are(List<Move> values ) {
        System.out.println("---  " + "When_moves_are");
        for (Move value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            MoveInternal i = value.toMoveInternal();
        }
        fail("Must implement");
    }

    void Given_one_object_is(List<SimpleClass> values ) {
        System.out.println("---  " + "Given_one_object_is");
        for (SimpleClass value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            SimpleClassInternal i = value.toSimpleClassInternal();
        }
        fail("Must implement");
    }

    void Then_Json_should_be(String value ) {
        System.out.println("---  " + "Then_Json_should_be");
        System.out.println(value);
        fail("Must implement");
    }

    void Given_Json_is(String value ) {
        System.out.println("---  " + "Given_Json_is");
        System.out.println(value);
        fail("Must implement");
    }

    void Then_the_converted_object_is(List<SimpleClass> values ) {
        System.out.println("---  " + "Then_the_converted_object_is");
        for (SimpleClass value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            SimpleClassInternal i = value.toSimpleClassInternal();
        }
        fail("Must implement");
    }

    void Given_a_table_is(List<SimpleClass> values ) {
        System.out.println("---  " + "Given_a_table_is");
        for (SimpleClass value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            SimpleClassInternal i = value.toSimpleClassInternal();
        }
        fail("Must implement");
    }

    void Then_Json_for_table_should_be(String value ) {
        System.out.println("---  " + "Then_Json_for_table_should_be");
        System.out.println(value);
        fail("Must implement");
    }

    void Given_Json_for_table_is(String value ) {
        System.out.println("---  " + "Given_Json_for_table_is");
        System.out.println(value);
        fail("Must implement");
    }

    void Then_the_converted_table_should_be(List<SimpleClass> values ) {
        System.out.println("---  " + "Then_the_converted_table_should_be");
        for (SimpleClass value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            SimpleClassInternal i = value.toSimpleClassInternal();
        }
        fail("Must implement");
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

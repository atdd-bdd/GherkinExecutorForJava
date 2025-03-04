package gherkinexecutor.Feature_Full_Test;
import java.util.*;
import java.util.regex.Pattern;
import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class Feature_Full_Test_glue {
    final String DNCString = "?DNC?";


    void Given_Background_Function(){
        System.out.println("---  " + "Given_Background_Function");
    }

    void Given_Cleanup_Function(){
        System.out.println("---  " + "Given_Cleanup_Function");
    }

    void Given_a_regular_function(){
        System.out.println("---  " + "Given_a_regular_function");
    }

    void Given_table_is(List<ATest> values ) {
        System.out.println("---  " + "Given_table_is");
        for (ATest value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            ATestInternal i = value.toATestInternal();
        }
    }

    void When_compared_to(List<ATest> values ) {
        System.out.println("---  " + "When_compared_to");
        for (ATest value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            ATestInternal i = value.toATestInternal();
        }
    }

    void Then_result_is(List<List<String>> values ) {
        System.out.println("---  " + "Then_result_is");
        for (List<String> value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void Given_table_is_bad_initializer(List<ATestBad> values ) {
        System.out.println("---  " + "Given_table_is_bad_initializer");
        for (ATestBad value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            ATestBadInternal i = value.toATestBadInternal();
        }
    }

    void Given_this_data(List<IDValue> values ) {
        System.out.println("---  " + "Given_this_data");
        for (IDValue value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void Then_should_be_equal_to_data(List<IDValue> values ) {
        System.out.println("---  " + "Then_should_be_equal_to_data");
        for (IDValue value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void Calculation_Convert_F_to_C(List<TemperatureCalculation> values ) {
        System.out.println("---  " + "Calculation_Convert_F_to_C");
        for (TemperatureCalculation value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            TemperatureCalculationInternal i = value.toTemperatureCalculationInternal();
        }
    }

    void Rule_ID_must_have_exactly_5_letters_and_begin_with_Q(List<ValueValid> values ) {
        System.out.println("---  " + "Rule_ID_must_have_exactly_5_letters_and_begin_with_Q");
        for (ValueValid value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            ValueValidInternal i = value.toValueValidInternal();
        }
    }

    void Given_list_of_numbers(List<LabelValue> values ) {
        System.out.println("---  " + "Given_list_of_numbers");
        for (LabelValue value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            LabelValueInternal i = value.toLabelValueInternal();
        }
    }

    void When_filtered_by_Label_with_value(List<List<String>> values ) {
        System.out.println("---  " + "When_filtered_by_Label_with_value");
        for (List<String> value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void Then_sum_is(List<List<String>> values ) {
        System.out.println("---  " + "Then_sum_is");
        for (List<String> value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void When_filtered_by(List<FilterValue> values ) {
        System.out.println("---  " + "When_filtered_by");
        for (FilterValue value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            FilterValueInternal i = value.toFilterValueInternal();
        }
    }

    void Then_result(List<ResultValue> values ) {
        System.out.println("---  " + "Then_result");
        for (ResultValue value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            ResultValueInternal i = value.toResultValueInternal();
        }
    }

    void Given_this_data_should_be_okay(List<Imports> values ) {
        System.out.println("---  " + "Given_this_data_should_be_okay");
        for (Imports value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            ImportsInternal i = value.toImportsInternal();
        }
    }

    void Given_this_data_should_fail(List<Imports> values ) {
        System.out.println("---  " + "Given_this_data_should_fail");
        for (Imports value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            ImportsInternal i = value.toImportsInternal();
        }
    }

    void Given_a_string_include(String value ) {
        System.out.println("---  " + "Given_a_string_include");
        System.out.println(value);
    }

    void Given_a_table(List<List<String>> values ) {
        System.out.println("---  " + "Given_a_table");
        for (List<String> value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void Given(String value ) {
        System.out.println("---  " + "Given");
        System.out.println(value);
    }

    void When_converted_result_is(String value ) {
        System.out.println("---  " + "When_converted_result_is");
        System.out.println(value);
    }

    void Given_input_table(List<List<String>> values ) {
        System.out.println("---  " + "Given_input_table");
        for (List<String> value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void When_transposed_result_is(List<List<String>> values ) {
        System.out.println("---  " + "When_transposed_result_is");
        for (List<String> value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void Star_A_multiline_string_to_a_string(String value ) {
        System.out.println("---  " + "Star_A_multiline_string_to_a_string");
        System.out.println(value);
    }

    void Star_A_multiline_string_to_a_List_of_String(List<String> values ) {
        System.out.println("---  " + "Star_A_multiline_string_to_a_List_of_String");
        for (String value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void Star_A_table_to_List_of_List_of_String(List<List<String>> values ) {
        System.out.println("---  " + "Star_A_table_to_List_of_List_of_String");
        for (List<String> value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void Star_A_table_to_List_of_Object(List<ExampleClass> values ) {
        System.out.println("---  " + "Star_A_table_to_List_of_Object");
        for (ExampleClass value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void Star_A_table_to_List_of_Object_with_Defaults(List<ExampleClass> values ) {
        System.out.println("---  " + "Star_A_table_to_List_of_Object_with_Defaults");
        for (ExampleClass value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void Star_A_table_to_List_of_Object_with_Blanks_in_Name(List<ExampleClassWithBlanks> values ) {
        System.out.println("---  " + "Star_A_table_to_List_of_Object_with_Blanks_in_Name");
        for (ExampleClassWithBlanks value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void Star_A_table_to_String(String value ) {
        System.out.println("---  " + "Star_A_table_to_String");
        System.out.println(value);
    }

    void Given_board_is(List<List<String>> values ) {
        System.out.println("---  " + "Given_board_is");
        for (List<String> value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void When_move_is(List<Move> values ) {
        System.out.println("---  " + "When_move_is");
        for (Move value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            MoveInternal i = value.toMoveInternal();
        }
    }

    void Then_board_is_now(String value ) {
        System.out.println("---  " + "Then_board_is_now");
        System.out.println(value);
    }

    void When_one_move_is(List<List<String>> values ) {
        System.out.println("---  " + "When_one_move_is");
        for (List<String> value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
    }

    void When_moves_are(List<Move> values ) {
        System.out.println("---  " + "When_moves_are");
        for (Move value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            MoveInternal i = value.toMoveInternal();
        }
    }

}

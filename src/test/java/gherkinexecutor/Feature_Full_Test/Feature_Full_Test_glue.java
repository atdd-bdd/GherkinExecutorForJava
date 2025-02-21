package gherkinexecutor.Feature_Full_Test;
import java.util.*;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

class Feature_Full_Test_glue {
    void log(String value) {
        try {
            FileWriter myLog = new FileWriter("src/test/java/gherkinexecutor/Feature_Full_Test/log.txt", true);
            myLog.write(value + "\n");
            myLog.close();
        } catch (IOException e) {
            System.err.println("*** Cannot write to log ");
        }
    }


    void Given_a_string(String value ) {
        System.out.println("---  " + "Given_a_string");
        log("---  " + "Given_a_string");
        log(value);
        System.out.println(value);
    }

    void Then_a_table(List<List<String>> values ) {
        System.out.println("---  " + "Then_a_table");
        log("---  " + "Then_a_table");
        log(values.toString());
        for (List<String> value : values){
            System.out.println(value);
        }
    }

    void Given_Background_Function(){
        System.out.println("---  " + "Given_Background_Function");
        log("---  " + "Given_Background_Function");
    }

    void Given_Cleanup_Function(){
        System.out.println("---  " + "Given_Cleanup_Function");
        log("---  " + "Given_Cleanup_Function");
    }

    void Given_a_regular_function(){
        System.out.println("---  " + "Given_a_regular_function");
        log("---  " + "Given_a_regular_function");
    }

    void Given_table_is(List<ATest> values ) {
        System.out.println("---  " + "Given_table_is");
        log("---  " + "Given_table_is");
        log(values.toString());
        for (ATest value : values){
            System.out.println(value);
        }
    }

    void When_compared_to(List<ATest> values ) {
        System.out.println("---  " + "When_compared_to");
        log("---  " + "When_compared_to");
        log(values.toString());
        for (ATest value : values){
            System.out.println(value);
        }
    }

    void Then_result_is(List<List<String>> values ) {
        System.out.println("---  " + "Then_result_is");
        log("---  " + "Then_result_is");
        log(values.toString());
        for (List<String> value : values){
            System.out.println(value);
        }
    }

    void Calculation_Convert_F_to_C(List<TemperatureCalculation> values ) {
        System.out.println("---  " + "Calculation_Convert_F_to_C");
        log("---  " + "Calculation_Convert_F_to_C");
        log(values.toString());
        for (TemperatureCalculation value : values){
            System.out.println(value);
        }
    }

    void Rule_ID_must_have_exactly_5_letters_and_begin_with_Q(List<DomainTermID> values ) {
        System.out.println("---  " + "Rule_ID_must_have_exactly_5_letters_and_begin_with_Q");
        log("---  " + "Rule_ID_must_have_exactly_5_letters_and_begin_with_Q");
        log(values.toString());
        for (DomainTermID value : values){
            System.out.println(value);
        }
    }

    void Given_list_of_numbers(List<LabelValue> values ) {
        System.out.println("---  " + "Given_list_of_numbers");
        log("---  " + "Given_list_of_numbers");
        log(values.toString());
        for (LabelValue value : values){
            System.out.println(value);
        }
    }

    void When_filtered_by_Label_with_value(List<List<String>> values ) {
        System.out.println("---  " + "When_filtered_by_Label_with_value");
        log("---  " + "When_filtered_by_Label_with_value");
        log(values.toString());
        for (List<String> value : values){
            System.out.println(value);
        }
    }

    void Then_sum_is(List<List<String>> values ) {
        System.out.println("---  " + "Then_sum_is");
        log("---  " + "Then_sum_is");
        log(values.toString());
        for (List<String> value : values){
            System.out.println(value);
        }
    }

    void Star_A_multiline_string_to_a_string(String value ) {
        System.out.println("---  " + "Star_A_multiline_string_to_a_string");
        log("---  " + "Star_A_multiline_string_to_a_string");
        log(value);
        System.out.println(value);
    }

    void Star_A_multiline_string_to_a_List_of_String(List<String> values ) {
        System.out.println("---  " + "Star_A_multiline_string_to_a_List_of_String");
        log("---  " + "Star_A_multiline_string_to_a_List_of_String");
        log(values.toString());
        for (String value : values){
            System.out.println(value);
        }
    }

    void Star_A_table_to_List_of_List_of_String(List<List<String>> values ) {
        System.out.println("---  " + "Star_A_table_to_List_of_List_of_String");
        log("---  " + "Star_A_table_to_List_of_List_of_String");
        log(values.toString());
        for (List<String> value : values){
            System.out.println(value);
        }
    }

    void Star_A_table_to_List_of_Object(List<ExampleClass> values ) {
        System.out.println("---  " + "Star_A_table_to_List_of_Object");
        log("---  " + "Star_A_table_to_List_of_Object");
        log(values.toString());
        for (ExampleClass value : values){
            System.out.println(value);
        }
    }

    void Star_A_table_to_List_of_Object_with_Defaults(List<ExampleClass> values ) {
        System.out.println("---  " + "Star_A_table_to_List_of_Object_with_Defaults");
        log("---  " + "Star_A_table_to_List_of_Object_with_Defaults");
        log(values.toString());
        for (ExampleClass value : values){
            System.out.println(value);
        }
    }

    void Star_A_table_to_List_of_Object_with_Blanks_in_Name(List<ExampleClassWithBlanks> values ) {
        System.out.println("---  " + "Star_A_table_to_List_of_Object_with_Blanks_in_Name");
        log("---  " + "Star_A_table_to_List_of_Object_with_Blanks_in_Name");
        log(values.toString());
        for (ExampleClassWithBlanks value : values){
            System.out.println(value);
        }
    }

    void Star_A_table_to_String(String value ) {
        System.out.println("---  " + "Star_A_table_to_String");
        log("---  " + "Star_A_table_to_String");
        log(value);
        System.out.println(value);
    }

}

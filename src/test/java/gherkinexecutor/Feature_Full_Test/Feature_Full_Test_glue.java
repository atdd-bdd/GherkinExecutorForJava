package gherkinexecutor.Feature_Full_Test;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

class Feature_Full_Test_glue {
    void log(String value) {
        try {
            FileWriter mylog = new FileWriter("src/test/java/gherkinexecutor/Feature_Full_Test/log.txt", true);
            mylog.write(value + "\n");
            mylog.close();
        } catch (IOException e) {
            System.out.println("**** Cannot write to log ");
        }
    }


    void Given_a_string(String value ) {
        System.out.println("---  " + "Given_a_string");
        System.out.println("*******");
        log("---  " + "Given_a_string");
        log("*******");
        log(value.toString());
        System.out.println(value);
    }

    void Then_a_table(List<List<String>> value ) {
        System.out.println("---  " + "Then_a_table");
        System.out.println("*******");
        log("---  " + "Then_a_table");
        log("*******");
        log(value.toString());
        System.out.println(value);
        for (List<String> v : value){
            System.out.println(v);
        };
    }

    void Given(String value ) {
        System.out.println("---  " + "Given");
        System.out.println("*******");
        log("---  " + "Given");
        log("*******");
        log(value.toString());
        System.out.println(value);
    }

    void When_converted_result_is(String value ) {
        System.out.println("---  " + "When_converted_result_is");
        System.out.println("*******");
        log("---  " + "When_converted_result_is");
        log("*******");
        log(value.toString());
        System.out.println(value);
    }

    void Given_input_table(List<List<String>> value ) {
        System.out.println("---  " + "Given_input_table");
        System.out.println("*******");
        log("---  " + "Given_input_table");
        log("*******");
        log(value.toString());
        System.out.println(value);
        for (List<String> v : value){
            System.out.println(v);
        };
    }

    void When_transposed_result_is(List<List<String>> value ) {
        System.out.println("---  " + "When_transposed_result_is");
        System.out.println("*******");
        log("---  " + "When_transposed_result_is");
        log("*******");
        log(value.toString());
        System.out.println(value);
        for (List<String> v : value){
            System.out.println(v);
        };
    }

    void Given_Background_Function(){
        System.out.println("---  " + "Given_Background_Function");
        System.out.println("*******");
        log("---  " + "Given_Background_Function");
        log("*******");
    }

    void Given_Cleanup_Function(){
        System.out.println("---  " + "Given_Cleanup_Function");
        System.out.println("*******");
        log("---  " + "Given_Cleanup_Function");
        log("*******");
    }

    void Given_a_regular_function(){
        System.out.println("---  " + "Given_a_regular_function");
        System.out.println("*******");
        log("---  " + "Given_a_regular_function");
        log("*******");
    }

    void Given_table_is(List<ATest> value ) {
        System.out.println("---  " + "Given_table_is");
        System.out.println("*******");
        log("---  " + "Given_table_is");
        log("*******");
        log(value.toString());
        System.out.println(value);
        for (ATest v : value){
            System.out.println(v);
        };
    }

    void When_compared_to(List<ATest> value ) {
        System.out.println("---  " + "When_compared_to");
        System.out.println("*******");
        log("---  " + "When_compared_to");
        log("*******");
        log(value.toString());
        System.out.println(value);
        for (ATest v : value){
            System.out.println(v);
        };
    }

    void Then_result_is(List<List<String>> value ) {
        System.out.println("---  " + "Then_result_is");
        System.out.println("*******");
        log("---  " + "Then_result_is");
        log("*******");
        log(value.toString());
        System.out.println(value);
        for (List<String> v : value){
            System.out.println(v);
        };
    }

    void Calculation_Convert_F_to_C(List<TemperatureCalculation> value ) {
        System.out.println("---  " + "Calculation_Convert_F_to_C");
        System.out.println("*******");
        log("---  " + "Calculation_Convert_F_to_C");
        log("*******");
        log(value.toString());
        System.out.println(value);
        for (TemperatureCalculation v : value){
            System.out.println(v);
        };
    }

    void Rule_ID_must_have_exactly_5_letters_and_begin_with_Q(List<DomainTermID> value ) {
        System.out.println("---  " + "Rule_ID_must_have_exactly_5_letters_and_begin_with_Q");
        System.out.println("*******");
        log("---  " + "Rule_ID_must_have_exactly_5_letters_and_begin_with_Q");
        log("*******");
        log(value.toString());
        System.out.println(value);
        for (DomainTermID v : value){
            System.out.println(v);
        };
    }

    void Given_list_of_numbers(List<LabelValue> value ) {
        System.out.println("---  " + "Given_list_of_numbers");
        System.out.println("*******");
        log("---  " + "Given_list_of_numbers");
        log("*******");
        log(value.toString());
        System.out.println(value);
        for (LabelValue v : value){
            System.out.println(v);
        };
    }

    void When_filtered_by_Label_with_value(List<List<String>> value ) {
        System.out.println("---  " + "When_filtered_by_Label_with_value");
        System.out.println("*******");
        log("---  " + "When_filtered_by_Label_with_value");
        log("*******");
        log(value.toString());
        System.out.println(value);
        for (List<String> v : value){
            System.out.println(v);
        };
    }

    void Then_sum_is(List<List<String>> value ) {
        System.out.println("---  " + "Then_sum_is");
        System.out.println("*******");
        log("---  " + "Then_sum_is");
        log("*******");
        log(value.toString());
        System.out.println(value);
        for (List<String> v : value){
            System.out.println(v);
        };
    }

    void Star_A_multiline_string_to_a_string(String value ) {
        System.out.println("---  " + "Star_A_multiline_string_to_a_string");
        System.out.println("*******");
        log("---  " + "Star_A_multiline_string_to_a_string");
        log("*******");
        log(value.toString());
        System.out.println(value);
    }

    void Star_A_multiline_string_to_a_List_of_String(List<String> value ) {
        System.out.println("---  " + "Star_A_multiline_string_to_a_List_of_String");
        System.out.println("*******");
        log("---  " + "Star_A_multiline_string_to_a_List_of_String");
        log("*******");
        log(value.toString());
        System.out.println(value);
        for (String v : value){
            System.out.println(v);
        };
    }

    void Star_A_table_to_List_of_List_of_String(List<List<String>> value ) {
        System.out.println("---  " + "Star_A_table_to_List_of_List_of_String");
        System.out.println("*******");
        log("---  " + "Star_A_table_to_List_of_List_of_String");
        log("*******");
        log(value.toString());
        System.out.println(value);
        for (List<String> v : value){
            System.out.println(v);
        };
    }

    void Star_A_table_to_List_of_Object(List<ExampleClass> value ) {
        System.out.println("---  " + "Star_A_table_to_List_of_Object");
        System.out.println("*******");
        log("---  " + "Star_A_table_to_List_of_Object");
        log("*******");
        log(value.toString());
        System.out.println(value);
        for (ExampleClass v : value){
            System.out.println(v);
        };
    }

    void Star_A_table_to_List_of_Object_with_Defaults(List<ExampleClass> value ) {
        System.out.println("---  " + "Star_A_table_to_List_of_Object_with_Defaults");
        System.out.println("*******");
        log("---  " + "Star_A_table_to_List_of_Object_with_Defaults");
        log("*******");
        log(value.toString());
        System.out.println(value);
        for (ExampleClass v : value){
            System.out.println(v);
        };
    }

    void Star_A_table_to_List_of_Object_with_Blanks_in_Name(List<ExampleClassWithBlanks> value ) {
        System.out.println("---  " + "Star_A_table_to_List_of_Object_with_Blanks_in_Name");
        System.out.println("*******");
        log("---  " + "Star_A_table_to_List_of_Object_with_Blanks_in_Name");
        log("*******");
        log(value.toString());
        System.out.println(value);
        for (ExampleClassWithBlanks v : value){
            System.out.println(v);
        };
    }

    void Star_A_table_to_String(String value ) {
        System.out.println("---  " + "Star_A_table_to_String");
        System.out.println("*******");
        log("---  " + "Star_A_table_to_String");
        log("*******");
        log(value.toString());
        System.out.println(value);
    }

}

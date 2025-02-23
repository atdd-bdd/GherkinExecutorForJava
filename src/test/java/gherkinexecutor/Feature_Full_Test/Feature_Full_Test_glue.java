package gherkinexecutor.Feature_Full_Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class Feature_Full_Test_glue {


    void Given_a_string(String value ) {
        System.out.println("---  " + "Given_a_string");
        System.out.println(value);
        fail("Must implement");
    }

    void Then_a_table(List<List<String>> values ) {
        System.out.println("---  " + "Then_a_table");
        for (List<String> value : values){
            System.out.println(value);
        }
        fail("Must implement");
    }

    void Given_Background_Function(){
        System.out.println("---  " + "Given_Background_Function");
        fail("Must implement");
    }

    void Given_Cleanup_Function(){
        System.out.println("---  " + "Given_Cleanup_Function");
        fail("Must implement");
    }

    void Given_a_regular_function(){
        System.out.println("---  " + "Given_a_regular_function");
        fail("Must implement");
    }

    void Given_table_is(List<ATest> values ) {
        System.out.println("---  " + "Given_table_is");
        for (ATest value : values){
            System.out.println(value);
            try {
                ATestInternal i = value.toATestInternal();
                System.out.println(i);
            }
            catch(Exception e){
                System.err.println("Argument Error " + value.toString() + ATestInternal.toDataTypeString());
            }
        }
        fail("Must implement");
    }

    void When_compared_to(List<ATest> values ) {
        System.out.println("---  " + "When_compared_to");
        for (ATest value : values){
            System.out.println(value);
            try {
                ATestInternal i = value.toATestInternal();
                System.out.println(i);
            }
            catch(Exception e){
                System.err.println("Argument Error " + value.toString() + ATestInternal.toDataTypeString());
            }
        }
        fail("Must implement");
    }

    void Then_result_is(List<List<String>> values ) {
        System.out.println("---  " + "Then_result_is");
        for (List<String> value : values){
            System.out.println(value);
        }
        fail("Must implement");
    }

    void Calculation_Convert_F_to_C(List<TemperatureCalculation> values ) {
        System.out.println("---  " + "Calculation_Convert_F_to_C");
        for (TemperatureCalculation value : values){
            System.out.println(value);
            try {
                TemperatureCalculationInternal i = value.toTemperatureCalculationInternal();
                System.out.println(i);
            }
            catch(Exception e){
                System.err.println("Argument Error " + value.toString() + TemperatureCalculationInternal.toDataTypeString());
            }
        }
        fail("Must implement");
    }

    void Rule_ID_must_have_exactly_5_letters_and_begin_with_Q(List<DomainTermID> values ) {
        System.out.println("---  " + "Rule_ID_must_have_exactly_5_letters_and_begin_with_Q");
        for (DomainTermID value : values){
            System.out.println(value);
            try {
                DomainTermIDInternal i = value.toDomainTermIDInternal();
                System.out.println(i);
            }
            catch(Exception e){
                System.err.println("Argument Error " + value.toString() + DomainTermIDInternal.toDataTypeString());
            }
        }
        fail("Must implement");
    }

    void Given_list_of_numbers(List<LabelValue> values ) {
        System.out.println("---  " + "Given_list_of_numbers");
        for (LabelValue value : values){
            System.out.println(value);
            try {
                LabelValueInternal i = value.toLabelValueInternal();
                System.out.println(i);
            }
            catch(Exception e){
                System.err.println("Argument Error " + value.toString() + LabelValueInternal.toDataTypeString());
            }
        }
        fail("Must implement");
    }

    void When_filtered_by_Label_with_value(List<List<String>> values ) {
        System.out.println("---  " + "When_filtered_by_Label_with_value");
        for (List<String> value : values){
            System.out.println(value);
        }
        fail("Must implement");
    }

    void Then_sum_is(List<List<String>> values ) {
        System.out.println("---  " + "Then_sum_is");
        for (List<String> value : values){
            System.out.println(value);
        }
        fail("Must implement");
    }

    void When_filtered_by(List<FilterValue> values ) {
        System.out.println("---  " + "When_filtered_by");
        for (FilterValue value : values){
            System.out.println(value);
            try {
                FilterValueInternal i = value.toFilterValueInternal();
                System.out.println(i);
            }
            catch(Exception e){
                System.err.println("Argument Error " + value.toString() + FilterValueInternal.toDataTypeString());
            }
        }
        fail("Must implement");
    }

    void Then_result(List<ResultValue> values ) {
        System.out.println("---  " + "Then_result");
        for (ResultValue value : values){
            System.out.println(value);
            try {
                ResultValueInternal i = value.toResultValueInternal();
                System.out.println(i);
            }
            catch(Exception e){
                System.err.println("Argument Error " + value.toString() + ResultValueInternal.toDataTypeString());
            }
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
        }
        fail("Must implement");
    }

    void Star_A_table_to_List_of_List_of_String(List<List<String>> values ) {
        System.out.println("---  " + "Star_A_table_to_List_of_List_of_String");
        for (List<String> value : values){
            System.out.println(value);
        }
        fail("Must implement");
    }

    void Star_A_table_to_List_of_Object(List<ExampleClass> values ) {
        System.out.println("---  " + "Star_A_table_to_List_of_Object");
        for (ExampleClass value : values){
            System.out.println(value);
        }
        fail("Must implement");
    }

    void Star_A_table_to_List_of_Object_with_Defaults(List<ExampleClass> values ) {
        System.out.println("---  " + "Star_A_table_to_List_of_Object_with_Defaults");
        for (ExampleClass value : values){
            System.out.println(value);
        }
        fail("Must implement");
    }

    void Star_A_table_to_List_of_Object_with_Blanks_in_Name(List<ExampleClassWithBlanks> values ) {
        System.out.println("---  " + "Star_A_table_to_List_of_Object_with_Blanks_in_Name");
        for (ExampleClassWithBlanks value : values){
            System.out.println(value);
        }
        fail("Must implement");
    }

    void Star_A_table_to_String(String value ) {
        System.out.println("---  " + "Star_A_table_to_String");
        System.out.println(value);
        fail("Must implement");
    }

}

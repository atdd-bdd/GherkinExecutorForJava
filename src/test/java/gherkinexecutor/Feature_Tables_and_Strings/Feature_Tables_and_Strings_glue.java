package gherkinexecutor.Feature_Tables_and_Strings;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class Feature_Tables_and_Strings_glue {
    final String DNCString = "?DNC?";

    String original;
    void Star_A_multiline_string_to_a_string(String value ) {
        System.out.println("---  " + "Star_A_multiline_string_to_a_string");
        System.out.println(value);
        original = value;
    }

    void Star_A_multiline_string_to_a_List_of_String(List<String> values ) {
        System.out.println("---  " + "Star_A_multiline_string_to_a_List_of_String");
        String total = "";
        for (String value : values){
            System.out.println(value);
            total += value;
        }
        assertEquals(total, original);
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
        }
        assertEquals(" ", values.get(0).field_1);
        assertEquals(" ", values.get(1).field_2);
     }

    void Star_A_table_to_List_of_Object_with_Blanks_in_Defaults(List<ExampleClassWithBlanks> values ) {
        System.out.println("---  " + "Star_A_table_to_List_of_Object_with_Blanks_in_Defaults");
        for (ExampleClassWithBlanks value : values){
            System.out.println(value);
        }
        assertEquals(" ", values.get(0).field_1);
        assertEquals(" ", values.get(0).field_2);
        assertEquals(" ", values.get(1).field_2);
    }

    String stringFromTable;
    void Star_A_table_to_String(String value ) {
        System.out.println("---  " + "Star_A_table_to_String");
        System.out.println(value);
    }

    void Given_A_table_to_String(String value ) {
        System.out.println("---  " + "Given_A_table_to_String");
        System.out.println(value);
        stringFromTable = value;
    }

    void Then_string_should_be_same_as(String value ) {
        System.out.println("---  " + "Then_string_should_be_same_as");
        System.out.println(value);
        assertEquals(value, stringFromTable);
    }

    List<ExampleClass> originalList;
    void Given_A_table_to_List_of_Object_with_Defaults(List<ExampleClass> values ) {
        System.out.println("---  " + "Given_A_table_to_List_of_Object_with_Defaults");
        for (ExampleClass value : values){
            System.out.println(value);
         }
        originalList = values;
    }

    void Then_table_should_be_same_as(List<List<String>> values ) {
        System.out.println("---  " + "Then_table_should_be_same_as");
        for (List<String> value : values){
            System.out.println(value);
        }
        assertEquals(values, originalList);
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

}

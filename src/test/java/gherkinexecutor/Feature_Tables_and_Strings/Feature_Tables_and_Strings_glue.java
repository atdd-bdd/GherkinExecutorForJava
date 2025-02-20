package gherkinexecutor.Feature_Tables_and_Strings;
import static org.junit.Assert.fail;
import java.util.List;

class Feature_Tables_and_Strings_glue {

    void Star_A_multiline_string_to_a_string(String value ) {
        System.out.println("---  " + "Star_A_multiline_string_to_a_string");
        System.out.println("*******");
        System.out.println(value);
    }

    void Star_A_multiline_string_to_a_List_of_String(List<String> value ) {
        System.out.println("---  " + "Star_A_multiline_string_to_a_List_of_String");
        System.out.println("*******");
        System.out.println(value);
    }

    void Star_A_table_to_List_of_List_of_String(List<List<String>> value ) {
        System.out.println("---  " + "Star_A_table_to_List_of_List_of_String");
        System.out.println("*******");
        System.out.println(value);
    }

    void Star_A_table_to_List_of_Object(List<ExampleClass> value ) {
        System.out.println("---  " + "Star_A_table_to_List_of_Object");
        System.out.println("*******");
        System.out.println(value);
    }

    void Star_A_table_to_List_of_Object_with_Defaults(List<ExampleClass> value ) {
        System.out.println("---  " + "Star_A_table_to_List_of_Object_with_Defaults");
        System.out.println("*******");
        System.out.println(value);
    }

    void Star_A_table_to_List_of_Object_with_Blanks_in_Name(List<ExampleClassWithBlanks> value ) {
        System.out.println("---  " + "Star_A_table_to_List_of_Object_with_Blanks_in_Name");
        System.out.println("*******");
        System.out.println(value);
    }

    void Star_A_table_to_String(String value ) {
        System.out.println("---  " + "Star_A_table_to_String");
        System.out.println("*******");
        System.out.println(value);
    }

    }

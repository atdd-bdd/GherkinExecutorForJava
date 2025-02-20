package gherkinexecutor.Feature_Tables_and_Strings;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Feature_Tables_and_Strings{
void log(String value) {
    try {
        FileWriter myLog = new FileWriter("src/test/java/gherkinexecutor/Feature_Tables_and_Strings/log.txt", true);
        myLog.write(value + "\n");
        myLog.close();
    } catch (IOException e) {
    System.err.println("*** Cannot write to log ");
    }
    }


    @Test
    void test_Scenario_Here_are_string_options(){
         Feature_Tables_and_Strings_glue feature_Tables_and_Strings_glue_object = new Feature_Tables_and_Strings_glue();
        log("Scenario_Here_are_string_options");

        String string1 =
            """
            One line
            Two line
            """.stripIndent();
        feature_Tables_and_Strings_glue_object.Star_A_multiline_string_to_a_string(string1);

        List<String> stringList2 = List.of(
            "Three line"
            ,"Four line"
            );
        feature_Tables_and_Strings_glue_object.Star_A_multiline_string_to_a_List_of_String(stringList2);
        }
    @Test
    void test_Scenario_Here_are_table_options(){
         Feature_Tables_and_Strings_glue feature_Tables_and_Strings_glue_object = new Feature_Tables_and_Strings_glue();
        log("Scenario_Here_are_table_options");

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
        feature_Tables_and_Strings_glue_object.Star_A_table_to_List_of_List_of_String(stringListList1);

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
        feature_Tables_and_Strings_glue_object.Star_A_table_to_List_of_Object(objectList2);

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
        feature_Tables_and_Strings_glue_object.Star_A_table_to_List_of_Object(objectList3);

        List<ExampleClass> objectList4 = List.of(
             new ExampleClass.Builder()
                .fieldA("a")
                .build()
                
            , new ExampleClass.Builder()
                .fieldA("c")
                .build()
                
            );
        feature_Tables_and_Strings_glue_object.Star_A_table_to_List_of_Object_with_Defaults(objectList4);

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
        feature_Tables_and_Strings_glue_object.Star_A_table_to_List_of_Object_with_Blanks_in_Name(objectList5);

        String table6 = 
            """
            | aa  | bb  |
            | cc  | dd  |
            """.stripIndent();
        feature_Tables_and_Strings_glue_object.Star_A_table_to_String(table6);
        }
    }


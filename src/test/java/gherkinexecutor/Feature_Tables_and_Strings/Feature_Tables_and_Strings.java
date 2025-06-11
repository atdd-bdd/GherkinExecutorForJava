package gherkinexecutor.Feature_Tables_and_Strings;
import org.junit.jupiter.api.*;
import java.util.List;
@SuppressWarnings({"NewClassNamingConvention"})
class Feature_Tables_and_Strings{


    @Test
    void test_Scenario_Here_are_string_options(){
         Feature_Tables_and_Strings_glue feature_Tables_and_Strings_glue_object = new Feature_Tables_and_Strings_glue();

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
    void test_Scenario_Check_String_Variations(){
         Feature_Tables_and_Strings_glue feature_Tables_and_Strings_glue_object = new Feature_Tables_and_Strings_glue();

        String string1 =
            """
            One line
            Two line
            """.stripIndent();
        feature_Tables_and_Strings_glue_object.Given_multiline_string(string1);

        List<String> stringList2 = List.of(
            "One line"
            ,"Two line"
            );
        feature_Tables_and_Strings_glue_object.Then_should_be_equal_to_this_list(stringList2);
        }
    @Test
    void test_Scenario_Here_are_table_options(){
         Feature_Tables_and_Strings_glue feature_Tables_and_Strings_glue_object = new Feature_Tables_and_Strings_glue();

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
        feature_Tables_and_Strings_glue_object.Star_A_Table_to_List_Of_List_Of_Object(stringListList2);

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
        feature_Tables_and_Strings_glue_object.Star_A_table_to_List_of_Object(objectList3);

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
        feature_Tables_and_Strings_glue_object.Star_A_table_to_List_of_Object(objectList4);

        List<ExampleClass> objectList5 = List.of(
             new ExampleClass.Builder()
                .setFieldA("a")
                .build()
            , new ExampleClass.Builder()
                .setFieldA("c")
                .build()
            );
        feature_Tables_and_Strings_glue_object.Star_A_table_to_List_of_Object_with_Defaults(objectList5);

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
        feature_Tables_and_Strings_glue_object.Star_A_table_to_List_of_Object_with_Blanks_in_Values(objectList6);

        List<ExampleClassWithBlanks> objectList7 = List.of(
             new ExampleClassWithBlanks.Builder()
                .setField_1(" ")
                .build()
            , new ExampleClassWithBlanks.Builder()
                .setField_1("c")
                .build()
            );
        feature_Tables_and_Strings_glue_object.Star_A_table_to_List_of_Object_with_Blanks_in_Defaults(objectList7);

        String table8 =
            """
            | aa  | bb  |
            | cc  | dd  |
            """.stripIndent();
        feature_Tables_and_Strings_glue_object.Star_A_table_to_String(table8);
        }
    @Test
    void test_Scenario_Table_to_String(){
         Feature_Tables_and_Strings_glue feature_Tables_and_Strings_glue_object = new Feature_Tables_and_Strings_glue();

        String table1 =
            """
            | aa  | bb  |
            | cc  | dd  |
            """.stripIndent();
        feature_Tables_and_Strings_glue_object.Given_A_table_to_String(table1);

        String string2 =
            """
            | aa  | bb  |
            | cc  | dd  |
            """.stripIndent();
        feature_Tables_and_Strings_glue_object.Then_string_should_be_same_as(string2);
        }
    @Test
    void test_Scenario_Table_without_all_fields_uses_defaults(){
         Feature_Tables_and_Strings_glue feature_Tables_and_Strings_glue_object = new Feature_Tables_and_Strings_glue();

        List<ExampleClass> objectList1 = List.of(
             new ExampleClass.Builder()
                .setFieldA("a")
                .build()
            , new ExampleClass.Builder()
                .setFieldA("c")
                .build()
            );
        feature_Tables_and_Strings_glue_object.Given_A_table_to_List_of_Object_with_Defaults(objectList1);

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
        feature_Tables_and_Strings_glue_object.Then_table_should_be_same_as(objectList2);
        }
    @Test
    void test_Scenario_Transpose_Table(){
         Feature_Tables_and_Strings_glue feature_Tables_and_Strings_glue_object = new Feature_Tables_and_Strings_glue();

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
        feature_Tables_and_Strings_glue_object.Given_A_table_to_List_of_Object(objectList1);

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
        feature_Tables_and_Strings_glue_object.Then_transposed_table_to_List_of_Object_should_be_the_same(objectList2);
        }
    }


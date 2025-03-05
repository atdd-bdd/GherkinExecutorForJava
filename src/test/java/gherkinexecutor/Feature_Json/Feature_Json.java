package gherkinexecutor.Feature_Json;
import org.junit.jupiter.api.Test;
import java.util.List;
class Feature_Json{


    @Test
    void test_Scenario_Convert_to_Json(){
         Feature_Json_glue feature_Json_glue_object = new Feature_Json_glue();

        List<SimpleClass> objectList1 = List.of(
             new SimpleClass.Builder()
                .anInt("1")
                .aString("B")
                .build()
            );
        feature_Json_glue_object.Given_one_object_is(objectList1);

        String string2 =
            """
            {anInt:"1",aString:"B"}
            """.stripIndent();
        feature_Json_glue_object.Then_Json_should_be(string2);
        }
    @Test
    void test_Scenario_Convert_from_Json(){
         Feature_Json_glue feature_Json_glue_object = new Feature_Json_glue();

        String string1 =
            """
            {anInt:  "1"   ,   aString:"B"  }
            """.stripIndent();
        feature_Json_glue_object.Given_Json_is(string1);

        List<SimpleClass> objectList2 = List.of(
             new SimpleClass.Builder()
                .anInt("1")
                .aString("B")
                .build()
            );
        feature_Json_glue_object.Then_the_converted_object_is(objectList2);
        }
    @Test
    void test_Scenario_Convert_to_Json_Array(){
         Feature_Json_glue feature_Json_glue_object = new Feature_Json_glue();

        List<SimpleClass> objectList1 = List.of(
             new SimpleClass.Builder()
                .anInt("1")
                .aString("B")
                .build()
            , new SimpleClass.Builder()
                .anInt("2")
                .aString("C")
                .build()
            );
        feature_Json_glue_object.Given_a_table_is(objectList1);

        String string2 =
            """
            [ {anInt:"1",aString:"B"}
            , {anInt:"2",aString:"C"}
            ]
            """.stripIndent();
        feature_Json_glue_object.Then_Json_for_table_should_be(string2);
        }
    @Test
    void test_Scenario_Convert_from_Json_Array(){
         Feature_Json_glue feature_Json_glue_object = new Feature_Json_glue();

        String string1 =
            """
            [    {anInt:  "1"   ,   aString:"B"  },
            {anInt:  "2"   ,   aString:"C"  }
            ]
            """.stripIndent();
        feature_Json_glue_object.Given_Json_for_table_is(string1);

        List<SimpleClass> objectList2 = List.of(
             new SimpleClass.Builder()
                .anInt("1")
                .aString("B")
                .build()
            , new SimpleClass.Builder()
                .anInt("2")
                .aString("C")
                .build()
            );
        feature_Json_glue_object.Then_the_converted_table_should_be(objectList2);
        }
    }


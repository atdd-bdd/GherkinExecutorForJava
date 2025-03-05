package gherkinexecutor.features.Feature_Quick_Test;
import org.junit.jupiter.api.Test;
import java.util.List;
class Feature_Quick_Test{


    @Test
    void test_Scenario__Title_(){
         Feature_Quick_Test_glue feature_Quick_Test_glue_object = new Feature_Quick_Test_glue();

        List<List<String>> stringListList1 = List.of(
           List.of(
            "5"
            ,"6"
            )
            );
        feature_Quick_Test_glue_object.Given_A_Table_to_List_Of_List_Of_Object(stringListList1);
        }
    @Test
    void test_Scenario_To_and_From_JSON(){
         Feature_Quick_Test_glue feature_Quick_Test_glue_object = new Feature_Quick_Test_glue();

        List<SimpleClass> objectList1 = List.of(
             new SimpleClass.Builder()
                .anInt("1")
                .aString("B")
                .build()
            );
        feature_Quick_Test_glue_object.Given_values_are(objectList1);
        }
    }


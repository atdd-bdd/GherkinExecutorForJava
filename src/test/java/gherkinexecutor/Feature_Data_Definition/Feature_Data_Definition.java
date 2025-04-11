package gherkinexecutor.Feature_Data_Definition;
import org.junit.jupiter.api.Test;
import java.util.List;
class Feature_Data_Definition{


    @Test
    void test_Scenario_Simple_Comparison(){
         Feature_Data_Definition_glue feature_Data_Definition_glue_object = new Feature_Data_Definition_glue();

        List<ATest> objectList1 = List.of(
             new ATest.Builder()
                .setAnInt("1")
                .setAString("something")
                .setADouble("1.2")
                .build()
            );
        feature_Data_Definition_glue_object.Given_table_is(objectList1);

        List<ATest> objectList2 = List.of(
             new ATest.Builder()
             .setCompare()
                .setAString("something")
                .build()
            );
        feature_Data_Definition_glue_object.When_compared_to(objectList2);

        List<List<String>> stringListList3 = List.of(
           List.of(
            "true"
            )
            );
        feature_Data_Definition_glue_object.Then_result_is(stringListList3);

        List<ATest> objectList4 = List.of(
             new ATest.Builder()
             .setCompare()
                .setAString("something else")
                .build()
            );
        feature_Data_Definition_glue_object.When_compared_to(objectList4);

        List<List<String>> stringListList5 = List.of(
           List.of(
            "false"
            )
            );
        feature_Data_Definition_glue_object.Then_result_is(stringListList5);
        }
    }


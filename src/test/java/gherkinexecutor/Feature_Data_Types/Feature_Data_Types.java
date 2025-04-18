package gherkinexecutor.Feature_Data_Types;
import org.junit.jupiter.api.Test;
import java.util.List;
class Feature_Data_Types{


    @Test
    void test_Scenario_Use_the_data_types(){
         Feature_Data_Types_glue feature_Data_Types_glue_object = new Feature_Data_Types_glue();

        List<AllTypes> objectList1 = List.of(
             new AllTypes.Builder()
                .anInt("0")
                .aDouble("0.0")
                .aChar("x")
                .achar("y")
                .build()
            , new AllTypes.Builder()
                .anInt("111")
                .aDouble("222.2")
                .aChar("q")
                .achar("")
                .build()
            );
        feature_Data_Types_glue_object.Given_type_values_are(objectList1);

        List<AllTypes> objectList2 = List.of(
             new AllTypes.Builder()
                .achar("y")
                .anInt("0")
                .aDouble("0.0")
                .aChar("x")
                .build()
            , new AllTypes.Builder()
                .achar("")
                .anInt("111")
                .aDouble("222.2")
                .aChar("q")
                .build()
            );
        feature_Data_Types_glue_object.Then_this_should_be_equal(objectList2);
        }
    }


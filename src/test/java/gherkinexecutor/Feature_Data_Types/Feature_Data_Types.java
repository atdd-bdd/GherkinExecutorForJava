package gherkinexecutor.Feature_Data_Types;
import org.junit.jupiter.api.*;
import java.util.List;
@SuppressWarnings({"NewClassNamingConvention"})
class Feature_Data_Types{


    @Test
    void test_Scenario_Use_the_data_types(){
         Feature_Data_Types_glue feature_Data_Types_glue_object = new Feature_Data_Types_glue();

        List<SomeTypes> objectList1 = List.of(
             new SomeTypes.Builder()
                .setAnInt("0")
                .setADouble("0.0")
                .setAChar("x")
                .setAchar("y")
                .build()
            , new SomeTypes.Builder()
                .setAnInt("111")
                .setADouble("222.2")
                .setAChar("q")
                .setAchar("")
                .build()
            );
        feature_Data_Types_glue_object.Given_type_values_are(objectList1);

        List<SomeTypes> objectList2 = List.of(
             new SomeTypes.Builder()
                .setAchar("y")
                .setAnInt("0")
                .setADouble("0.0")
                .setAChar("x")
                .build()
            , new SomeTypes.Builder()
                .setAchar("")
                .setAnInt("111")
                .setADouble("222.2")
                .setAChar("q")
                .build()
            );
        feature_Data_Types_glue_object.Then_this_should_be_equal(objectList2);
        }
    }


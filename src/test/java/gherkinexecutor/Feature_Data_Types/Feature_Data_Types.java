package gherkinexecutor.Feature_Data_Types;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Feature_Data_Types{
void log(String value) {
    try {
        FileWriter mylog = new FileWriter("src/test/java/gherkinexecutor/Feature_Data_Types/log.txt", true);
        mylog.write(value + "\n");
        mylog.close();
    } catch (IOException e) {
    System.out.println("**** Cannot write to log ");
    }
    }


    @Test
    void test_Scenario_Use_the_data_types(){
         Feature_Data_Types_glue feature_Data_Types_glue_object = new Feature_Data_Types_glue();
        log("Scenario_Use_the_data_types");

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
                
            , new AllTypes.Builder()
                .anInt("")
                .aDouble("")
                .aChar("")
                .achar("")
                .build()
                
            );
        feature_Data_Types_glue_object.Given_type_values_are(objectList1);
        }
    }


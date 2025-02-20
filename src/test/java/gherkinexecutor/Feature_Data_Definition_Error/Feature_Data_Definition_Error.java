package gherkinexecutor.Feature_Data_Definition_Error;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Feature_Data_Definition_Error{
void log(String value) {
    try {
        FileWriter myLog = new FileWriter("src/test/java/gherkinexecutor/Feature_Data_Definition_Error/log.txt", true);
        myLog.write(value + "\n");
        myLog.close();
    } catch (IOException e) {
    System.err.println("*** Cannot write to log ");
    }
    }


    @Test
    void test_Scenario_Simple_Table_with_int_bad(){
         Feature_Data_Definition_Error_glue feature_Data_Definition_Error_glue_object = new Feature_Data_Definition_Error_glue();
        log("Scenario_Simple_Table_with_int_bad");

        List<ATest> objectList1 = List.of(
             new ATest.Builder()
                .anInt("q")
                .aString("something")
                .aDouble("1.1")
                .build()
                
            );
        feature_Data_Definition_Error_glue_object.Given_table_is(objectList1);
        }
    @Test
    void test_Scenario_Simple_Table_with_double_bad(){
         Feature_Data_Definition_Error_glue feature_Data_Definition_Error_glue_object = new Feature_Data_Definition_Error_glue();
        log("Scenario_Simple_Table_with_double_bad");

        List<ATest> objectList1 = List.of(
             new ATest.Builder()
                .anInt("1")
                .aString("something")
                .aDouble("r")
                .build()
                
            );
        feature_Data_Definition_Error_glue_object.Given_table_is(objectList1);
        }
    @Test
    void test_Scenario_Simple_Table_with_initializer_bad(){
         Feature_Data_Definition_Error_glue feature_Data_Definition_Error_glue_object = new Feature_Data_Definition_Error_glue();
        log("Scenario_Simple_Table_with_initializer_bad");

        List<ATestBad> objectList1 = List.of(
             new ATestBad.Builder()
                .anInt("1")
                .build()
                
            );
        feature_Data_Definition_Error_glue_object.Given_table_is_bad_initializer(objectList1);
        }
    }


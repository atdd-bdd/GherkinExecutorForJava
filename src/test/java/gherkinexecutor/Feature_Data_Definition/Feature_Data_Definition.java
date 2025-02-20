package gherkinexecutor.Feature_Data_Definition;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Feature_Data_Definition{
void log(String value) {
    try {
        FileWriter myLog = new FileWriter("src/test/java/gherkinexecutor/Feature_Data_Definition/log.txt", true);
        myLog.write(value + "\n");
        myLog.close();
    } catch (IOException e) {
    System.err.println("*** Cannot write to log ");
    }
    }


    @Test
    void test_Scenario_Simple_Comparison(){
         Feature_Data_Definition_glue feature_Data_Definition_glue_object = new Feature_Data_Definition_glue();
        log("Scenario_Simple_Comparison");

        List<ATest> objectList1 = List.of(
             new ATest.Builder()
                .anInt("1")
                .aString("something")
                .aDouble("1.2")
                .build()
                
            );
        feature_Data_Definition_glue_object.Given_table_is(objectList1);

        List<ATest> objectList2 = List.of(
             new ATest.Builder()
             .setCompare()
                .aString("something")
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
                .aString("something else")
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


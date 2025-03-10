package gherkinexecutor.Feature_Simple_Test;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
class Feature_Simple_Test{
void log(String value) {
    try {
        FileWriter myLog = new FileWriter("src/test/java/gherkinexecutor/Feature_Simple_Test/log.txt", true);
        myLog.write(value + "\n");
        myLog.close();
    } catch (IOException e) {
    System.err.println("*** Cannot write to log ");
    }
    }


    @Test
    void test_Scenario_Simple(){
         Feature_Simple_Test_glue feature_Simple_Test_glue_object = new Feature_Simple_Test_glue();
        log("Scenario_Simple");

        List<ATest> objectList1 = List.of(
             new ATest.Builder()
                .setAnInt("1")
                .setAString("something")
                .setADouble("1.2")
                .build()
            );
        feature_Simple_Test_glue_object.Given_table_is(objectList1);
        }
    }


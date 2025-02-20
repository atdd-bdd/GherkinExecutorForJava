package gherkinexecutor.Feature_Background;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Feature_Background{
void log(String value) {
    try {
        FileWriter myLog = new FileWriter("src/test/java/gherkinexecutor/Feature_Background/log.txt", true);
        myLog.write(value + "\n");
        myLog.close();
    } catch (IOException e) {
    System.err.println("*** Cannot write to log ");
    }
    }


    @Test
    void test_Background(){
         Feature_Background_glue feature_Background_glue_object = new Feature_Background_glue();
        log("Background");

        feature_Background_glue_object.Given_Background_Function();
        }
    @Test
    void test_Cleanup(){
         Feature_Background_glue feature_Background_glue_object = new Feature_Background_glue();
        log("Cleanup");

        feature_Background_glue_object.Given_Cleanup_Function();
        }
    @Test
    void test_Scenario_Should_have_Background_and_Cleanup(){
         Feature_Background_glue feature_Background_glue_object = new Feature_Background_glue();
        log("Scenario_Should_have_Background_and_Cleanup");
        test_Background();

        feature_Background_glue_object.Given_a_regular_function();
        test_Cleanup(); // from previous
        }
    @Test
    void test_Scenario_Should_also_have_Background_and_Cleanup(){
         Feature_Background_glue feature_Background_glue_object = new Feature_Background_glue();
        log("Scenario_Should_also_have_Background_and_Cleanup");
        test_Background();

        feature_Background_glue_object.Given_a_regular_function();
        test_Cleanup(); // at the end 
        }
    }


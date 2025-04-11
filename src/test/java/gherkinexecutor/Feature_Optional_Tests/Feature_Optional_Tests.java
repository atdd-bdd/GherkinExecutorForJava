package gherkinexecutor.Feature_Optional_Tests;
import org.junit.jupiter.api.*;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
@Tag("OnlyThisFeature")
class Feature_Optional_Tests{
void log(String value) {
    try {
        FileWriter myLog = new FileWriter("src/test/java/gherkinexecutor/Feature_Optional_Tests/log.txt", true);
        myLog.write(value + "\n");
        myLog.close();
    } catch (IOException e) {
    System.err.println("*** Cannot write to log ");
    }
    }


    @Test
    void test_Scenario_This_may_be_run(){
         Feature_Optional_Tests_glue feature_Optional_Tests_glue_object = new Feature_Optional_Tests_glue();
        log("Scenario_This_may_be_run");

        feature_Optional_Tests_glue_object.Given_This_may_be_run();
        }
    }


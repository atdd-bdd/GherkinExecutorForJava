package gherkinexecutor.Feature_Import;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Feature_Import{
void log(String value) {
    try {
        FileWriter myLog = new FileWriter("src/test/java/gherkinexecutor/Feature_Import/log.txt", true);
        myLog.write(value + "\n");
        myLog.close();
    } catch (IOException e) {
    System.err.println("*** Cannot write to log ");
    }
    }


    @Test
    void test_Scenario_Use_an_import(){
         Feature_Import_glue feature_Import_glue_object = new Feature_Import_glue();
        log("Scenario_Use_an_import");

        List<Imports> objectList1 = List.of(
             new Imports.Builder()
                .myURL("http://kenpugh.com")
                .myPattern("a.*")
                .myWeekday("MONDAY")
                .build()
                
            , new Imports.Builder()
                .myURL("http://atdd-bdd.com")
                .myPattern("[ab]")
                .myWeekday("SUNDAY")
                .build()
                
            );
        feature_Import_glue_object.Given_this_data(objectList1);
        }
    @Test
    void test_Scenario_Should_fail(){
         Feature_Import_glue feature_Import_glue_object = new Feature_Import_glue();
        log("Scenario_Should_fail");

        List<Imports> objectList1 = List.of(
             new Imports.Builder()
                .myURL("http://kenpugh.com")
                .myPattern("a.*")
                .myWeekday("SOMEONE")
                .build()
                
            , new Imports.Builder()
                .myURL("http://atdd-bdd.com")
                .myPattern("[ab]")
                .myWeekday("SUNDAY")
                .build()
                
            );
        feature_Import_glue_object.Given_this_data(objectList1);
        }
    @Test
    void test_Scenario_Should_also_fail(){
         Feature_Import_glue feature_Import_glue_object = new Feature_Import_glue();
        log("Scenario_Should_also_fail");

        List<Imports> objectList1 = List.of(
             new Imports.Builder()
                .myURL("ht://kenpugh.com")
                .myPattern("a.*")
                .myWeekday("MONDAY")
                .build()
                
            , new Imports.Builder()
                .myURL("http:atdd-bdd.com")
                .myPattern("[ab]")
                .myWeekday("SUNDAY")
                .build()
                
            );
        feature_Import_glue_object.Given_this_data(objectList1);
        }
    }


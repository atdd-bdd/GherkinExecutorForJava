package gherkinexecutor.Feature_Import;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.List;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Feature_Import{


    @Test
    void test_Scenario_Use_an_import(){
         Feature_Import_glue feature_Import_glue_object = new Feature_Import_glue();

        List<Imports> objectList1 = List.of(
             new Imports.Builder()
                .myURL("http://kenpugh.com")
                .myPattern("a.*")
                .myWeekday("MONDAY")
                .myBigInt("1")
                .build()
            , new Imports.Builder()
                .myURL("http://atdd-bdd.com")
                .myPattern("[ab]")
                .myWeekday("SUNDAY")
                .myBigInt("10000000000")
                .build()
            );
        feature_Import_glue_object.Given_this_data(objectList1);
        }
    @Test
    void test_Scenario_Should_fail(){
         Feature_Import_glue feature_Import_glue_object = new Feature_Import_glue();

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
        feature_Import_glue_object.Given_this_data_should_fail(objectList1);
        }
    @Test
    void test_Scenario_Should_also_fail(){
         Feature_Import_glue feature_Import_glue_object = new Feature_Import_glue();

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
        feature_Import_glue_object.Given_this_data_should_fail(objectList1);
        }
    }


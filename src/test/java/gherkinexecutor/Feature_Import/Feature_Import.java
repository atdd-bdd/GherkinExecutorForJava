package gherkinexecutor.Feature_Import;
import org.junit.jupiter.api.*;
import java.util.List;
class Feature_Import{


    @Test
    void test_Scenario_Use_an_import(){
         Feature_Import_glue feature_Import_glue_object = new Feature_Import_glue();

        List<ImportData> objectList1 = List.of(
             new ImportData.Builder()
                .setMyPattern("a.*")
                .setMyWeekday("MONDAY")
                .setMyBigInt("1")
                .build()
            , new ImportData.Builder()
                .setMyPattern("[ab]")
                .setMyWeekday("SUNDAY")
                .setMyBigInt("10000000000")
                .build()
            );
        feature_Import_glue_object.Given_this_data_should_be_okay(objectList1);
        }
    @Test
    void test_Scenario_Should_fail(){
         Feature_Import_glue feature_Import_glue_object = new Feature_Import_glue();

        List<ImportData> objectList1 = List.of(
             new ImportData.Builder()
                .setMyPattern("a.*")
                .setMyWeekday("SOMEONE")
                .setMyBigInt("1")
                .build()
            , new ImportData.Builder()
                .setMyPattern("[ab]")
                .setMyWeekday("SUNDAY")
                .setMyBigInt("2")
                .build()
            );
        feature_Import_glue_object.Given_this_data_should_fail(objectList1);
        }
    @Test
    void test_Scenario_Should_also_fail(){
         Feature_Import_glue feature_Import_glue_object = new Feature_Import_glue();

        List<ImportData> objectList1 = List.of(
             new ImportData.Builder()
                .setMyPattern("a.*")
                .setMyWeekday("MONDAY")
                .setMyBigInt("1")
                .build()
            , new ImportData.Builder()
                .setMyPattern("[ab]")
                .setMyWeekday("SUNDAY")
                .setMyBigInt("A.2")
                .build()
            );
        feature_Import_glue_object.Given_this_data_should_fail(objectList1);
        }
    }


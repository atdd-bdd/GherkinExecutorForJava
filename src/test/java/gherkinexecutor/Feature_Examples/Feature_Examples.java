package gherkinexecutor.Feature_Examples;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Feature_Examples{
void log(String value) {
    try {
        FileWriter mylog = new FileWriter("src/test/java/gherkinexecutor/Feature_Examples/log.txt", true);
        mylog.write(value + "\n");
        mylog.close();
    } catch (IOException e) {
    System.out.println("**** Cannot write to log ");
    }
    }


    @Test
    void test_Scenario_Temperature(){
         Feature_Examples_glue feature_Examples_glue_object = new Feature_Examples_glue();
        log("Scenario_Temperature");
        }
    @Test
    void test_Scenario_Domain_Term_ID(){
         Feature_Examples_glue feature_Examples_glue_object = new Feature_Examples_glue();
        log("Scenario_Domain_Term_ID");
        }
    @Test
    void test_Scenario_Filter_Data(){
         Feature_Examples_glue feature_Examples_glue_object = new Feature_Examples_glue();
        log("Scenario_Filter_Data");

        List<LabelValue> objectList1 = List.of(
             new LabelValue.Builder()
                .label("a")
                .value("1")
                .build()
                
            , new LabelValue.Builder()
                .label("b")
                .value("2")
                .build()
                
            , new LabelValue.Builder()
                .label("a")
                .value("3")
                .build()
                
            );
        feature_Examples_glue_object.Given_list_of_numbers(objectList1);

        List<List<String>> stringListList2 = List.of(
           List.of(
            "a"
            )
            );
        feature_Examples_glue_object.When_filtered_by_Label_with_value(stringListList2);

        List<List<String>> stringListList3 = List.of(
           List.of(
            "4"
            )
            );
        feature_Examples_glue_object.Then_sum_is(stringListList3);
        }
    }


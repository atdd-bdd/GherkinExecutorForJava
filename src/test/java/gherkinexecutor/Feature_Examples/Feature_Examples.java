package gherkinexecutor.Feature_Examples;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
class Feature_Examples{
void log(String value) {
    try {
        FileWriter myLog = new FileWriter("src/test/java/gherkinexecutor/Feature_Examples/log.txt", true);
        myLog.write(value + "\n");
        myLog.close();
    } catch (IOException e) {
    System.err.println("*** Cannot write to log ");
    }
    }


    @Test
    void test_Scenario_Temperature_Conversion(){
         Feature_Examples_glue feature_Examples_glue_object = new Feature_Examples_glue();
        log("Scenario_Temperature_Conversion");

        List<FandC> objectList1 = List.of(
             new FandC.Builder()
                .setF("32")
                .setC("0")
                .setNotes("Freezing")
                .build()
            , new FandC.Builder()
                .setF("212")
                .setC("100")
                .setNotes("Boiling")
                .build()
            , new FandC.Builder()
                .setF("-40")
                .setC("-40")
                .setNotes("Below zero")
                .build()
            );
        feature_Examples_glue_object.Calculation_Convert_F_to_C(objectList1);
        }
    @Test
    void test_Scenario_Domain_Term_ID(){
         Feature_Examples_glue feature_Examples_glue_object = new Feature_Examples_glue();
        log("Scenario_Domain_Term_ID");

        List<ValueValid> objectList1 = List.of(
             new ValueValid.Builder()
                .setValue("Q1234")
                .setValid("true")
                .setNotes("")
                .build()
            , new ValueValid.Builder()
                .setValue("Q123")
                .setValid("false")
                .setNotes("Too short")
                .build()
            , new ValueValid.Builder()
                .setValue("Q12345")
                .setValid("false")
                .setNotes("Too long")
                .build()
            , new ValueValid.Builder()
                .setValue("A1234")
                .setValid("false")
                .setNotes("Must begin with Q")
                .build()
            );
        feature_Examples_glue_object.Rule_ID_must_have_exactly_5_letters_and_begin_with_Q(objectList1);
        }
    @Test
    void test_Scenario_Filter_Data(){
         Feature_Examples_glue feature_Examples_glue_object = new Feature_Examples_glue();
        log("Scenario_Filter_Data");

        List<LabelValue> objectList1 = List.of(
             new LabelValue.Builder()
                .setID("Q1234")
                .setValue("1")
                .build()
            , new LabelValue.Builder()
                .setID("Q9999")
                .setValue("2")
                .build()
            , new LabelValue.Builder()
                .setID("Q1234")
                .setValue("3")
                .build()
            );
        feature_Examples_glue_object.Given_list_of_numbers(objectList1);

        List<List<String>> stringListList2 = List.of(
           List.of(
            "Q1234"
            )
            );
        feature_Examples_glue_object.When_filtered_by_ID_with_value(stringListList2);

        List<List<String>> stringListList3 = List.of(
           List.of(
            "4"
            )
            );
        feature_Examples_glue_object.Then_sum_is(stringListList3);
        }
    @Test
    void test_Scenario_Filter_Data_Another_Way(){
         Feature_Examples_glue feature_Examples_glue_object = new Feature_Examples_glue();
        log("Scenario_Filter_Data_Another_Way");

        List<LabelValue> objectList1 = List.of(
             new LabelValue.Builder()
                .setID("Q1234")
                .setValue("1")
                .build()
            , new LabelValue.Builder()
                .setID("Q9999")
                .setValue("2")
                .build()
            , new LabelValue.Builder()
                .setID("Q1234")
                .setValue("3")
                .build()
            );
        feature_Examples_glue_object.Given_list_of_numbers(objectList1);

        List<FilterValue> objectList2 = List.of(
             new FilterValue.Builder()
                .setName("ID")
                .setValue("Q1234")
                .build()
            );
        feature_Examples_glue_object.When_filtered_by(objectList2);

        List<ResultValue> objectList3 = List.of(
             new ResultValue.Builder()
                .setSum("4")
                .build()
            );
        feature_Examples_glue_object.Then_result(objectList3);
        }
    }


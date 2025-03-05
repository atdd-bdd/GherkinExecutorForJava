package gherkinexecutor.Feature_Examples;
import org.junit.jupiter.api.Test;
import java.util.List;
class Feature_Examples{


    @Test
    void test_Scenario_Temperature(){
         Feature_Examples_glue feature_Examples_glue_object = new Feature_Examples_glue();

        List<TemperatureCalculation> objectList1 = List.of(
             new TemperatureCalculation.Builder()
                .f("32")
                .c("0")
                .notes("Freezing")
                .build()
            , new TemperatureCalculation.Builder()
                .f("212")
                .c("100")
                .notes("Boiling")
                .build()
            , new TemperatureCalculation.Builder()
                .f("-40")
                .c("-40")
                .notes("Below zero")
                .build()
            );
        feature_Examples_glue_object.Calculation_Convert_F_to_C(objectList1);
        }
    @Test
    void test_Scenario_Domain_Term_ID(){
         Feature_Examples_glue feature_Examples_glue_object = new Feature_Examples_glue();

        List<ValueValid> objectList1 = List.of(
             new ValueValid.Builder()
                .value("Q1234")
                .valid("true")
                .notes("")
                .build()
            , new ValueValid.Builder()
                .value("Q123")
                .valid("false")
                .notes("Too short")
                .build()
            , new ValueValid.Builder()
                .value("Q12345")
                .valid("false")
                .notes("Too long")
                .build()
            , new ValueValid.Builder()
                .value("A1234")
                .valid("false")
                .notes("Must begin with Q")
                .build()
            );
        feature_Examples_glue_object.Rule_ID_must_have_exactly_5_letters_and_begin_with_Q(objectList1);
        }
    @Test
    void test_Scenario_Filter_Data(){
         Feature_Examples_glue feature_Examples_glue_object = new Feature_Examples_glue();

        List<LabelValue> objectList1 = List.of(
             new LabelValue.Builder()
                .iD("Q1234")
                .value("1")
                .build()
            , new LabelValue.Builder()
                .iD("Q9999")
                .value("2")
                .build()
            , new LabelValue.Builder()
                .iD("Q1234")
                .value("3")
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

        List<LabelValue> objectList1 = List.of(
             new LabelValue.Builder()
                .iD("Q1234")
                .value("1")
                .build()
            , new LabelValue.Builder()
                .iD("Q9999")
                .value("2")
                .build()
            , new LabelValue.Builder()
                .iD("Q1234")
                .value("3")
                .build()
            );
        feature_Examples_glue_object.Given_list_of_numbers(objectList1);

        List<FilterValue> objectList2 = List.of(
             new FilterValue.Builder()
                .name("ID")
                .value("Q1234")
                .build()
            );
        feature_Examples_glue_object.When_filtered_by(objectList2);

        List<ResultValue> objectList3 = List.of(
             new ResultValue.Builder()
                .sum("4")
                .build()
            );
        feature_Examples_glue_object.Then_result(objectList3);
        }
    }


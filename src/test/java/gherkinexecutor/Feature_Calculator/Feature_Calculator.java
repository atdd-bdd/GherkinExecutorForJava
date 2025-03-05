package gherkinexecutor.Feature_Calculator;
import org.junit.jupiter.api.Test;
import java.util.List;
class Feature_Calculator{


    @Test
    void test_Scenario_Add_two_numbers(){
         Feature_Calculator_glue feature_Calculator_glue_object = new Feature_Calculator_glue();

        List<Calculation> objectList1 = List.of(
             new Calculation.Builder()
                .number1("2")
                .number2("3")
                .result("5")
                .build()
            , new Calculation.Builder()
                .number1("10")
                .number2("20")
                .result("30")
                .build()
            , new Calculation.Builder()
                .number1("-1")
                .number2("1")
                .result("0")
                .build()
            );
        feature_Calculator_glue_object.When_I_add_two_numbers_I_get_the_result(objectList1);
        }
    }


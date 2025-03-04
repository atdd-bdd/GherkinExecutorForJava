package gherkinexecutor.Feature_Calculator;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class Calculator {
    int add(int number1, int number2){
        return number1 + number2;
    }
}

class Feature_Calculator_glue {
    final String DNCString = "?DNC?";


    void When_I_add_two_numbers_I_get_the_result(List<Calculation> values ) {
        System.out.println("---  " + "When_I_add_two_numbers_I_get_the_result");
        for (Calculation value : values){
            System.out.println(value);
            CalculationInternal i = value.toCalculationInternal();
            int result = new Calculator().add(i.number1, i.number2);
            assertEquals(i.result, result);
        }
    }

}

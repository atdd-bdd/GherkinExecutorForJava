package gherkinexecutor.Feature_Examples;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

class Feature_Examples_glue {

    void Calculation_Convert_F_to_C(List<TemperatureCalculation> value ) {
        System.out.println("---  " + "Calculation_Convert_F_to_C");
        System.out.println("*******");
        log("---  " + "Calculation_Convert_F_to_C");
        log("*******");
        log(value.toString());
        System.out.println(value);
        for (TemperatureCalculation v : value){
            System.out.println(v);
            TemperatureCalculationInternal i = v.toTemperatureCalculationInternal();
            System.out.println(i);
            int result = TemperatureCalculations.convertFarenheitToCelsius(i.f);
            assertEquals(i.c, result, i.notes);
        };
    }
    void Rule_ID_must_have_exactly_5_letters_and_begin_with_Q(List<DomainTermID> value ) {
        System.out.println("---  " + "Rule_ID_must_have_exactly_5_letters_and_begin_with_Q");
        System.out.println("*******");
        log("---  " + "Rule_ID_must_have_exactly_5_letters_and_begin_with_Q");
        log("*******");
        log(value.toString());
        System.out.println(value);
        for (DomainTermID v : value){
            System.out.println(v);
            DomainTermIDInternal i = v.toDomainTermIDInternal();
               try {
            new ID(i.value);
            if (!i.valid)
                fail("Value of " + i.value + "accepted but should fail");
        } catch (IllegalArgumentException e) {
            if (i.valid)
                fail("Value of " + i.value + "failed but should be accepted");
            assertEquals(i.notes, e.getMessage(), "Message does not match");
         }
//            assertEquals(
//                temp.valid,
//                ID(temp.value).isValid(),
//                temp.notes
//            )
    }
}
    SolutionForListOfNumber solution = new SolutionForListOfNumber();
    void log(String value) {
        try {
            FileWriter mylog = new FileWriter("src/test/java/gherkinexecutor/Feature_Examples/log.txt", true);
            mylog.write(value + "\n");
            mylog.close();
        } catch (IOException e) {
            System.out.println("**** Cannot write to log ");
        }
    }


    void Given_list_of_numbers(List<LabelValue> value ) {
        System.out.println("---  " + "Given_list_of_numbers");
        System.out.println("*******");
        log("---  " + "Given_list_of_numbers");
        log("*******");
        log(value.toString());
        System.out.println(value);
        for (LabelValue v : value){
            System.out.println(v);
            LabelValueInternal i = v.toLabelValueInternal();
            solution.add(i);
            System.out.println(i);
        };
    }

    void When_filtered_by_Label_with_value(List<List<String>> value ) {
        System.out.println("---  " + "When_filtered_by_Label_with_value");
        System.out.println("*******");
        log("---  " + "When_filtered_by_Label_with_value");
        log("*******");
        log(value.toString());
        System.out.println(value);
        String filterValue = value.get(0).get(0);
        solution.setFilterValue(filterValue);
       }

    void Then_sum_is(List<List<String>> value ) {
        System.out.println("---  " + "Then_sum_is");
        System.out.println("*******");
        log("---  " + "Then_sum_is");
        log("*******");
        log(value.toString());
        System.out.println(value);
        int expected = Integer.parseInt(value.get(0).get(0));
        assertEquals(expected, solution.sum());
        };
    }



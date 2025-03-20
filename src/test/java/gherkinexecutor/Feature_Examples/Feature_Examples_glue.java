package gherkinexecutor.Feature_Examples;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;


class Feature_Examples_glue {
    final SolutionForListOfNumber solution = new SolutionForListOfNumber();

    void log(String value) {
        try {
            FileWriter myLog = new FileWriter("src/test/java/gherkinexecutor/Feature_Examples/log.txt", true);
            myLog.write(value + "\n");
            myLog.close();
        } catch (IOException e) {
            System.out.println("**** Cannot write to log ");
        }
    }

    void Calculation_Convert_F_to_C(List<FandC> values) {
        System.out.println("---  " + "Calculation_Convert_F_to_C");
        log("---  " + "Calculation_Convert_F_to_C");
        log(values.toString());
        for (FandC value : values) {
            System.out.println(value);
            // Add calls to production code and asserts
            FandCInternal i = value.toFandCInternal();
            int c = TemperatureCalculations.convertFahrenheitToCelsius(i.f);
            assertEquals(i.c, c, i.notes);
        }
    }

    void Rule_ID_must_have_exactly_5_letters_and_begin_with_Q(List<ValueValid> values) {
        System.out.println("---  " + "Rule_ID_must_have_exactly_5_letters_and_begin_with_Q");
        log("---  " + "Rule_ID_must_have_exactly_5_letters_and_begin_with_Q");
        log(values.toString());
        for (ValueValid value : values) {
            System.out.println(value);
            boolean result = false;
            boolean expectedException = !Boolean.valueOf(value.valid);
            try {
                new ID(value.value);
                if (expectedException) {
                    fail("Invalid value did not throw exeception "
                            + value.value + " " + value.notes);
                }
            } catch (Exception e) {
                if (!expectedException)
                    fail("Valid value threw exeception "
                            + value.value + " " + value.notes);
            }
        }
    }

    void Given_list_of_numbers(List<LabelValue> values) {
        System.out.println("---  " + "Given_list_of_numbers");
        log("---  " + "Given_list_of_numbers");
        log(values.toString());
        for (LabelValue value : values) {
            System.out.println(value);
            try {
                LabelValueInternal i = value.toLabelValueInternal();
                System.out.println(i);
                solution.add(i);
            } catch (Exception e) {
                System.err.println("Argument Error " + value.toString() + LabelValueInternal.toDataTypeString());
            }
        }
    }

    void When_filtered_by_ID_with_value(List<List<String>> values) {
        System.out.println("---  " + "When_filtered_by_ID_with_value");
        log("---  " + "When_filtered_by_ID_with_value");
        log(values.toString());
        String id = values.get(0).get(0);
        System.out.println("ID is " + id);
        solution.setFilterValue(new ID(id));
    }

    void Then_sum_is(List<List<String>> values) {
        System.out.println("---  " + "Then_sum_is");
        log("---  " + "Then_sum_is");
        log(values.toString());
        int expected = Integer.parseInt(values.get(0).get(0));
        System.out.println("    expecting " + expected);
        int result = solution.sum();
        assertEquals(expected, result);
    }

    void When_filtered_by(List<FilterValue> values) {
        System.out.println("---  " + "When_filtered_by");
        FilterValue value = values.get(0);
        System.out.println(value);
        try {
            FilterValueInternal i = value.toFilterValueInternal();
            System.out.println("Filter is " + i.value);
            solution.setFilterValue(i.value);
        } catch (Exception e) {
            System.err.println("Argument Error " + value.toString() + FilterValueInternal.toDataTypeString());
        }
    }

    void Then_result(List<ResultValue> values) {
        System.out.println("---  " + "Then_result");
        ResultValue value = values.get(0);
        System.out.println(value);
        try {
            ResultValueInternal i = value.toResultValueInternal();
            int actual = solution.sum();
            assertEquals(i.sum, actual);

        } catch (Exception e) {
            System.err.println("Argument Error " + value.toString() + ResultValueInternal.toDataTypeString());
        }
    }


}

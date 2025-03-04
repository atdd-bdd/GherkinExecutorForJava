package gherkinexecutor.Feature_Data_Definition;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class Feature_Data_Definition_glue {
    final String DNCString = "?DNC?";

    List<ATest> original;
    List<ATest> comparison;


    void Given_table_is(List<ATest> values ) {
        System.out.println("---  " + "Given_table_is");
        original = values;
    }

    void When_compared_to(List<ATest> values ) {
        comparison = values;
    }

    void Then_result_is(List<List<String>> values ) {
        boolean b = Boolean.valueOf(values.get(0).get(0));
        boolean result = original.equals(comparison);
        assertEquals(b, result);
        result = comparison.equals(original);
        assertEquals(b, result);
    }

}

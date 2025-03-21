package gherkinexecutor.Feature_Data_Types;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class Feature_Data_Types_glue {
    final String DNCString = "?DNC?";

    List<AllTypesInternal> original = new ArrayList<>();
    List<AllTypesInternal> expected = new ArrayList<>();
    void Given_type_values_are(List<AllTypes> values ) {
        System.out.println("---  " + "Given_type_values_are");
        for (AllTypes value : values){
            System.out.println(value);

            AllTypesInternal i = value.toAllTypesInternal();
            original.add(i);
        }

    }

    void Then_this_should_be_equal(List<AllTypes> values ) {
        System.out.println("---  " + "Then_this_should_be_equal");
        for (AllTypes value : values){
            System.out.println(value);

            AllTypesInternal i = value.toAllTypesInternal();
            expected.add(i);
        }
        assertEquals(expected, original);
    }

}

package gherkinexecutor.Feature_Define;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class Feature_Define_glue {

    List<IDValue> original;

    void Given_this_data(List<IDValue> values ) {
        System.out.println("---  " + "Given_this_data");
        for (IDValue value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
        original = values;

    }

    void Then_should_be_equal_to_data(List<IDValue> values ) {
        System.out.println("---  " + "Then_should_be_equal_to_data");
        for (IDValue value : values){
            System.out.println(value);
            // Add calls to production code and asserts
        }
        assertEquals(values, original);
    }

}

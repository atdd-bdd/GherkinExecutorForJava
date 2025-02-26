package gherkinexecutor.Feature_Simple_Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class Feature_Simple_Test_glue {
    final String DNCString = "?DNC?";


    void Given_table_is(List<ATest> values ) {
        System.out.println("---  " + "Given_table_is");
        for (ATest value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            try {
                ATestInternal i = value.toATestInternal();
                System.out.println(i);
            }
            catch(IllegalArgumentException e){
                System.err.println("Argument Error " + value + ATestInternal.toDataTypeString());
            }
        }
    }

}

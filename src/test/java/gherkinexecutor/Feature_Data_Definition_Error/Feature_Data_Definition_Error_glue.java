package gherkinexecutor.Feature_Data_Definition_Error;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class Feature_Data_Definition_Error_glue {
    final String DNCString = "?DNC?";


    void Given_table_is(List<ATest> values ) {
        System.out.println("---  " + "Given_table_is");
        for (ATest value : values){
            System.out.println(value);
            try {
                // Add calls to production code and asserts
                ATestInternal i = value.toATestInternal();
                fail("Should fail on a conversion");
            }
            catch(IllegalArgumentException e){
                System.out.println("Exception " + e.toString());
            }
        }

    }

    void Given_table_is_bad_initializer(List<ATestBad> values ) {
        System.out.println("---  " + "Given_table_is_bad_initializer");
        for (ATestBad value : values){
            System.out.println(value);
            try {
                // Add calls to production code and asserts
                ATestBadInternal i = value.toATestBadInternal();
                fail("Should fail on a conversion");
            }
            catch(IllegalArgumentException e){
                System.out.println("Exception " + e.toString());
                System.out.println("Test passes - conversion error caught");
            }
        }

    }

}

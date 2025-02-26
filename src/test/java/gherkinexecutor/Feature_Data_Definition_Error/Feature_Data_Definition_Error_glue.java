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
            // Add calls to production code and asserts
            try {
                ATestInternal i = value.toATestInternal();
                System.out.println(i);
            }
            catch(IllegalArgumentException e){
                System.err.println("Argument Error " + value.toString() + ATestInternal.toDataTypeString());
            }
        }
    }

    void Given_table_is_bad_initializer(List<ATestBad> values ) {
        System.out.println("---  " + "Given_table_is_bad_initializer");
        for (ATestBad value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            try {
                ATestBadInternal i = value.toATestBadInternal();
                System.out.println(i);
            }
            catch(IllegalArgumentException e){
                System.err.println("Argument Error " + value.toString() + ATestBadInternal.toDataTypeString());
            }
        }
    }

}

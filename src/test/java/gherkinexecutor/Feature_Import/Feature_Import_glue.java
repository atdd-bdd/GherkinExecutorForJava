package gherkinexecutor.Feature_Import;
import java.util.*;
import java.util.regex.Pattern;
import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class Feature_Import_glue {
    final String DNCString = "?DNC?";


    void Given_this_data_should_be_okay(List<Imports> values ) {
        System.out.println("---  " + "Given_this_data_should_be_okay");
        for (Imports value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            try {
                ImportsInternal i = value.toImportsInternal();
                System.out.println(i);
            }
            catch(IllegalArgumentException e){
                System.err.println("Argument Error " + value + ImportsInternal.toDataTypeString());
            }
        }
    }

    void Given_this_data_should_fail(List<Imports> values ) {
        System.out.println("---  " + "Given_this_data_should_fail");
        for (Imports value : values){
            System.out.println(value);
            // Add calls to production code and asserts
            try {
                ImportsInternal i = value.toImportsInternal();
                System.out.println(i);
            }
            catch(IllegalArgumentException e){
                System.err.println("Argument Error " + value + ImportsInternal.toDataTypeString());
            }
        }
    }

}

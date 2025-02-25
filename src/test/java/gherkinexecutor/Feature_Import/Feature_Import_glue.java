package gherkinexecutor.Feature_Import;
import java.util.*;
import java.util.regex.Pattern;
import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class Feature_Import_glue {
    final String DNCString = "?DNC?";


    void Given_this_data(List<Imports> values ) {
        System.out.println("---  " + "Given_this_data");
        boolean valid = true;
        for (Imports value : values){
            System.out.println(value);
            try {
                ImportsInternal i = value.toImportsInternal();
                System.out.println(i);
            }
            catch(IllegalArgumentException e){
                valid = false;
                System.err.println("Argument Error " + value.toString() + ImportsInternal.toDataTypeString());
            }
        }
        assertTrue(valid, "Values should be valid");
    }

    void Given_this_data_should_fail(List<Imports> values ) {
        System.out.println("---  " + "Given_this_data_should_fail");
        boolean valid = true;
        for (Imports value : values){
            System.out.println(value);
            try {
                ImportsInternal i = value.toImportsInternal();
                System.out.println(i);
            }
            catch(IllegalArgumentException e){
                valid = false;
                System.err.println("Argument Error " + value.toString() + ImportsInternal.toDataTypeString());
            }
        }
        assertFalse(valid, "One argument should have been invalid");
    }

}

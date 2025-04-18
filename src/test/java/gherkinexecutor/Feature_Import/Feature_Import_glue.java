package gherkinexecutor.Feature_Import;
import java.util.*;
import java.util.regex.Pattern;
import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class Feature_Import_glue {
    final String DNCString = "?DNC?";


    void Given_this_data_should_be_okay(List<ImportData> values ) {
        System.out.println("---  " + "Given_this_data_should_be_okay");
        for (ImportData value : values){
            System.out.println(value);
            try {
                ImportDataInternal i = value.toImportDataInternal();
                System.out.println(i);
            }
            catch(IllegalArgumentException e){
                System.err.println("Argument Error " + value + ImportDataInternal.toDataTypeString());
                fail("Argument Error " + value + ImportDataInternal.toDataTypeString());
            }
        }
    }

    void Given_this_data_should_fail(List<ImportData> values ) {
        System.out.println("---  " + "Given_this_data_should_fail");
        for (ImportData value : values){
            System.out.println(value);
            try {
                ImportDataInternal i = value.toImportDataInternal();
                System.out.println(i);
            }
            catch(IllegalArgumentException e){
                System.err.println("Argument Error " + value + ImportDataInternal.toDataTypeString());
                fail("Argument Error " + value + ImportDataInternal.toDataTypeString());
            }
        }
    }

}

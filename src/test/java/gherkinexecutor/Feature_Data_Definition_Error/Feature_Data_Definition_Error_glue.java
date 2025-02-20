package gherkinexecutor.Feature_Data_Definition_Error;
import java.util.*;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

class Feature_Data_Definition_Error_glue {
    void log(String value) {
        try {
            FileWriter myLog = new FileWriter("src/test/java/gherkinexecutor/Feature_Data_Definition_Error/log.txt", true);
            myLog.write(value + "\n");
            myLog.close();
        } catch (IOException e) {
            System.out.println("**** Cannot write to log ");
        }
    }


    void Given_table_is(List<ATest> values ) {
        System.out.println("---  " + "Given_table_is");
        System.out.println("*******");
        log("---  " + "Given_table_is");
        log("*******");
        log(values.toString());
        for (ATest value : values){
            System.out.println(value);
            try {
                ATestInternal i = value.toATestInternal();
                System.out.println(i);
            }
            catch(Exception e){
                System.err.println("Argument Error " + value.toString() + ATestInternal.toDataTypeString());
            }
        }
    }

    void Given_table_is_bad_initializer(List<ATestBad> values ) {
        System.out.println("---  " + "Given_table_is_bad_initializer");
        System.out.println("*******");
        log("---  " + "Given_table_is_bad_initializer");
        log("*******");
        log(values.toString());
        for (ATestBad value : values){
            System.out.println(value);
            try {
                ATestBadInternal i = value.toATestBadInternal();
                System.out.println(i);
            }
            catch(Exception e){
                System.err.println("Argument Error " + value.toString() + ATestBadInternal.toDataTypeString());
            }
        }
    }

}

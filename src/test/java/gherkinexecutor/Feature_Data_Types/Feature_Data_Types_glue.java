package gherkinexecutor.Feature_Data_Types;
import java.util.*;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

class Feature_Data_Types_glue {
    void log(String value) {
        try {
            FileWriter myLog = new FileWriter("src/test/java/gherkinexecutor/Feature_Data_Types/log.txt", true);
            myLog.write(value + "\n");
            myLog.close();
        } catch (IOException e) {
            System.out.println("**** Cannot write to log ");
        }
    }


    void Given_type_values_are(List<AllTypes> values ) {
        System.out.println("---  " + "Given_type_values_are");
        System.out.println("*******");
        log("---  " + "Given_type_values_are");
        log("*******");
        log(values.toString());
        for (AllTypes value : values){
            System.out.println(value);
            try {
                AllTypesInternal i = value.toAllTypesInternal();
                System.out.println(i);
            }
            catch(Exception e){
                System.err.println("Argument Error " + value.toString() + AllTypesInternal.toDataTypeString());
            }
        }
    }

}

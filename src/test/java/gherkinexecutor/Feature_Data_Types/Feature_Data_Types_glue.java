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
            System.err.println("*** Cannot write to log ");
        }
    }


    void Given_type_values_are(List<AllTypes> values ) {
        System.out.println("---  " + "Given_type_values_are");
        log("---  " + "Given_type_values_are");
        log(values.toString());
        for (AllTypes value : values){
            System.out.println(value);
        }
    }

}

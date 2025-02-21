package gherkinexecutor.Feature_Import;
import java.util.*;
import java.net.URL;
import java.util.regex.Pattern;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

class Feature_Import_glue {
    void log(String value) {
        try {
            FileWriter myLog = new FileWriter("src/test/java/gherkinexecutor/Feature_Import/log.txt", true);
            myLog.write(value + "\n");
            myLog.close();
        } catch (IOException e) {
            System.err.println("*** Cannot write to log ");
        }
    }


    void Given_this_data(List<Imports> values ) {
        System.out.println("---  " + "Given_this_data");
        log("---  " + "Given_this_data");
        log(values.toString());
        for (Imports value : values){
            System.out.println(value);
            try {
                ImportsInternal i = value.toImportsInternal();
                System.out.println(i);
            }
            catch(Exception e){
                System.err.println("Argument Error " + value.toString() + ImportsInternal.toDataTypeString());
            }
        }
    }

}

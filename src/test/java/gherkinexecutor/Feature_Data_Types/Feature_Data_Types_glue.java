package gherkinexecutor.Feature_Data_Types;
import static org.junit.Assert.fail;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

class Feature_Data_Types_glue {
    void log(String value) {
        try {
            FileWriter mylog = new FileWriter("src/test/java/gherkinexecutor/Feature_Data_Typeslog.txt", true);

            mylog.write(value + "\n");
            mylog.close();
        } catch (IOException e) {
            System.out.println("**** Cannot write to log ");
        }
    }


    void Given_type_values_are(List<AllTypes> value ) {
        System.out.println("---  " + "Given_type_values_are");
        System.out.println("*******");
        log("---  " + "Given_type_values_are");
        log("*******");
        System.out.println(value);
    }

}

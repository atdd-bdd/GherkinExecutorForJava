package gherkinexecutor.Feature_Parse_CSV;
import static org.junit.Assert.fail;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

class Feature_Parse_CSV_glue {
    void log(String value) {
        try {
            FileWriter mylog = new FileWriter("src/test/java/gherkinexecutor/Feature_Parse_CSV/log.txt", true);
            mylog.write(value + "\n");
            mylog.close();
        } catch (IOException e) {
            System.out.println("**** Cannot write to log ");
        }
    }


    void Given(String value ) {
        System.out.println("---  " + "Given");
        System.out.println("*******");
        log("---  " + "Given");
        log("*******");
        System.out.println(value);
    }

    void When_converted_result_is(String value ) {
        System.out.println("---  " + "When_converted_result_is");
        System.out.println("*******");
        log("---  " + "When_converted_result_is");
        log("*******");
        System.out.println(value);
    }

    void Given_input_table(List<List<String>> value ) {
        System.out.println("---  " + "Given_input_table");
        System.out.println("*******");
        log("---  " + "Given_input_table");
        log("*******");
        System.out.println(value);
    }

    void When_transposed_result_is(List<List<String>> value ) {
        System.out.println("---  " + "When_transposed_result_is");
        System.out.println("*******");
        log("---  " + "When_transposed_result_is");
        log("*******");
        System.out.println(value);
    }

}

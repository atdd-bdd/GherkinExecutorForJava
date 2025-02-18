package gherkinexecutor.Feature_Include;
import static org.junit.Assert.fail;
import java.util.List;

class Feature_Include_glue {

    void Given_a_string(String value ) {
        System.out.println("---  " + "Given_a_string");
        System.out.println("*******");
        System.out.println(value);
    }

    void Then_a_table(List<List<String>> value ) {
        System.out.println("---  " + "Then_a_table");
        System.out.println("*******");
        System.out.println(value);
    }

    }

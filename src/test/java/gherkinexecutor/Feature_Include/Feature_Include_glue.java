package gherkinexecutor.Feature_Include;
import java.util.*;
import java.net.URL;
import java.util.regex.Pattern;
import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class Feature_Include_glue {


    void Given_a_string_include(String value ) {
        System.out.println("---  " + "Given_a_string_include");
        System.out.println(value);
        fail("Must implement");
    }

    void Given_a_table(List<List<String>> values ) {
        System.out.println("---  " + "Given_a_table");
        for (List<String> value : values){
            System.out.println(value);
        }
        fail("Must implement");
    }

}

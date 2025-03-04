package gherkinexecutor.testfeaturepackage.Feature_Test_Feature;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class Feature_Test_Feature_glue {
    final String DNCString = "?DNC?";
    String original;

    void Given_local_include(String value ) {
        System.out.println("---  " + "Given_local_include");
        System.out.println(value);
        original = value;
    }

    void Then_string_equals(String value ) {
        System.out.println("---  " + "Then_string_equals");
        System.out.println(value);
        assertEquals(value, original);
    }

    void Given_global_include(String value ) {
        System.out.println("---  " + "Given_global_include");
        System.out.println(value);
        original = value;
    }

}

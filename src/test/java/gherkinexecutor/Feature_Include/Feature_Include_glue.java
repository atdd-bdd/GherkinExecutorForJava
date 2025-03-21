package gherkinexecutor.Feature_Include;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class Feature_Include_glue {
    final String DNCString = "?DNC?";

    String original;
    void Given_a_string_include(String value ) {
        System.out.println("---  " + "Given_a_string_include");
        System.out.println(value);
        original = value;
    }

    void Then_should_be_equal_to(String value ) {
        System.out.println("---  " + "Then_should_be_equal_to");
        System.out.println(value);
        assertEquals(value, original);
    }

    List<CSVContents> originalTable;
    void Given_a_table(List<CSVContents> values ) {
        System.out.println("---  " + "Given_a_table");
        for (CSVContents value : values){
            System.out.println(value);

        }
       originalTable = values;
    }

    void Then_Should_be_equal_to_table(List<CSVContents> values ) {
        System.out.println("---  " + "Then_Should_be_equal_to_table");
        for (CSVContents value : values){
            System.out.println(value);
        }
        assertEquals(values, originalTable);
    }

}

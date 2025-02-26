package gherkinexecutor.Feature_Data_Definition;
import java.util.*;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

class Feature_Data_Definition_glue {
    List<ATest> original;
    List<ATest> comparison;
    void log(String value) {
        try {
            FileWriter myLog = new FileWriter("src/test/java/gherkinexecutor/Feature_Data_Definition/log.txt", true);
            myLog.write(value + "\n");
            myLog.close();
        } catch (IOException e) {
            System.out.println("**** Cannot write to log ");
        }
    }


    void Given_table_is(List<ATest> values ) {
//        ATest one = new ATest("a", "b", "c");
//        ATest two = new ATest ("a", "b", "c");
//        ATest three = new ATest("a", "b", "d");
//        System.out.println("*********");
//        System.out.println( one.equals(two));
//        System.out.println( two.equals(three));
//        System.out.println(three.equals(one));
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
        original = values;
    }

    void When_compared_to(List<ATest> values ) {
        System.out.println("---  " + "When_compared_to");
        System.out.println("*******");
        log("---  " + "When_compared_to");
        log(values.toString());
        for (ATest value : values){
            System.out.println(value);
        }
        comparison = values;
    }

    void Then_result_is(List<List<String>> values ) {
        System.out.println("---  " + "Then_result_is");
        log("---  " + "Then_result_is");
        log(values.toString());
        for (List<String> value : values){
            System.out.println(value);
        }
        boolean b = Boolean.valueOf(values.get(0).get(0));
        boolean result = original.equals(comparison);
        assertEquals(b, result);
        result = comparison.equals(original);
        assertEquals(b, result);

    }

}

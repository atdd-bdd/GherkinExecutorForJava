package gherkinexecutor.Feature_Background;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class Feature_Background_glue {

    String backgroundValue;
    String cleanupValue;

    void Given_Background_function_sets_a_value(List<List<String>> values ) {
        System.out.println("---  " + "Given_Background_function_sets_a_value");
         backgroundValue = values.get(0).get(0);
        System.out.println(backgroundValue);


    }

    void And_set_a_value_for_cleanup(List<List<String>> values ) {
        System.out.println("---  " + "And_set_a_value_for_cleanup");
        cleanupValue = values.get(0).get(0);
        System.out.println(cleanupValue);
        }


        void Given_a_regular_function(){
        System.out.println("---  " + "Given_a_regular_function");
    }

    void Then_background_should_set_value_to(List<List<String>> values ) {
        System.out.println("---  " + "Then_background_should_set_value_to");
        assertEquals(values.get(0).get(0), backgroundValue);
    }

    void Given_value_for_cleanup_should_be_set_to(List<List<String>> values ) {
        System.out.println("---  " + "Given_value_for_cleanup_should_be_set_to");
        assertEquals(values.get(0).get(0), cleanupValue);
    }

}

package gherkinexecutor.Feature_Background;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class Feature_Background_glue {
    final String DNCString = "?DNC?";


    void Given_Background_Function(){
        System.out.println("---  " + "Given_Background_Function");
    }

    void Given_Cleanup_Function(){
        System.out.println("---  " + "Given_Cleanup_Function");
    }

    void Given_a_regular_function(){
        System.out.println("---  " + "Given_a_regular_function");
    }

}

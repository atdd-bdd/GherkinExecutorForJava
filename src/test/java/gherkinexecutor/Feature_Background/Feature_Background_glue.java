package gherkinexecutor.Feature_Background;
import static org.junit.Assert.fail;
import java.util.List;

class Feature_Background_glue {

    void Given_Background_Function(){
        System.out.println("---  " + "Given_Background_Function");
        System.out.println("*******");
    }

    void Given_Cleanup_Function(){
        System.out.println("---  " + "Given_Cleanup_Function");
        System.out.println("*******");
    }

    void Given_a_regular_function(){
        System.out.println("---  " + "Given_a_regular_function");
        System.out.println("*******");
    }

}

package gherkinexecutor.Feature_Background;
import static org.junit.Assert.fail;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

class Feature_Background_glue {
    void log(String value) {
        try {
            FileWriter mylog = new FileWriter("src/test/java/gherkinexecutor/Feature_Background/log.txt", true);
            mylog.write(value + "\n");
            mylog.close();
        } catch (IOException e) {
            System.out.println("**** Cannot write to log ");
        }
    }


    void Given_Background_Function(){
        System.out.println("---  " + "Given_Background_Function");
        System.out.println("*******");
        log("---  " + "Given_Background_Function");
        log("*******");
    }

    void Given_Cleanup_Function(){
        System.out.println("---  " + "Given_Cleanup_Function");
        System.out.println("*******");
        log("---  " + "Given_Cleanup_Function");
        log("*******");
    }

    void Given_a_regular_function(){
        System.out.println("---  " + "Given_a_regular_function");
        System.out.println("*******");
        log("---  " + "Given_a_regular_function");
        log("*******");
    }

}

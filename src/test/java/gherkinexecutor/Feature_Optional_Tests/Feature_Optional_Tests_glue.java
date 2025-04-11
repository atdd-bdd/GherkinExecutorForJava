package gherkinexecutor.Feature_Optional_Tests;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

class Feature_Optional_Tests_glue {
    final String DNCString = "?DNC?";
void log(String value) {
    try {
        FileWriter myLog = new FileWriter("src/test/java/gherkinexecutor/Feature_Optional_Tests/log.txt", true);
        myLog.write(value + "\n");
        myLog.close();
    } catch (IOException e) {
    System.err.println("*** Cannot write to log ");
    }
    }


    void Given_This_will_always_be_run(){
        System.out.println("---  " + "Given_This_will_always_be_run");
        log("---  " + "Given_This_will_always_be_run");
    }

    void Given_This_may_be_run(){
        System.out.println("---  " + "Given_This_may_be_run");
        log("---  " + "Given_This_may_be_run");
    }

    void Given_This_will_be_run_if_tag(){
        System.out.println("---  " + "Given_This_will_be_run_if_tag");
        log("---  " + "Given_This_will_be_run_if_tag");
    }

    }

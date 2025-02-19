package gherkinexecutor.Feature_Include;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Feature_Include{
void log(String value) {
    try {
        FileWriter mylog = new FileWriter("src/test/java/gherkinexecutor/Feature_Include/log.txt", true);
        mylog.write(value + "\n");
        mylog.close();
    } catch (IOException e) {
    System.out.println("**** Cannot write to log ");
    }
    }


    @Test
    void test_Scenario_Some_scenario_here(){
         Feature_Include_glue feature_Include_glue_object = new Feature_Include_glue();
        log("Scenario_Some_scenario_here");

        String string1 =
            """
            This is an include string
            """.stripIndent();
        feature_Include_glue_object.Given_a_string(string1);

        List<List<String>> stringListList2 = List.of(
           List.of(
            "a"
            ,"b,c"
            ,"d,"
            )
           ,List.of(
            "1"
            ,"2"
            ,"3"
            )
            );
        feature_Include_glue_object.Then_a_table(stringListList2);
        }
    }


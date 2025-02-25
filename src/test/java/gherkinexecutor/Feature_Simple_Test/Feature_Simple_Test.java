package gherkinexecutor.Feature_Simple_Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.List;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Feature_Simple_Test{


    @Test
    void test_Scenario_Simple(){
         Feature_Simple_Test_glue feature_Simple_Test_glue_object = new Feature_Simple_Test_glue();

        List<ATest> objectList1 = List.of(
             new ATest.Builder()
                .anInt("1")
                .aString("something")
                .aDouble("1.2")
                .build()
            );
        feature_Simple_Test_glue_object.Given_table_is(objectList1);
        }
    }


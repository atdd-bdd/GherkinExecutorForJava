package gherkinexecutor.Feature_Simple_Test;
import org.junit.jupiter.api.*;
import java.util.List;
@SuppressWarnings({"NewClassNamingConvention"})
class Feature_Simple_Test{


    @Test
    void test_Scenario_Simple(){
         Feature_Simple_Test_glue feature_Simple_Test_glue_object = new Feature_Simple_Test_glue();

        List<ATest> objectList1 = List.of(
             new ATest.Builder()
                .setAnInt("1")
                .setAString("something")
                .setADouble("1.2")
                .build()
            );
        feature_Simple_Test_glue_object.Given_table_is(objectList1);
        }
    }


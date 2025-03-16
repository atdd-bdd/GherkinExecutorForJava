package gherkinexecutor.Feature_Starting;
import org.junit.jupiter.api.Test;
import java.util.List;
class Feature_Starting{


    @Test
    void test_Scenario_Temperature_Conversion(){
         Feature_Starting_glue feature_Starting_glue_object = new Feature_Starting_glue();

        List<FandC> objectList1 = List.of(
             new FandC.Builder()
                .setF("32")
                .setC("0")
                .setNotes("Freezing")
                .build()
            , new FandC.Builder()
                .setF("212")
                .setC("100")
                .setNotes("Boiling")
                .build()
            , new FandC.Builder()
                .setF("-40")
                .setC("-40")
                .setNotes("Below zero")
                .build()
            );
        feature_Starting_glue_object.Calculation_Convert_F_to_C(objectList1);
        }
    }


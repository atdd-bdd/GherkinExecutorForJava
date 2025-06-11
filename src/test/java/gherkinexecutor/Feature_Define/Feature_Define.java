package gherkinexecutor.Feature_Define;
import org.junit.jupiter.api.*;
import java.util.List;
@SuppressWarnings({"NewClassNamingConvention"})
class Feature_Define{


    @Test
    void test_Scenario_Simple_Replacement(){
         Feature_Define_glue feature_Define_glue_object = new Feature_Define_glue();

        List<IDValue> objectList1 = List.of(
             new IDValue.Builder()
                .setID("A")
                .setValue("100")
                .build()
            , new IDValue.Builder()
                .setID("B")
                .setValue("1")
                .build()
            );
        feature_Define_glue_object.Given_this_data(objectList1);

        List<IDValue> objectList2 = List.of(
             new IDValue.Builder()
                .setID("A")
                .setValue("100")
                .build()
            , new IDValue.Builder()
                .setID("B")
                .setValue("1")
                .build()
            );
        feature_Define_glue_object.Then_should_be_equal_to_data(objectList2);
        }
    @Test
    void test_Scenario_Try_out_replacements_with_a_calculation(){
         Feature_Define_glue feature_Define_glue_object = new Feature_Define_glue();

        List<IDValue> objectList1 = List.of(
             new IDValue.Builder()
                .setID("A")
                .setValue("100")
                .build()
            , new IDValue.Builder()
                .setID("B")
                .setValue("1")
                .build()
            , new IDValue.Builder()
                .setID("C")
                .setValue("(1 + 100)/2")
                .build()
            );
        feature_Define_glue_object.Given_this_data(objectList1);

        List<IDValue> objectList2 = List.of(
             new IDValue.Builder()
                .setID("A")
                .setValue("100")
                .build()
            , new IDValue.Builder()
                .setID("B")
                .setValue("1")
                .build()
            , new IDValue.Builder()
                .setID("C")
                .setValue("(1 + 100)/2")
                .build()
            );
        feature_Define_glue_object.Then_should_be_equal_to_data(objectList2);
        }
    }


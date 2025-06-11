package gherkinexecutor.Feature_Background;
import org.junit.jupiter.api.*;
import java.util.List;
@SuppressWarnings({"NewClassNamingConvention"})
class Feature_Background{


    void test_Background(Feature_Background_glue feature_Background_glue_object){

        List<List<String>> stringListList1 = List.of(
           List.of(
            "Background Here"
            )
            );
        feature_Background_glue_object.Given_Background_function_sets_a_value(stringListList1);
        }
    void test_Cleanup(Feature_Background_glue feature_Background_glue_object){

        List<List<String>> stringListList1 = List.of(
           List.of(
            "Cleanup Here"
            )
            );
        feature_Background_glue_object.Given_value_for_cleanup_should_be_set_to(stringListList1);
        }
    @Test
    void test_Scenario_Should_have_Background_and_Cleanup(){
         Feature_Background_glue feature_Background_glue_object = new Feature_Background_glue();
        test_Background(feature_Background_glue_object);

        feature_Background_glue_object.Given_a_regular_function();

        List<List<String>> stringListList2 = List.of(
           List.of(
            "Background Here"
            )
            );
        feature_Background_glue_object.Then_background_should_set_value_to(stringListList2);

        List<List<String>> stringListList3 = List.of(
           List.of(
            "Cleanup Here"
            )
            );
        feature_Background_glue_object.And_set_a_value_for_cleanup(stringListList3);
        test_Cleanup(feature_Background_glue_object); // from previous
        }
    @Test
    void test_Scenario_Should_also_have_Background_and_Cleanup(){
         Feature_Background_glue feature_Background_glue_object = new Feature_Background_glue();
        test_Background(feature_Background_glue_object);

        feature_Background_glue_object.Given_a_regular_function();

        List<List<String>> stringListList2 = List.of(
           List.of(
            "Background Here"
            )
            );
        feature_Background_glue_object.Then_background_should_set_value_to(stringListList2);

        List<List<String>> stringListList3 = List.of(
           List.of(
            "Cleanup Here"
            )
            );
        feature_Background_glue_object.And_set_a_value_for_cleanup(stringListList3);
        test_Cleanup(feature_Background_glue_object); // at the end
        }
    }


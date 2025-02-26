package gherkinexecutor.Feature_Background;
import org.junit.jupiter.api.Test;
import java.util.List;
class Feature_Background{


    void test_Background(Feature_Background_glue feature_Background_glue_object){

        feature_Background_glue_object.Given_Background_Function();
        }
    void test_Cleanup(Feature_Background_glue feature_Background_glue_object){

        feature_Background_glue_object.Given_Cleanup_Function();
        }
    @Test
    void test_Scenario_Should_have_Background_and_Cleanup(){
         Feature_Background_glue feature_Background_glue_object = new Feature_Background_glue();
        test_Background(feature_Background_glue_object);

        feature_Background_glue_object.Given_a_regular_function();
        test_Cleanup(feature_Background_glue_object); // from previous
        }
    @Test
    void test_Scenario_Should_also_have_Background_and_Cleanup(){
         Feature_Background_glue feature_Background_glue_object = new Feature_Background_glue();
        test_Background(feature_Background_glue_object);

        feature_Background_glue_object.Given_a_regular_function();
        test_Cleanup(feature_Background_glue_object); // at the end
        }
    }


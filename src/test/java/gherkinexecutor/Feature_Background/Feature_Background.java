package gherkinexecutor.Feature_Background;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.List;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Feature_Background{

    @Test
    void test_Background(){
         Feature_Background_glue feature_Background_glue_object = new Feature_Background_glue();

        feature_Background_glue_object.Given_Background_Function();
        }
    @Test
    void test_Cleanup(){
         Feature_Background_glue feature_Background_glue_object = new Feature_Background_glue();

        feature_Background_glue_object.Given_Cleanup_Function();
        test_Cleanup();
        }
    @Test
    void test_Scenario_Should_have_Background_and_Cleanup(){
         Feature_Background_glue feature_Background_glue_object = new Feature_Background_glue();
        test_Background();

        feature_Background_glue_object.Given_a_regular_function();
        test_Cleanup();
        }
    @Test
    void test_Scenario_Should_also_have_Background_and_Cleanup(){
         Feature_Background_glue feature_Background_glue_object = new Feature_Background_glue();
        test_Background();

        feature_Background_glue_object.Given_a_regular_function();
        test_Cleanup();
        }
    }


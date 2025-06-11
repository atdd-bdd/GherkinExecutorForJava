package gherkinexecutor.Feature_Optional_Tests;
import org.junit.jupiter.api.*;
import java.util.List;
@SuppressWarnings({"NewClassNamingConvention"})
@Tag("OnlyThisFeature")
class Feature_Optional_Tests{


    @Test
    void test_Scenario_This_will_always_be_run(){
         Feature_Optional_Tests_glue feature_Optional_Tests_glue_object = new Feature_Optional_Tests_glue();

        feature_Optional_Tests_glue_object.Given_This_will_always_be_run();
        }
    @Test
    void test_Scenario_This_may_be_run(){
         Feature_Optional_Tests_glue feature_Optional_Tests_glue_object = new Feature_Optional_Tests_glue();

        feature_Optional_Tests_glue_object.Given_This_may_be_run();
        }
@Tag("OnlyThis")
    @Test
    void test_Scenario_This_will_be_run_if_tag(){
         Feature_Optional_Tests_glue feature_Optional_Tests_glue_object = new Feature_Optional_Tests_glue();

        feature_Optional_Tests_glue_object.Given_This_will_be_run_if_tag();
        }
    }


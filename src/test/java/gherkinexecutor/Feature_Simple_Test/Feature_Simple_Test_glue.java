package gherkinexecutor.Feature_Simple_Test;
import static org.junit.Assert.fail;
import java.util.List;

class Feature_Simple_Test_glue {

    void Given_table_is(List<ATest> value ) {
        System.out.println("*******");
        System.out.println(value);
        fail("Must implement");
    }

}

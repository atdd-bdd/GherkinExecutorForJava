import org.junit.jupiter.api.Test
import java.util.Arrays;
import java.util.List;

public class Feature_Simple_Test {
    @Test
    public void test_Scenario_Simple()
    {
        Feature_Simple_Test_glue x = new Feature_Simple_Test_glue();

        List<ATest> objectList1 = Arrays.asList(
                new ATest(
                        "1",
        "something",
        "1.2"
        )
        );

        x.Given_table_is(objectList1);
    }
}

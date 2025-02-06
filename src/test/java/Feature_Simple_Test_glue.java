import java.util.List;

public class Feature_Simple_Test_glue {

    public void Given_table_is(List<ATest> value) {
        System.out.println("*******");
        System.out.println(value);
        fail("Must implement");
    }

    private void fail(String message) {
        throw new AssertionError(message);
    }
}

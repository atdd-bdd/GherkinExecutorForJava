package gherkinexecutor.Feature_Data_Types;
import static org.junit.Assert.fail;
import java.util.List;

class Feature_Data_Types_glue {

    void Given_type_values_are(List<AllTypes> value ) {
        System.out.println("---  " + "Given_type_values_are");
        System.out.println("*******");
        System.out.println(value);
    }

    }

package gherkinexecutor.Feature_Starting;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class Feature_Starting_glue {
    final String DNCString = "?DNC?";


    void Calculation_Convert_F_to_C(List<FandC> values ) {
        System.out.println("---  " + "Calculation_Convert_F_to_C");
        for (FandC value : values){
             System.out.println(value);
             // Add calls to production code and asserts
              FandCInternal i = value.toFandCInternal();
              }
        fail("Must implement");
    }

    }

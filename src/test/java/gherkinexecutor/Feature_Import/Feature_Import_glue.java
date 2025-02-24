package gherkinexecutor.Feature_Import;

import java.util.List;

import static org.testng.AssertJUnit.fail;

class Feature_Import_glue {


    void Given_this_data(List<Imports> values) {
        System.out.println("---  " + "Given_this_data");
        boolean good = true;
        for (Imports value : values) {
            System.out.println(value);
            try {
                ImportsInternal i = value.toImportsInternal();
                System.out.println(i);
            } catch (Exception e) {
                System.err.println("Argument Error " + value.toString() + ImportsInternal.toDataTypeString());
                System.err.println("Message " + e.getMessage() + " cause " + e.getCause() + " " +e.toString());
                good = false;
            }
        }
        if (!good)
           fail("Data is valid, but not accepted ");
    }

    public void Given_this_data_should_fail(List<Imports> values) {
        System.out.println("---  " + "Given_this_data_should_fail");
        boolean good = true;
        for (Imports value : values) {
            System.out.println(value);
            try {
                ImportsInternal i = value.toImportsInternal();
                System.out.println(i);
            } catch (Exception e) {
                System.err.println("Argument Error " + value.toString() + ImportsInternal.toDataTypeString());
                System.err.println("Message " + e.getMessage() + " cause " + e.getCause() + " " +e.toString());
                good = false;
            }
        }
        if (good)
            fail("Data is invalid, but accepted as good");

    }
}

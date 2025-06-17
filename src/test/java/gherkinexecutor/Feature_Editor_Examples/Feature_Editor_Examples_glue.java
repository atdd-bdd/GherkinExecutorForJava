package gherkinexecutor.Feature_Editor_Examples;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class Feature_Editor_Examples_glue {
    final String DNCString = "?DNC?";


    void Star_Discount_based_on_quantity(List<QuantityDiscount> values ) {
        System.out.println("---  " + "Star_Discount_based_on_quantity");
        for (QuantityDiscount value : values){
             System.out.println(value);
             // Add calls to production code and asserts
              QuantityDiscountInternal i = value.toQuantityDiscountInternal();
              }
        fail("Must implement");
    }

    void Star_Password_must_contain_4_letters_and_1_number(List<ValueValid> values ) {
        System.out.println("---  " + "Star_Password_must_contain_4_letters_and_1_number");
        for (ValueValid value : values){
             System.out.println(value);
             // Add calls to production code and asserts
              ValueValidInternal i = value.toValueValidInternal();
              }
        fail("Must implement");
    }

    }

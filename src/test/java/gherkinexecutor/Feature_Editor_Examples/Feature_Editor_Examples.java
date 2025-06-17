package gherkinexecutor.Feature_Editor_Examples;
import org.junit.jupiter.api.*;
import java.util.List;
@SuppressWarnings({"NewClassNamingConvention"})
class Feature_Editor_Examples{


    @Test
    void test_Scenario_Business_Rule_Quantity_Discount(){
         Feature_Editor_Examples_glue feature_Editor_Examples_glue_object = new Feature_Editor_Examples_glue();

        List<QuantityDiscount> objectList1 = List.of(
             new QuantityDiscount.Builder()
                .setQuantity("1")
                .setDiscount("0%")
                .setNotes("")
                .build()
            , new QuantityDiscount.Builder()
                .setQuantity("2")
                .setDiscount("1%")
                .setNotes("1-9")
                .build()
            , new QuantityDiscount.Builder()
                .setQuantity("9")
                .setDiscount("1%")
                .setNotes("1-9")
                .build()
            , new QuantityDiscount.Builder()
                .setQuantity("10")
                .setDiscount("5%")
                .setNotes("10 +")
                .build()
            );
        feature_Editor_Examples_glue_object.Star_Discount_based_on_quantity(objectList1);
        }
    @Test
    void test_Scenario_Domain_Term_Password(){
         Feature_Editor_Examples_glue feature_Editor_Examples_glue_object = new Feature_Editor_Examples_glue();

        List<ValueValid> objectList1 = List.of(
             new ValueValid.Builder()
                .setValue("abcd1")
                .setValid("Yes")
                .setNotes("")
                .build()
            , new ValueValid.Builder()
                .setValue("abcde")
                .setValid("No")
                .setNotes("no number")
                .build()
            , new ValueValid.Builder()
                .setValue("abc1")
                .setValid("No")
                .setNotes("less than 4 letters")
                .build()
            );
        feature_Editor_Examples_glue_object.Star_Password_must_contain_4_letters_and_1_number(objectList1);
        }
    }


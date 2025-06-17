package gherkinexecutor.Feature_Editor_Examples;
import java.util.*;
//noinspection CanBeFinal
//noinspection UnusedImports
@SuppressWarnings({"unused", "EnhancedSwitchMigration", "ClassCanBeRecord", "NewClassNamingConvention", "RedundantSuppression"})
class QuantityDiscountInternal{
     Integer quantity;
     Percentage discount;
     String notes;
     
    public static String toDataTypeString() {
        return "QuantityDiscountInternal {"
        +"Integer " 
        +"Percentage " 
        +"String " 
            + "} "; }  
    QuantityDiscount toQuantityDiscount() {
        return new QuantityDiscount(
        String.valueOf(quantity)
        ,discount.toString()
        ,notes
        ); }
    public QuantityDiscountInternal(
        Integer quantity
        ,Percentage discount
        ,String notes
        )  {
        this.quantity = quantity;
        this.discount = discount;
        this.notes = notes;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuantityDiscountInternal _QuantityDiscountInternal = (QuantityDiscountInternal) o;
         return 
                ( _QuantityDiscountInternal.quantity.equals(this.quantity))
                 && ( _QuantityDiscountInternal.discount.equals(this.discount))
                 && ( _QuantityDiscountInternal.notes.equals(this.notes))
             ;  }
        @Override
        public String toString() {
            return "QuantityDiscountInternal {"
             +"quantity = " + quantity + " "
             +"discount = " + discount + " "
             +"notes = " + notes + " "
             + "} " + "\n"; }

    }

package gherkinexecutor.Feature_Full_Test;
import java.util.*;
import java.util.regex.Pattern;
import java.math.BigInteger;
class FilterValueInternal{
     ID value;
     
    public static String toDataTypeString() {
        return "FilterValueInternal {"
        +"ID " 
            + "} "; }  
    FilterValue toFilterValue() {
        return new FilterValue(
        value.toString()
        ); }
    public FilterValueInternal(
        ID value
        )  {
        this.value = value;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilterValueInternal _FilterValueInternal = (FilterValueInternal) o;
         return 
                ( _FilterValueInternal.value.equals(this.value))
             ;  }
        @Override
        public String toString() {
            return "FilterValueInternal {"
             +"value = " + value + " "
             + "} " + "\n"; }

    }

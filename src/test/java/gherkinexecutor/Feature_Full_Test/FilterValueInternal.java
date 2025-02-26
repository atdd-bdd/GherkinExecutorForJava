package gherkinexecutor.Feature_Full_Test;
import java.util.*;
import java.util.regex.Pattern;
import java.math.BigInteger;
class FilterValueInternal{
     String name;
     String value;
     
    public static String toDataTypeString() {
        return "FilterValueInternal {"
        +"String " 
        +"String " 
            + "} "; }  
    FilterValue toFilterValue() {
        return new FilterValue(
        name
        ,value
        ); }
    public FilterValueInternal(
        String name
        ,String value
        )  {
        this.name = name;
        this.value = value;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilterValueInternal _FilterValueInternal = (FilterValueInternal) o;
         return 
                ( _FilterValueInternal.name.equals(this.name))
                 && ( _FilterValueInternal.value.equals(this.value))
             ;  }
    @Override
    public String toString() {
        return "FilterValueInternal {"
        +"name = " + name + " "
        +"value = " + value + " "
            + "} "; }  
    }

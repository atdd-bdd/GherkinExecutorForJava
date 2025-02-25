package gherkinexecutor.Feature_Examples;
import java.util.*;
import java.util.regex.Pattern;
import java.math.BigInteger;
class LabelValueInternal{
     String label;
     Integer value;
     
    public static String toDataTypeString() {
        return "LabelValueInternal {"
        +"String " 
        +"Integer " 
            + "} "; }  
    LabelValue toLabelValue() {
        return new LabelValue(
        label
        ,String.valueOf(value)
        ); }
    public LabelValueInternal(
        String label
        ,Integer value
        )  {
        this.label = label;
        this.value = value;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LabelValueInternal _LabelValueInternal = (LabelValueInternal) o;
         return 
                ( _LabelValueInternal.label.equals(this.label))
                 && ( _LabelValueInternal.value.equals(this.value))
             ;  }
    @Override
    public String toString() {
        return "LabelValueInternal {"
        +"label = " + label + " "
        +"value = " + value + " "
            + "} "; }  
    }

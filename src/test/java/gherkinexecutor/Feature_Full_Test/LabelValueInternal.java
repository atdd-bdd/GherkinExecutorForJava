package gherkinexecutor.Feature_Full_Test;
import java.util.*;
class LabelValueInternal{
     String label = "";
     Integer value = Integer.valueOf("0");
     
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
    public LabelValueInternal() { }
    public LabelValueInternal(
        String label
        ,Integer value
        )  {
        this.label = label;
        this.value = value;
        }
    @Override
    public String toString() {
        return "LabelValueInternal {"
        +"label = " + label + " "
        +"value = " + value + " "
            + "} "; }  
    }

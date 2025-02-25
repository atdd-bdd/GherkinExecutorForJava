package gherkinexecutor.Feature_Examples;
import java.util.*;
import java.util.regex.Pattern;
import java.math.BigInteger;
class LabelValue{
    String label = "";
    String value = "0";
    public LabelValue() { }
    public LabelValue(
        String label
        ,String value
        ){
        this.label = label;
        this.value = value;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LabelValue _LabelValue = (LabelValue) o;
         if (
             !this.label.equals("?DNC?")
                && !_LabelValue.label.equals("?DNC?"))
                return ( _LabelValue.label.equals(this.label));
         if (
             !this.value.equals("?DNC?")
                && !_LabelValue.value.equals("?DNC?"))
                return ( _LabelValue.value.equals(this.value));
             return true;  }
    public static class Builder {
        private String label = "";
        private String value = "0";
        public Builder label(String label) {
            this.label = label;
            return this;
            }
        public Builder value(String value) {
            this.value = value;
            return this;
            }
        public Builder  setCompare() {
            label = "?DNC?";
            value = "?DNC?";
            return this;
            }
        public LabelValue build(){
             return new LabelValue(
                 label
                 ,value
                );   } 
        } 
    @Override
    public String toString() {
        return "LabelValue {"
        +"label = " + label + " "
        +"value = " + value + " "
            + "} "; }  
    LabelValueInternal toLabelValueInternal() throws IllegalArgumentException {
        return new LabelValueInternal(
         label
        , Integer.valueOf(value)
        ); }
    }

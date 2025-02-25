package gherkinexecutor.Feature_Full_Test;
import java.util.*;
import java.util.regex.Pattern;
import java.math.BigInteger;
class FilterValue{
    String name = "";
    String value = "0";
    public FilterValue() { }
    public FilterValue(
        String name
        ,String value
        ){
        this.name = name;
        this.value = value;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilterValue _FilterValue = (FilterValue) o;
         if (
             !this.name.equals("?DNC?")
                && !_FilterValue.name.equals("?DNC?"))
                return ( _FilterValue.name.equals(this.name));
         if (
             !this.value.equals("?DNC?")
                && !_FilterValue.value.equals("?DNC?"))
                return ( _FilterValue.value.equals(this.value));
             return true;  }
    public static class Builder {
        private String name = "";
        private String value = "0";
        public Builder name(String name) {
            this.name = name;
            return this;
            }
        public Builder value(String value) {
            this.value = value;
            return this;
            }
        public Builder  setCompare() {
            name = "?DNC?";
            value = "?DNC?";
            return this;
            }
        public FilterValue build(){
             return new FilterValue(
                 name
                 ,value
                );   } 
        } 
    @Override
    public String toString() {
        return "FilterValue {"
        +"name = " + name + " "
        +"value = " + value + " "
            + "} "; }  
    FilterValueInternal toFilterValueInternal() throws IllegalArgumentException {
        return new FilterValueInternal(
         name
        , value
        ); }
    }

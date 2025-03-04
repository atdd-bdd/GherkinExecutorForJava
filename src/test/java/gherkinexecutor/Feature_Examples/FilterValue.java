package gherkinexecutor.Feature_Examples;
import java.util.*;
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
        if (o == null || getClass() != o.getClass())
             return false;
        FilterValue _FilterValue = (FilterValue) o;
            boolean result = true;
         if (
             !this.name.equals("?DNC?")
                && !_FilterValue.name.equals("?DNC?"))
                if (! _FilterValue.name.equals(this.name)) result = false;
         if (
             !this.value.equals("?DNC?")
                && !_FilterValue.value.equals("?DNC?"))
                if (! _FilterValue.value.equals(this.value)) result = false;
             return result;  }
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
            + "} " + "\n"; }  
    FilterValueInternal toFilterValueInternal() {
        return new FilterValueInternal(
         name
        , value
        ); }
    }

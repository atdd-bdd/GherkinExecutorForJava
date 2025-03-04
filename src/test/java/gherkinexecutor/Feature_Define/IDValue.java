package gherkinexecutor.Feature_Define;
import java.util.*;
class IDValue{
    String iD = "";
    String value = "";
    public IDValue() { }
    public IDValue(
        String iD
        ,String value
        ){
        this.iD = iD;
        this.value = value;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
             return false;
        IDValue _IDValue = (IDValue) o;
            boolean result = true;
         if (
             !this.iD.equals("?DNC?")
                && !_IDValue.iD.equals("?DNC?"))
                if (! _IDValue.iD.equals(this.iD)) result = false;
         if (
             !this.value.equals("?DNC?")
                && !_IDValue.value.equals("?DNC?"))
                if (! _IDValue.value.equals(this.value)) result = false;
             return result;  }
    public static class Builder {
        private String iD = "";
        private String value = "";
        public Builder iD(String iD) {
            this.iD = iD;
            return this;
            }
        public Builder value(String value) {
            this.value = value;
            return this;
            }
        public Builder  setCompare() {
            iD = "?DNC?";
            value = "?DNC?";
            return this;
            }
        public IDValue build(){
             return new IDValue(
                 iD
                 ,value
                );   } 
        } 
    @Override
    public String toString() {
        return "IDValue {"
        +"iD = " + iD + " "
        +"value = " + value + " "
            + "} " + "\n"; }  
    }

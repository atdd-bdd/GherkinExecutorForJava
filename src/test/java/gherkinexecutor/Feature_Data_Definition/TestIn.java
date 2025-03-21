package gherkinexecutor.Feature_Data_Definition;
import java.util.*;
class TestIn{
    String aValue = "0";
    String bValue = " ";
    String cValue = "4.0";
    public TestIn() { }
    public TestIn(
        String aValue
        ,String bValue
        ,String cValue
        ){
        this.aValue = aValue;
        this.bValue = bValue;
        this.cValue = cValue;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
             return false;
        TestIn _TestIn = (TestIn) o;
            boolean result = true;
         if (
             !this.aValue.equals("?DNC?")
                && !_TestIn.aValue.equals("?DNC?"))
                if (! _TestIn.aValue.equals(this.aValue)) result = false;
         if (
             !this.bValue.equals("?DNC?")
                && !_TestIn.bValue.equals("?DNC?"))
                if (! _TestIn.bValue.equals(this.bValue)) result = false;
         if (
             !this.cValue.equals("?DNC?")
                && !_TestIn.cValue.equals("?DNC?"))
                if (! _TestIn.cValue.equals(this.cValue)) result = false;
             return result;  }
    public static class Builder {
        private String aValue = "0";
        private String bValue = " ";
        private String cValue = "4.0";
        public Builder aValue(String aValue) {
            this.aValue = aValue;
            return this;
            }
        public Builder bValue(String bValue) {
            this.bValue = bValue;
            return this;
            }
        public Builder cValue(String cValue) {
            this.cValue = cValue;
            return this;
            }
        public Builder  setCompare() {
            aValue = "?DNC?";
            bValue = "?DNC?";
            cValue = "?DNC?";
            return this;
            }
        public TestIn build(){
             return new TestIn(
                 aValue
                 ,bValue
                 ,cValue
                );   } 
        } 
    @Override
    public String toString() {
        return "TestIn {"
        +"aValue = " + aValue + " "
        +"bValue = " + bValue + " "
        +"cValue = " + cValue + " "
            + "} " + "\n"; }  
    Existing toExisting() {
        return new Existing(
         Integer.parseInt(aValue)
        , bValue
        , Double.parseDouble(cValue)
        ); }
    }

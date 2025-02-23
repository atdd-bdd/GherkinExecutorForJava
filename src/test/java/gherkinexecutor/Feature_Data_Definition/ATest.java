package gherkinexecutor.Feature_Data_Definition;
import java.util.*;
class ATest{
    String anInt = "0";
    String aString = " ";
    String aDouble = "4.0";
    public ATest() { }
    public ATest(
        String anInt
        ,String aString
        ,String aDouble
        ){
        this.anInt = anInt;
        this.aString = aString;
        this.aDouble = aDouble;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ATest _ATest = (ATest) o;
         if (
             !this.anInt.equals("?DNC?")
                && !_ATest.anInt.equals("?DNC?"))
                return ( _ATest.anInt.equals(this.anInt));
         if (
             !this.aString.equals("?DNC?")
                && !_ATest.aString.equals("?DNC?"))
                return ( _ATest.aString.equals(this.aString));
         if (
             !this.aDouble.equals("?DNC?")
                && !_ATest.aDouble.equals("?DNC?"))
                return ( _ATest.aDouble.equals(this.aDouble));
             return true;  }
    public static class Builder {
        private String anInt = "0";
        private String aString = " ";
        private String aDouble = "4.0";
        public Builder anInt(String anInt) {
            this.anInt = anInt;
            return this;
            }
        public Builder aString(String aString) {
            this.aString = aString;
            return this;
            }
        public Builder aDouble(String aDouble) {
            this.aDouble = aDouble;
            return this;
            }
        public Builder  setCompare() {
            anInt = "?DNC?";
            aString = "?DNC?";
            aDouble = "?DNC?";
            return this;
            }
        public ATest build(){
             return new ATest(
                 anInt
                 ,aString
                 ,aDouble
                );   } 
        } 
    @Override
    public String toString() {
        return "ATest {"
        +"anInt = " + anInt + " "
        +"aString = " + aString + " "
        +"aDouble = " + aDouble + " "
            + "} "; }  
    ATestInternal toATestInternal() throws Exception {
        return new ATestInternal(
         Integer.valueOf(anInt)
        , aString
        , Double.valueOf(aDouble)
        ); }
    }

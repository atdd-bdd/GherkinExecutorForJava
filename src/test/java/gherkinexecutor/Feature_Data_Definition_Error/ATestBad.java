package gherkinexecutor.Feature_Data_Definition_Error;
import java.util.*;
class ATestBad{
    String anInt = "a";
    String aString = " ";
    String aDouble = "b";
    public ATestBad() { }
    public ATestBad(
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
        if (o == null || getClass() != o.getClass())
             return false;
        ATestBad _ATestBad = (ATestBad) o;
            boolean result = true;
         if (
             !this.anInt.equals("?DNC?")
                && !_ATestBad.anInt.equals("?DNC?"))
                if (! _ATestBad.anInt.equals(this.anInt)) result = false;
         if (
             !this.aString.equals("?DNC?")
                && !_ATestBad.aString.equals("?DNC?"))
                if (! _ATestBad.aString.equals(this.aString)) result = false;
         if (
             !this.aDouble.equals("?DNC?")
                && !_ATestBad.aDouble.equals("?DNC?"))
                if (! _ATestBad.aDouble.equals(this.aDouble)) result = false;
             return result;  }
    public static class Builder {
        private String anInt = "a";
        private String aString = " ";
        private String aDouble = "b";
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
        public ATestBad build(){
             return new ATestBad(
                 anInt
                 ,aString
                 ,aDouble
                );   } 
        } 
    @Override
    public String toString() {
        return "ATestBad {"
        +"anInt = " + anInt + " "
        +"aString = " + aString + " "
        +"aDouble = " + aDouble + " "
            + "} " + "\n"; }  
    ATestBadInternal toATestBadInternal() {
        return new ATestBadInternal(
         Integer.valueOf(anInt)
        , aString
        , Double.valueOf(aDouble)
        ); }
    }

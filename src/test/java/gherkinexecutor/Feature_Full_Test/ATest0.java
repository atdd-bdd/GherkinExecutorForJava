package gherkinexecutor.Feature_Full_Test;
import java.util.*;
import java.util.regex.Pattern;
import java.math.BigInteger;
class ATest0{
    String anInt = "0";
    String aString = "^";
    String aDouble = "1.2";
    public ATest0() { }
    public ATest0(
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
        ATest0 _ATest0 = (ATest0) o;
         if (
             !this.anInt.equals("?DNC?")
                && !_ATest0.anInt.equals("?DNC?"))
                return ( _ATest0.anInt.equals(this.anInt));
         if (
             !this.aString.equals("?DNC?")
                && !_ATest0.aString.equals("?DNC?"))
                return ( _ATest0.aString.equals(this.aString));
         if (
             !this.aDouble.equals("?DNC?")
                && !_ATest0.aDouble.equals("?DNC?"))
                return ( _ATest0.aDouble.equals(this.aDouble));
             return true;  }
    public static class Builder {
        private String anInt = "0";
        private String aString = "^";
        private String aDouble = "1.2";
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
        public ATest0 build(){
             return new ATest0(
                 anInt
                 ,aString
                 ,aDouble
                );   } 
        } 
    @Override
    public String toString() {
        return "ATest0 {"
        +"anInt = " + anInt + " "
        +"aString = " + aString + " "
        +"aDouble = " + aDouble + " "
            + "} "; }  
    ATestInternal toATestInternal() throws IllegalArgumentException {
        return new ATestInternal(
         Integer.valueOf(anInt)
        , aString
        , Double.valueOf(aDouble)
        ); }
    }

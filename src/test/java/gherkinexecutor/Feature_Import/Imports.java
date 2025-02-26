package gherkinexecutor.Feature_Import;
import java.util.*;
import java.util.regex.Pattern;
import java.math.BigInteger;
class Imports{
    String myPattern = "a.*";
    String myWeekday = "MONDAY";
    String myBigInt = "1";
    public Imports() { }
    public Imports(
        String myPattern
        ,String myWeekday
        ,String myBigInt
        ){
        this.myPattern = myPattern;
        this.myWeekday = myWeekday;
        this.myBigInt = myBigInt;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
             return false;
        Imports _Imports = (Imports) o;
            boolean result = true;
         if (
             !this.myPattern.equals("?DNC?")
                && !_Imports.myPattern.equals("?DNC?"))
                if (! _Imports.myPattern.equals(this.myPattern)) result = false;
         if (
             !this.myWeekday.equals("?DNC?")
                && !_Imports.myWeekday.equals("?DNC?"))
                if (! _Imports.myWeekday.equals(this.myWeekday)) result = false;
         if (
             !this.myBigInt.equals("?DNC?")
                && !_Imports.myBigInt.equals("?DNC?"))
                if (! _Imports.myBigInt.equals(this.myBigInt)) result = false;
             return result;  }
    public static class Builder {
        private String myPattern = "a.*";
        private String myWeekday = "MONDAY";
        private String myBigInt = "1";
        public Builder myPattern(String myPattern) {
            this.myPattern = myPattern;
            return this;
            }
        public Builder myWeekday(String myWeekday) {
            this.myWeekday = myWeekday;
            return this;
            }
        public Builder myBigInt(String myBigInt) {
            this.myBigInt = myBigInt;
            return this;
            }
        public Builder  setCompare() {
            myPattern = "?DNC?";
            myWeekday = "?DNC?";
            myBigInt = "?DNC?";
            return this;
            }
        public Imports build(){
             return new Imports(
                 myPattern
                 ,myWeekday
                 ,myBigInt
                );   } 
        } 
    @Override
    public String toString() {
        return "Imports {"
        +"myPattern = " + myPattern + " "
        +"myWeekday = " + myWeekday + " "
        +"myBigInt = " + myBigInt + " "
            + "} "; }  
    ImportsInternal toImportsInternal() throws IllegalArgumentException {
        return new ImportsInternal(
         Pattern.compile(myPattern)
        , Weekday.valueOf(myWeekday)
        , new BigInteger(myBigInt)
        ); }
    }

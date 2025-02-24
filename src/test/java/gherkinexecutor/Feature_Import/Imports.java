package gherkinexecutor.Feature_Import;
import java.util.*;
import java.net.URL;
import java.util.regex.Pattern;
import java.math.BigInteger;
class Imports{
    String myURL = "http://kenpugh.com";
    String myPattern = "a.*";
    String myWeekday = "MONDAY";
    String myBigInt = "1";
    public Imports() { }
    public Imports(
        String myURL
        ,String myPattern
        ,String myWeekday
        ,String myBigInt
        ){
        this.myURL = myURL;
        this.myPattern = myPattern;
        this.myWeekday = myWeekday;
        this.myBigInt = myBigInt;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Imports _Imports = (Imports) o;
         if (
             !this.myURL.equals("?DNC?")
                && !_Imports.myURL.equals("?DNC?"))
                return ( _Imports.myURL.equals(this.myURL));
         if (
             !this.myPattern.equals("?DNC?")
                && !_Imports.myPattern.equals("?DNC?"))
                return ( _Imports.myPattern.equals(this.myPattern));
         if (
             !this.myWeekday.equals("?DNC?")
                && !_Imports.myWeekday.equals("?DNC?"))
                return ( _Imports.myWeekday.equals(this.myWeekday));
         if (
             !this.myBigInt.equals("?DNC?")
                && !_Imports.myBigInt.equals("?DNC?"))
                return ( _Imports.myBigInt.equals(this.myBigInt));
             return true;  }
    public static class Builder {
        private String myURL = "http://kenpugh.com";
        private String myPattern = "a.*";
        private String myWeekday = "MONDAY";
        private String myBigInt = "1";
        public Builder myURL(String myURL) {
            this.myURL = myURL;
            return this;
            }
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
            myURL = "?DNC?";
            myPattern = "?DNC?";
            myWeekday = "?DNC?";
            myBigInt = "?DNC?";
            return this;
            }
        public Imports build(){
             return new Imports(
                 myURL
                 ,myPattern
                 ,myWeekday
                 ,myBigInt
                );   } 
        } 
    @Override
    public String toString() {
        return "Imports {"
        +"myURL = " + myURL + " "
        +"myPattern = " + myPattern + " "
        +"myWeekday = " + myWeekday + " "
        +"myBigInt = " + myBigInt + " "
            + "} "; }  
    ImportsInternal toImportsInternal() throws Exception {
        return new ImportsInternal(
         new URL(myURL)
        , Pattern.compile(myPattern)
        , Weekday.valueOf(myWeekday)
        , new BigInteger(myBigInt)
        ); }
    }

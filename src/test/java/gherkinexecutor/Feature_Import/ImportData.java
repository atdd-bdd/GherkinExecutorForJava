package gherkinexecutor.Feature_Import;
import java.util.*;
import java.util.regex.Pattern;
import java.math.BigInteger;
class ImportData{
    String myPattern = "a.*";
    String myWeekday = "MONDAY";
    String myBigInt = "1";
    public ImportData() { }
    public ImportData(
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
        ImportData _ImportData = (ImportData) o;
            boolean result = true;
         if (
             !this.myPattern.equals("?DNC?")
                && !_ImportData.myPattern.equals("?DNC?"))
                if (! _ImportData.myPattern.equals(this.myPattern)) result = false;
         if (
             !this.myWeekday.equals("?DNC?")
                && !_ImportData.myWeekday.equals("?DNC?"))
                if (! _ImportData.myWeekday.equals(this.myWeekday)) result = false;
         if (
             !this.myBigInt.equals("?DNC?")
                && !_ImportData.myBigInt.equals("?DNC?"))
                if (! _ImportData.myBigInt.equals(this.myBigInt)) result = false;
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
        public ImportData build(){
             return new ImportData(
                 myPattern
                 ,myWeekday
                 ,myBigInt
                );   } 
        } 
    @Override
    public String toString() {
        return "ImportData {"
        +"myPattern = " + myPattern + " "
        +"myWeekday = " + myWeekday + " "
        +"myBigInt = " + myBigInt + " "
            + "} " + "\n"; }  
    ImportDataInternal toImportDataInternal() {
        return new ImportDataInternal(
         Pattern.compile(myPattern)
        , Weekday.valueOf(myWeekday)
        , new BigInteger(myBigInt)
        ); }
    }

package gherkinexecutor.Feature_Full_Test;
import java.util.*;
import java.util.regex.Pattern;
import java.math.BigInteger;
class ImportsInternal{
     Pattern myPattern;
     Weekday myWeekday;
     BigInteger myBigInt;
     
    public static String toDataTypeString() {
        return "ImportsInternal {"
        +"Pattern " 
        +"Weekday " 
        +"BigInteger " 
            + "} "; }  
    Imports toImports() {
        return new Imports(
        myPattern.toString()
        ,myWeekday.toString()
        ,myBigInt.toString()
        ); }
    public ImportsInternal(
        Pattern myPattern
        ,Weekday myWeekday
        ,BigInteger myBigInt
        )  {
        this.myPattern = myPattern;
        this.myWeekday = myWeekday;
        this.myBigInt = myBigInt;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImportsInternal _ImportsInternal = (ImportsInternal) o;
         return 
                ( _ImportsInternal.myPattern.equals(this.myPattern))
                 && ( _ImportsInternal.myWeekday.equals(this.myWeekday))
                 && ( _ImportsInternal.myBigInt.equals(this.myBigInt))
             ;  }
    @Override
    public String toString() {
        return "ImportsInternal {"
        +"myPattern = " + myPattern + " "
        +"myWeekday = " + myWeekday + " "
        +"myBigInt = " + myBigInt + " "
            + "} "; }  
    }

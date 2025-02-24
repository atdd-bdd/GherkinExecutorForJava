package gherkinexecutor.Feature_Import;
import java.util.*;
import java.net.URL;
import java.util.regex.Pattern;
import java.math.BigInteger;
class ImportsInternal{
     URL myURL;
     Pattern myPattern;
     Weekday myWeekday;
     BigInteger myBigInt;
     
    public static String toDataTypeString() {
        return "ImportsInternal {"
        +"URL " 
        +"Pattern " 
        +"Weekday " 
        +"BigInteger " 
            + "} "; }  
    Imports toImports() {
        return new Imports(
        myURL.toString()
        ,myPattern.toString()
        ,myWeekday.toString()
        ,myBigInt.toString()
        ); }
    public ImportsInternal(
        URL myURL
        ,Pattern myPattern
        ,Weekday myWeekday
        ,BigInteger myBigInt
        )  {
        this.myURL = myURL;
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
                ( _ImportsInternal.myURL.equals(this.myURL))
                 && ( _ImportsInternal.myPattern.equals(this.myPattern))
                 && ( _ImportsInternal.myWeekday.equals(this.myWeekday))
                 && ( _ImportsInternal.myBigInt.equals(this.myBigInt))
             ;  }
    @Override
    public String toString() {
        return "ImportsInternal {"
        +"myURL = " + myURL + " "
        +"myPattern = " + myPattern + " "
        +"myWeekday = " + myWeekday + " "
        +"myBigInt = " + myBigInt + " "
            + "} "; }  
    }

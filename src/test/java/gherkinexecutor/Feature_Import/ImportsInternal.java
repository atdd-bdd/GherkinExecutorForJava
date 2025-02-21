package gherkinexecutor.Feature_Import;
import java.util.*;
import java.net.URL;
import java.util.regex.Pattern;
class ImportsInternal{
     URL myURL;
     Pattern myPattern;
     Weekday myWeekday;
     
    public static String toDataTypeString() {
        return "ImportsInternal {"
        +"URL " 
        +"Pattern " 
        +"Weekday " 
            + "} "; }  
    Imports toImports() {
        return new Imports(
        myURL.toString()
        ,myPattern.toString()
        ,myWeekday.toString()
        ); }
    public ImportsInternal(
        URL myURL
        ,Pattern myPattern
        ,Weekday myWeekday
        )  {
        this.myURL = myURL;
        this.myPattern = myPattern;
        this.myWeekday = myWeekday;
        }
    @Override
    public String toString() {
        return "ImportsInternal {"
        +"myURL = " + myURL + " "
        +"myPattern = " + myPattern + " "
        +"myWeekday = " + myWeekday + " "
            + "} "; }  
    }

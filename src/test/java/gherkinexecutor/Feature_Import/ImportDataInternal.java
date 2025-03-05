package gherkinexecutor.Feature_Import;
import java.util.*;
import java.util.regex.Pattern;
import java.math.BigInteger;
class ImportDataInternal{
     Pattern myPattern;
     Weekday myWeekday;
     BigInteger myBigInt;
     
    public static String toDataTypeString() {
        return "ImportDataInternal {"
        +"Pattern " 
        +"Weekday " 
        +"BigInteger " 
            + "} "; }  
    ImportData toImportData() {
        return new ImportData(
        myPattern.toString()
        ,myWeekday.toString()
        ,myBigInt.toString()
        ); }
    public ImportDataInternal(
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
        ImportDataInternal _ImportDataInternal = (ImportDataInternal) o;
         return 
                ( _ImportDataInternal.myPattern.equals(this.myPattern))
                 && ( _ImportDataInternal.myWeekday.equals(this.myWeekday))
                 && ( _ImportDataInternal.myBigInt.equals(this.myBigInt))
             ;  }
    @Override
    public String toString() {
        return "ImportDataInternal {"
        +"myPattern = " + myPattern + " "
        +"myWeekday = " + myWeekday + " "
        +"myBigInt = " + myBigInt + " "
            + "} " + "\n"; }  
    }

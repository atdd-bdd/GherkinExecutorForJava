package gherkinexecutor.Feature_Data_Definition_Error;
import java.util.*;
class ATestBadInternal{
     Integer anInt = Integer.valueOf("a");
     String aString = " ";
     Double aDouble = Double.valueOf("b");
     
    public static String toDataTypeString() {
        return "ATestBadInternal {"
        +"Integer " 
        +"String " 
        +"Double " 
            + "} "; }  
    ATestBad toATestBad() {
        return new ATestBad(
        String.valueOf(anInt)
        ,aString
        ,String.valueOf(aDouble)
        ); }
    public ATestBadInternal() { }
    public ATestBadInternal(
        Integer anInt
        ,String aString
        ,Double aDouble
        )  {
        this.anInt = anInt;
        this.aString = aString;
        this.aDouble = aDouble;
        }
    @Override
    public String toString() {
        return "ATestBadInternal {"
        +"anInt = " + anInt + " "
        +"aString = " + aString + " "
        +"aDouble = " + aDouble + " "
            + "} "; }  
    }

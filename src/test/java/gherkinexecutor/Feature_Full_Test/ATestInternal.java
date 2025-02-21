package gherkinexecutor.Feature_Full_Test;
import java.util.*;
class ATestInternal{
     Integer anInt;
     String aString;
     Double aDouble;
     
    public static String toDataTypeString() {
        return "ATestInternal {"
        +"Integer " 
        +"String " 
        +"Double " 
            + "} "; }  
    ATest0 toATest0() {
        return new ATest0(
        String.valueOf(anInt)
        ,aString
        ,String.valueOf(aDouble)
        ); }
    public ATestInternal(
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
        return "ATestInternal {"
        +"anInt = " + anInt + " "
        +"aString = " + aString + " "
        +"aDouble = " + aDouble + " "
            + "} "; }  
    }

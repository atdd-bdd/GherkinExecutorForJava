package gherkinexecutor.Feature_Data_Definition_Error;
import java.util.*;
class ATestBadInternal{
     Integer anInt;
     String aString;
     Double aDouble;
     
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
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ATestBadInternal _ATestBadInternal = (ATestBadInternal) o;
         return 
                ( _ATestBadInternal.anInt.equals(this.anInt))
                 && ( _ATestBadInternal.aString.equals(this.aString))
                 && ( _ATestBadInternal.aDouble.equals(this.aDouble))
             ;  }
    @Override
    public String toString() {
        return "ATestBadInternal {"
        +"anInt = " + anInt + " "
        +"aString = " + aString + " "
        +"aDouble = " + aDouble + " "
            + "} " + "\n"; }  
    }

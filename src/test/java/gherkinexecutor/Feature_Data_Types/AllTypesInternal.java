package gherkinexecutor.Feature_Data_Types;
import java.util.*;
class AllTypesInternal{
     int anInt;
     Double aDouble;
     Character aChar;
     char achar;
     
    public static String toDataTypeString() {
        return "AllTypesInternal {"
        +"int " 
        +"Double " 
        +"Character " 
        +"char " 
            + "} "; }  
    AllTypes toAllTypes() {
        return new AllTypes(
        String.valueOf(anInt)
        ,String.valueOf(aDouble)
        ,String.valueOf(aChar)
        ,String.valueOf(achar)
        ); }
    public AllTypesInternal(
        int anInt
        ,Double aDouble
        ,Character aChar
        ,char achar
        )  {
        this.anInt = anInt;
        this.aDouble = aDouble;
        this.aChar = aChar;
        this.achar = achar;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllTypesInternal _AllTypesInternal = (AllTypesInternal) o;
         return 
                ( _AllTypesInternal.anInt == (this.anInt))
                 && ( _AllTypesInternal.aDouble.equals(this.aDouble))
                 && ( _AllTypesInternal.aChar.equals(this.aChar))
                 && ( _AllTypesInternal.achar == (this.achar))
             ;  }
    @Override
    public String toString() {
        return "AllTypesInternal {"
        +"anInt = " + anInt + " "
        +"aDouble = " + aDouble + " "
        +"aChar = " + aChar + " "
        +"achar = " + achar + " "
            + "} " + "\n"; }  
    }

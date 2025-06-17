package gherkinexecutor.Feature_Data_Types;
import java.util.*;
//noinspection CanBeFinal
//noinspection UnusedImports
@SuppressWarnings({"unused", "EnhancedSwitchMigration", "ClassCanBeRecord", "NewClassNamingConvention", "RedundantSuppression"})
class SomeTypesInternal{
     int anInt;
     Double aDouble;
     Character aChar;
     char achar;
     
    public static String toDataTypeString() {
        return "SomeTypesInternal {"
        +"int " 
        +"Double " 
        +"Character " 
        +"char " 
            + "} "; }  
    SomeTypes toSomeTypes() {
        return new SomeTypes(
        String.valueOf(anInt)
        ,String.valueOf(aDouble)
        ,String.valueOf(aChar)
        ,String.valueOf(achar)
        ); }
    public SomeTypesInternal(
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
        SomeTypesInternal _SomeTypesInternal = (SomeTypesInternal) o;
         return 
                ( _SomeTypesInternal.anInt == (this.anInt))
                 && ( _SomeTypesInternal.aDouble.equals(this.aDouble))
                 && ( _SomeTypesInternal.aChar.equals(this.aChar))
                 && ( _SomeTypesInternal.achar == (this.achar))
             ;  }
        @Override
        public String toString() {
            return "SomeTypesInternal {"
             +"anInt = " + anInt + " "
             +"aDouble = " + aDouble + " "
             +"aChar = " + aChar + " "
             +"achar = " + achar + " "
             + "} " + "\n"; }

    }

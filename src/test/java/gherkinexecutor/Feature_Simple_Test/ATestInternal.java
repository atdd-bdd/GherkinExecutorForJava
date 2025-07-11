package gherkinexecutor.Feature_Simple_Test;
import java.util.*;
//noinspection CanBeFinal
//noinspection UnusedImports
@SuppressWarnings({"unused", "EnhancedSwitchMigration", "ClassCanBeRecord", "NewClassNamingConvention", "RedundantSuppression"})
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
    ATest toATest() {
        return new ATest(
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
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ATestInternal _ATestInternal = (ATestInternal) o;
         return 
                ( _ATestInternal.anInt.equals(this.anInt))
                 && ( _ATestInternal.aString.equals(this.aString))
                 && ( _ATestInternal.aDouble.equals(this.aDouble))
             ;  }
        @Override
        public String toString() {
            return "ATestInternal {"
             +"anInt = " + anInt + " "
             +"aString = " + aString + " "
             +"aDouble = " + aDouble + " "
             + "} " + "\n"; }

    }

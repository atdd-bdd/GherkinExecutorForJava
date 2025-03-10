package gherkinexecutor.Feature_Full_Test;
import java.util.*;
import java.util.regex.Pattern;
import java.math.BigInteger;
class SimpleClassInternal{
     Integer anInt;
     String aString;
     
    public static String toDataTypeString() {
        return "SimpleClassInternal {"
        +"Integer " 
        +"String " 
            + "} "; }  
    SimpleClass toSimpleClass() {
        return new SimpleClass(
        String.valueOf(anInt)
        ,aString
        ); }
    public SimpleClassInternal(
        Integer anInt
        ,String aString
        )  {
        this.anInt = anInt;
        this.aString = aString;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleClassInternal _SimpleClassInternal = (SimpleClassInternal) o;
         return 
                ( _SimpleClassInternal.anInt.equals(this.anInt))
                 && ( _SimpleClassInternal.aString.equals(this.aString))
             ;  }
    @Override
    public String toString() {
        return "SimpleClassInternal {"
        +"anInt = " + anInt + " "
        +"aString = " + aString + " "
            + "} " + "\n"; }  
    }

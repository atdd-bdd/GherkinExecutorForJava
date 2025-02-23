package gherkinexecutor.Feature_Data_Definition;
import java.util.*;

class Existing{
     int aValue;
     String bValue;
     double cValue;
     
    public static String toDataTypeString() {
        return "Existing {"
        +"int " 
        +"String " 
        +"double " 
            + "} "; }  
    TestIn toTestIn() {
        return new TestIn(
        String.valueOf(aValue)
        ,bValue
        ,String.valueOf(cValue)
        ); }
    public Existing(
        int aValue
        ,String bValue
        ,double cValue
        )  {
        this.aValue = aValue;
        this.bValue = bValue;
        this.cValue = cValue;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Existing _Existing = (Existing) o;
         return 
                ( _Existing.aValue == (this.aValue))
                 && ( _Existing.bValue == (this.bValue))
                 && ( _Existing.cValue == (this.cValue))
             ;  }
    @Override
    public String toString() {
        return "Existing {"
        +"aValue = " + aValue + " "
        +"bValue = " + bValue + " "
        +"cValue = " + cValue + " "
            + "} "; }  
    }

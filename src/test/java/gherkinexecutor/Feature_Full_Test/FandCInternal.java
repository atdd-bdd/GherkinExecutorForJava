package gherkinexecutor.Feature_Full_Test;
import java.util.*;
import java.util.regex.Pattern;
import java.math.BigInteger;
class FandCInternal{
     Integer f;
     Integer c;
     String notes;
     
    public static String toDataTypeString() {
        return "FandCInternal {"
        +"Integer " 
        +"Integer " 
        +"String " 
            + "} "; }  
    FandC toFandC() {
        return new FandC(
        String.valueOf(f)
        ,String.valueOf(c)
        ,notes
        ); }
    public FandCInternal(
        Integer f
        ,Integer c
        ,String notes
        )  {
        this.f = f;
        this.c = c;
        this.notes = notes;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FandCInternal _FandCInternal = (FandCInternal) o;
         return 
                ( _FandCInternal.f.equals(this.f))
                 && ( _FandCInternal.c.equals(this.c))
                 && ( _FandCInternal.notes.equals(this.notes))
             ;  }
    @Override
    public String toString() {
        return "FandCInternal {"
        +"f = " + f + " "
        +"c = " + c + " "
        +"notes = " + notes + " "
            + "} " + "\n"; }  
    }

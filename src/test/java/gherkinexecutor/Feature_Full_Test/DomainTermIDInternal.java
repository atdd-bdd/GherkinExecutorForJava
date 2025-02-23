package gherkinexecutor.Feature_Full_Test;
import java.util.*;
class DomainTermIDInternal{
     String value;
     Boolean valid;
     String notes;
     
    public static String toDataTypeString() {
        return "DomainTermIDInternal {"
        +"String " 
        +"Boolean " 
        +"String " 
            + "} "; }  
    DomainTermID toDomainTermID() {
        return new DomainTermID(
        value
        ,String.valueOf(valid)
        ,notes
        ); }
    public DomainTermIDInternal(
        String value
        ,Boolean valid
        ,String notes
        )  {
        this.value = value;
        this.valid = valid;
        this.notes = notes;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DomainTermIDInternal _DomainTermIDInternal = (DomainTermIDInternal) o;
         return 
                ( _DomainTermIDInternal.value.equals(this.value))
                 && ( _DomainTermIDInternal.valid.equals(this.valid))
                 && ( _DomainTermIDInternal.notes.equals(this.notes))
             ;  }
    @Override
    public String toString() {
        return "DomainTermIDInternal {"
        +"value = " + value + " "
        +"valid = " + valid + " "
        +"notes = " + notes + " "
            + "} "; }  
    }

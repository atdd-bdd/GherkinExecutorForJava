package gherkinexecutor.Feature_Full_Test;
import java.util.*;
class DomainTermIDInternal{
     String value = "0";
     Boolean valid = Boolean.valueOf("false");
     String notes = "";
     
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
    public DomainTermIDInternal() { }
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
    public String toString() {
        return "DomainTermIDInternal {"
        +"value = " + value + " "
        +"valid = " + valid + " "
        +"notes = " + notes + " "
            + "} "; }  
    }

package gherkinexecutor.Feature_Examples;
import java.util.*;
import java.net.URL;
import java.util.regex.Pattern;
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
    public String toString() {
        return "DomainTermIDInternal {"
        +"value = " + value + " "
        +"valid = " + valid + " "
        +"notes = " + notes + " "
            + "} "; }  
    }

package gherkinexecutor.Feature_Full_Test;
import java.util.*;
class DomainTermID{
    String value = "0";
    String valid = "false";
    String notes = "";
    public DomainTermID() { }
    public DomainTermID(
        String value
        ,String valid
        ,String notes
        ){
        this.value = value;
        this.valid = valid;
        this.notes = notes;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DomainTermID _DomainTermID = (DomainTermID) o;
         if (
             !this.value.equals("?DNC?")
                && !_DomainTermID.value.equals("?DNC?"))
                return ( _DomainTermID.value.equals(this.value));
         if (
             !this.valid.equals("?DNC?")
                && !_DomainTermID.valid.equals("?DNC?"))
                return ( _DomainTermID.valid.equals(this.valid));
         if (
             !this.notes.equals("?DNC?")
                && !_DomainTermID.notes.equals("?DNC?"))
                return ( _DomainTermID.notes.equals(this.notes));
             return true;  }
    public static class Builder {
        private String value = "0";
        private String valid = "false";
        private String notes = "";
        public Builder value(String value) {
            this.value = value;
            return this;
            }
        public Builder valid(String valid) {
            this.valid = valid;
            return this;
            }
        public Builder notes(String notes) {
            this.notes = notes;
            return this;
            }
        public Builder  setCompare() {
            value = "?DNC?";
            valid = "?DNC?";
            notes = "?DNC?";
            return this;
            }
        public DomainTermID build(){
             return new DomainTermID(
                 value
                 ,valid
                 ,notes
                );   } 
        } 
    @Override
    public String toString() {
        return "DomainTermID {"
        +"value = " + value + " "
        +"valid = " + valid + " "
        +"notes = " + notes + " "
            + "} "; }  
    DomainTermIDInternal toDomainTermIDInternal() throws Exception {
        return new DomainTermIDInternal(
         value
        , Boolean.valueOf(valid)
        , notes
        ); }
    }

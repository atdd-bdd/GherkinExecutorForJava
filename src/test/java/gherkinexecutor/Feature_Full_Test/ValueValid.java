package gherkinexecutor.Feature_Full_Test;
import java.util.*;
import java.util.regex.Pattern;
import java.math.BigInteger;
import java.util.regex.Pattern;
import java.math.BigInteger;
class ValueValid{
    String value = "0";
    String valid = "false";
    String notes = "";
    public ValueValid() { }
    public ValueValid(
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
        ValueValid _ValueValid = (ValueValid) o;
         if (
             !this.value.equals("?DNC?")
                && !_ValueValid.value.equals("?DNC?"))
                return ( _ValueValid.value.equals(this.value));
         if (
             !this.valid.equals("?DNC?")
                && !_ValueValid.valid.equals("?DNC?"))
                return ( _ValueValid.valid.equals(this.valid));
         if (
             !this.notes.equals("?DNC?")
                && !_ValueValid.notes.equals("?DNC?"))
                return ( _ValueValid.notes.equals(this.notes));
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
        public ValueValid build(){
             return new ValueValid(
                 value
                 ,valid
                 ,notes
                );   } 
        } 
    @Override
    public String toString() {
        return "ValueValid {"
        +"value = " + value + " "
        +"valid = " + valid + " "
        +"notes = " + notes + " "
            + "} "; }  
    ValueValidInternal toValueValidInternal() throws IllegalArgumentException {
        return new ValueValidInternal(
         value
        , Boolean.valueOf(valid)
        , notes
        ); }
    }

package gherkinexecutor.Feature_Full_Test;
import java.util.*;
import java.util.regex.Pattern;
import java.math.BigInteger;
class TemperatureCalculation{
    String f = "0";
    String c = "0";
    String notes = "";
    public TemperatureCalculation() { }
    public TemperatureCalculation(
        String f
        ,String c
        ,String notes
        ){
        this.f = f;
        this.c = c;
        this.notes = notes;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
             return false;
        TemperatureCalculation _TemperatureCalculation = (TemperatureCalculation) o;
            boolean result = true;
         if (
             !this.f.equals("?DNC?")
                && !_TemperatureCalculation.f.equals("?DNC?"))
                if (! _TemperatureCalculation.f.equals(this.f)) result = false;
         if (
             !this.c.equals("?DNC?")
                && !_TemperatureCalculation.c.equals("?DNC?"))
                if (! _TemperatureCalculation.c.equals(this.c)) result = false;
         if (
             !this.notes.equals("?DNC?")
                && !_TemperatureCalculation.notes.equals("?DNC?"))
                if (! _TemperatureCalculation.notes.equals(this.notes)) result = false;
             return result;  }
    public static class Builder {
        private String f = "0";
        private String c = "0";
        private String notes = "";
        public Builder f(String f) {
            this.f = f;
            return this;
            }
        public Builder c(String c) {
            this.c = c;
            return this;
            }
        public Builder notes(String notes) {
            this.notes = notes;
            return this;
            }
        public Builder  setCompare() {
            f = "?DNC?";
            c = "?DNC?";
            notes = "?DNC?";
            return this;
            }
        public TemperatureCalculation build(){
             return new TemperatureCalculation(
                 f
                 ,c
                 ,notes
                );   } 
        } 
    @Override
    public String toString() {
        return "TemperatureCalculation {"
        +"f = " + f + " "
        +"c = " + c + " "
        +"notes = " + notes + " "
            + "} " + "\n"; }  
    TemperatureCalculationInternal toTemperatureCalculationInternal() {
        return new TemperatureCalculationInternal(
         Integer.valueOf(f)
        , Integer.valueOf(c)
        , notes
        ); }
    }

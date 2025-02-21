package gherkinexecutor.Feature_Full_Test;
import java.util.*;
class TemperatureCalculationInternal{
     Integer f;
     Integer c;
     String notes;
     
    public static String toDataTypeString() {
        return "TemperatureCalculationInternal {"
        +"Integer " 
        +"Integer " 
        +"String " 
            + "} "; }  
    TemperatureCalculation toTemperatureCalculation() {
        return new TemperatureCalculation(
        String.valueOf(f)
        ,String.valueOf(c)
        ,notes
        ); }
    public TemperatureCalculationInternal(
        Integer f
        ,Integer c
        ,String notes
        )  {
        this.f = f;
        this.c = c;
        this.notes = notes;
        }
    @Override
    public String toString() {
        return "TemperatureCalculationInternal {"
        +"f = " + f + " "
        +"c = " + c + " "
        +"notes = " + notes + " "
            + "} "; }  
    }

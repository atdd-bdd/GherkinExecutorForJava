package gherkinexecutor.Feature_Examples;
import java.util.*;
class TemperatureCalculationInternal{
     Integer f = Integer.valueOf("0");
     Integer c = Integer.valueOf("0");
     String notes = "";
     
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
    public TemperatureCalculationInternal() { }
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

package gherkinexecutor.Feature_Calculator;
import java.util.*;
class CalculationInternal{
     int number1;
     int number2;
     int result;
     
    public static String toDataTypeString() {
        return "CalculationInternal {"
        +"int " 
        +"int " 
        +"int " 
            + "} "; }  
    Calculation toCalculation() {
        return new Calculation(
        String.valueOf(number1)
        ,String.valueOf(number2)
        ,String.valueOf(result)
        ); }
    public CalculationInternal(
        int number1
        ,int number2
        ,int result
        )  {
        this.number1 = number1;
        this.number2 = number2;
        this.result = result;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalculationInternal _CalculationInternal = (CalculationInternal) o;
         return 
                ( _CalculationInternal.number1 == (this.number1))
                 && ( _CalculationInternal.number2 == (this.number2))
                 && ( _CalculationInternal.result == (this.result))
             ;  }
    @Override
    public String toString() {
        return "CalculationInternal {"
        +"number1 = " + number1 + " "
        +"number2 = " + number2 + " "
        +"result = " + result + " "
            + "} " + "\n"; }  
    }

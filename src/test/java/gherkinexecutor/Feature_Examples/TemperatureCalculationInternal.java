package gherkinexecutor.Feature_Examples;
class TemperatureCalculationInternal{
     Integer f = Integer.valueOf("0");
     Integer c = Integer.valueOf("0");
     String notes = "";
     
    TemperatureCalculation toTemperatureCalculation() {
        return new TemperatureCalculation(
        f.toString()
        ,c.toString()
        ,notes.toString()
        ); }
    public TemperatureCalculationInternal(
        Integer f
        ,Integer c
        ,String notes
        ){
        this.f = Integer.valueOf("0");
        this.c = Integer.valueOf("0");
        this.notes = "";
        }
    @Override
    public String toString() {
        return "TemperatureCalculationInternal {"
        +"f = " + f + " "
        +"c = " + c + " "
        +"notes = " + notes + " "
            + "} "; }  
    }

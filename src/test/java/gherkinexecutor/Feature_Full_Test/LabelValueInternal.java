package gherkinexecutor.Feature_Full_Test;
class LabelValueInternal{
     String label = "";
     Integer value = Integer.valueOf("0");
     
    LabelValue toLabelValue() {
        return new LabelValue(
        label
        ,String.valueOf(value)
        ); }
    public LabelValueInternal(
        String label
        ,Integer value
        ){
        this.label = label;
        this.value = value;
        }
    @Override
    public String toString() {
        return "LabelValueInternal {"
        +"label = " + label + " "
        +"value = " + value + " "
            + "} "; }  
    }

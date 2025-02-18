package gherkinexecutor.Feature_Full_Test;
class LabelValueInternal{
     String label = "";
     Integer value = Integer.valueOf("0");
     
    LabelValue toLabelValue() {
        return new LabelValue(
        label.toString()
        ,value.toString()
        ); }
    public LabelValueInternal(
        String label
        ,Integer value
        ){
        this.label = "";
        this.value = Integer.valueOf("0");
        }
    @Override
    public String toString() {
        return "LabelValueInternal {"
        +"label = " + label + " "
        +"value = " + value + " "
            + "} "; }  
    }

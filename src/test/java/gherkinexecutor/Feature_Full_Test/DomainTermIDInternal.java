package gherkinexecutor.Feature_Full_Test;
class DomainTermIDInternal{
     String value = "0";
     Boolean valid = Boolean.valueOf("false");
     String notes = "";
     
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
        ){
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

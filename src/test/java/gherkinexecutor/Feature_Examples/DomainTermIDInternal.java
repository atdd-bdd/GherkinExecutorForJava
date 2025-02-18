package gherkinexecutor.Feature_Examples;
class DomainTermIDInternal{
     String value = "0";
     Boolean valid = Boolean.valueOf("false");
     String notes = "";
     
    DomainTermID toDomainTermID() {
        return new DomainTermID(
        value.toString()
        ,valid.toString()
        ,notes.toString()
        ); }
    public DomainTermIDInternal(
        String value
        ,Boolean valid
        ,String notes
        ){
        this.value = "0";
        this.valid = Boolean.valueOf("false");
        this.notes = "";
        }
    @Override
    public String toString() {
        return "DomainTermIDInternal {"
        +"value = " + value + " "
        +"valid = " + valid + " "
        +"notes = " + notes + " "
            + "} "; }  
    }

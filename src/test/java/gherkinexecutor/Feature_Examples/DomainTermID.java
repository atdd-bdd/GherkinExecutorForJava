package gherkinexecutor.Feature_Examples;
class DomainTermID{
    String value = "0";
    String valid = "false";
    String notes = "";
    public DomainTermID(
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
            DomainTermID _DomainTermID = (DomainTermID) o;
            if (
            !this.value.equals("?DNC?")
            && !_DomainTermID.value.equals("?DNC?"))
                if (! _DomainTermID.value.equals(this.value))
                     return false;
            if (
            !this.valid.equals("?DNC?")
            && !_DomainTermID.valid.equals("?DNC?"))
                if (! _DomainTermID.valid.equals(this.valid))
                     return false;
            if (
            !this.notes.equals("?DNC?")
            && !_DomainTermID.notes.equals("?DNC?"))
                if (! _DomainTermID.notes.equals(this.notes))
                     return false;
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
        public DomainTermID build(){
             return new DomainTermID(
                 value
                 ,valid
                 ,notes
                );   } 
        } 
    @Override
    public String toString() {
        return "DomainTermID {"
        +"value = " + value + " "
        +"valid = " + valid + " "
        +"notes = " + notes + " "
            + "} "; }  
    DomainTermIDInternal toDomainTermIDInternal() {
        return new DomainTermIDInternal(
         value
        , Boolean.valueOf(valid)
        , notes
        ); }
    }

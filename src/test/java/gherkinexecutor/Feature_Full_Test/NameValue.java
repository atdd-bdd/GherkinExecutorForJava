package gherkinexecutor.Feature_Full_Test;
class NameValue{
    String iD = "";
    String value = "0";
    public NameValue(
        String iD
        ,String value
        ){
        this.iD = iD;
        this.value = value;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
            if (o == null || getClass() != o.getClass())
                return false;
            NameValue _NameValue = (NameValue) o;
            if (
                !this.iD.equals("?DNC?")
                && !_NameValue.iD.equals("?DNC?"))
                    if (! _NameValue.iD.equals(this.iD))
                        return false;
            if (
                !this.value.equals("?DNC?")
                && !_NameValue.value.equals("?DNC?"))
                    if (! _NameValue.value.equals(this.value))
                        return false;
             return true;  }
    public static class Builder {
        private String iD = "";
        private String value = "0";
        public Builder iD(String iD) {
            this.iD = iD;
            return this;
            }
        public Builder value(String value) {
            this.value = value;
            return this;
            }
        public Builder  setCompare() {
        iD = "?DNC?";
        value = "?DNC?";
            return this;
            }
        public NameValue build(){
             return new NameValue(
                 iD
                 ,value
                );   } 
        } 
    @Override
    public String toString() {
        return "NameValue {"
        +"iD = " + iD + " "
        +"value = " + value + " "
            + "} "; }  
    }

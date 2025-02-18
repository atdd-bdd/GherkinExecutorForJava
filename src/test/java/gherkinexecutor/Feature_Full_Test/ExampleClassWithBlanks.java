package gherkinexecutor.Feature_Full_Test;
class ExampleClassWithBlanks{
    String field_1 = "y";
    String field_2 = "x";
    public ExampleClassWithBlanks(
        String field_1
        ,String field_2
        ){
        this.field_1 = field_1;
        this.field_2 = field_2;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ExampleClassWithBlanks _ExampleClassWithBlanks = (ExampleClassWithBlanks) o;
            if (
            !this.field_1.equals("?DNC?")
            && !_ExampleClassWithBlanks.field_1.equals("?DNC?"))
                if (! _ExampleClassWithBlanks.field_1.equals(this.field_1))
                     return false;
            if (
            !this.field_2.equals("?DNC?")
            && !_ExampleClassWithBlanks.field_2.equals("?DNC?"))
                if (! _ExampleClassWithBlanks.field_2.equals(this.field_2))
                     return false;
         return true;  }
    public static class Builder {
        private String field_1 = "y";
        private String field_2 = "x";
        public Builder field_1(String field_1) {
            this.field_1 = field_1;
            return this;
            }
        public Builder field_2(String field_2) {
            this.field_2 = field_2;
            return this;
            }
        public ExampleClassWithBlanks build(){
             return new ExampleClassWithBlanks(
                 field_1
                 ,field_2
                );   } 
        } 
    @Override
    public String toString() {
        return "ExampleClassWithBlanks {"
        +"field_1 = " + field_1 + " "
        +"field_2 = " + field_2 + " "
            + "} "; }  

package gherkinexecutor.Feature_Tables_and_Strings;
import java.util.*;
class ExampleClassWithBlanks{
    String field_1 = " ";
    String field_2 = " ";
    public ExampleClassWithBlanks() { }
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
                return ( _ExampleClassWithBlanks.field_1.equals(this.field_1));
         if (
             !this.field_2.equals("?DNC?")
                && !_ExampleClassWithBlanks.field_2.equals("?DNC?"))
                return ( _ExampleClassWithBlanks.field_2.equals(this.field_2));
             return true;  }
    public static class Builder {
        private String field_1 = " ";
        private String field_2 = " ";
        public Builder field_1(String field_1) {
            this.field_1 = field_1;
            return this;
            }
        public Builder field_2(String field_2) {
            this.field_2 = field_2;
            return this;
            }
        public Builder  setCompare() {
            field_1 = "?DNC?";
            field_2 = "?DNC?";
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
    }

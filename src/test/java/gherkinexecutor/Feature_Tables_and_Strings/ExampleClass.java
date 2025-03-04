package gherkinexecutor.Feature_Tables_and_Strings;
import java.util.*;
class ExampleClass{
    String fieldA = "y";
    String fieldB = "x";
    public ExampleClass() { }
    public ExampleClass(
        String fieldA
        ,String fieldB
        ){
        this.fieldA = fieldA;
        this.fieldB = fieldB;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
             return false;
        ExampleClass _ExampleClass = (ExampleClass) o;
            boolean result = true;
         if (
             !this.fieldA.equals("?DNC?")
                && !_ExampleClass.fieldA.equals("?DNC?"))
                if (! _ExampleClass.fieldA.equals(this.fieldA)) result = false;
         if (
             !this.fieldB.equals("?DNC?")
                && !_ExampleClass.fieldB.equals("?DNC?"))
                if (! _ExampleClass.fieldB.equals(this.fieldB)) result = false;
             return result;  }
    public static class Builder {
        private String fieldA = "y";
        private String fieldB = "x";
        public Builder fieldA(String fieldA) {
            this.fieldA = fieldA;
            return this;
            }
        public Builder fieldB(String fieldB) {
            this.fieldB = fieldB;
            return this;
            }
        public Builder  setCompare() {
            fieldA = "?DNC?";
            fieldB = "?DNC?";
            return this;
            }
        public ExampleClass build(){
             return new ExampleClass(
                 fieldA
                 ,fieldB
                );   } 
        } 
    @Override
    public String toString() {
        return "ExampleClass {"
        +"fieldA = " + fieldA + " "
        +"fieldB = " + fieldB + " "
            + "} " + "\n"; }  
    }

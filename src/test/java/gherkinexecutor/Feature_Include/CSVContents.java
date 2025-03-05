package gherkinexecutor.Feature_Include;
import java.util.*;
class CSVContents{
    String a = "";
    String b = "";
    String c = "";
    public CSVContents() { }
    public CSVContents(
        String a
        ,String b
        ,String c
        ){
        this.a = a;
        this.b = b;
        this.c = c;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
             return false;
        CSVContents _CSVContents = (CSVContents) o;
            boolean result = true;
         if (
             !this.a.equals("?DNC?")
                && !_CSVContents.a.equals("?DNC?"))
                if (! _CSVContents.a.equals(this.a)) result = false;
         if (
             !this.b.equals("?DNC?")
                && !_CSVContents.b.equals("?DNC?"))
                if (! _CSVContents.b.equals(this.b)) result = false;
         if (
             !this.c.equals("?DNC?")
                && !_CSVContents.c.equals("?DNC?"))
                if (! _CSVContents.c.equals(this.c)) result = false;
             return result;  }
    public static class Builder {
        private String a = "";
        private String b = "";
        private String c = "";
        public Builder a(String a) {
            this.a = a;
            return this;
            }
        public Builder b(String b) {
            this.b = b;
            return this;
            }
        public Builder c(String c) {
            this.c = c;
            return this;
            }
        public Builder  setCompare() {
            a = "?DNC?";
            b = "?DNC?";
            c = "?DNC?";
            return this;
            }
        public CSVContents build(){
             return new CSVContents(
                 a
                 ,b
                 ,c
                );   } 
        } 
    @Override
    public String toString() {
        return "CSVContents {"
        +"a = " + a + " "
        +"b = " + b + " "
        +"c = " + c + " "
            + "} " + "\n"; }  
    }

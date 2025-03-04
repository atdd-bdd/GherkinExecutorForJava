package gherkinexecutor.Feature_Gherkin_Translator_Full_Test;
import java.util.*;
class FileNames{
    String expected = "NoFileName";
    String actual = "NoFileName";
    public FileNames() { }
    public FileNames(
        String expected
        ,String actual
        ){
        this.expected = expected;
        this.actual = actual;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
             return false;
        FileNames _FileNames = (FileNames) o;
            boolean result = true;
         if (
             !this.expected.equals("?DNC?")
                && !_FileNames.expected.equals("?DNC?"))
                if (! _FileNames.expected.equals(this.expected)) result = false;
         if (
             !this.actual.equals("?DNC?")
                && !_FileNames.actual.equals("?DNC?"))
                if (! _FileNames.actual.equals(this.actual)) result = false;
             return result;  }
    public static class Builder {
        private String expected = "NoFileName";
        private String actual = "NoFileName";
        public Builder expected(String expected) {
            this.expected = expected;
            return this;
            }
        public Builder actual(String actual) {
            this.actual = actual;
            return this;
            }
        public Builder  setCompare() {
            expected = "?DNC?";
            actual = "?DNC?";
            return this;
            }
        public FileNames build(){
             return new FileNames(
                 expected
                 ,actual
                );   } 
        } 
    @Override
    public String toString() {
        return "FileNames {"
        +"expected = " + expected + " "
        +"actual = " + actual + " "
            + "} " + "\n"; }  
    }

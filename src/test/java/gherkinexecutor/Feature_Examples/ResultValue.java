package gherkinexecutor.Feature_Examples;
import java.util.*;
class ResultValue{
    String sum = "";
    public ResultValue() { }
    public ResultValue(
        String sum
        ){
        this.sum = sum;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultValue _ResultValue = (ResultValue) o;
         if (
             !this.sum.equals("?DNC?")
                && !_ResultValue.sum.equals("?DNC?"))
                return ( _ResultValue.sum.equals(this.sum));
             return true;  }
    public static class Builder {
        private String sum = "";
        public Builder sum(String sum) {
            this.sum = sum;
            return this;
            }
        public Builder  setCompare() {
            sum = "?DNC?";
            return this;
            }
        public ResultValue build(){
             return new ResultValue(
                 sum
                );   } 
        } 
    @Override
    public String toString() {
        return "ResultValue {"
        +"sum = " + sum + " "
            + "} "; }  
    ResultValueInternal toResultValueInternal() throws IllegalArgumentException {
        return new ResultValueInternal(
         Integer.valueOf(sum)
        ); }
    }

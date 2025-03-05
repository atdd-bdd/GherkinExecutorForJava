package gherkinexecutor.testfeaturepackage.Feature_Test_Feature;
import java.util.*;
class Something{
    String in = "0";
    String out = "A";
    public Something() { }
    public Something(
        String in
        ,String out
        ){
        this.in = in;
        this.out = out;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
             return false;
        Something _Something = (Something) o;
            boolean result = true;
         if (
             !this.in.equals("?DNC?")
                && !_Something.in.equals("?DNC?"))
                if (! _Something.in.equals(this.in)) result = false;
         if (
             !this.out.equals("?DNC?")
                && !_Something.out.equals("?DNC?"))
                if (! _Something.out.equals(this.out)) result = false;
             return result;  }
    public static class Builder {
        private String in = "0";
        private String out = "A";
        public Builder in(String in) {
            this.in = in;
            return this;
            }
        public Builder out(String out) {
            this.out = out;
            return this;
            }
        public Builder  setCompare() {
            in = "?DNC?";
            out = "?DNC?";
            return this;
            }
        public Something build(){
             return new Something(
                 in
                 ,out
                );   } 
        } 
    @Override
    public String toString() {
        return "Something {"
        +"in = " + in + " "
        +"out = " + out + " "
            + "} " + "\n"; }  
    }

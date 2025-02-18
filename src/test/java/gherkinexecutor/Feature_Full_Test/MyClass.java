package gherkinexecutor.Feature_Full_Test;
class MyClass{
    String one = "aaa";
    String two = "1";
    public MyClass(
        String one
        ,String two
        ){
        this.one = one;
        this.two = two;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyClass _MyClass = (MyClass) o;
            if (
            !this.one.equals("?DNC?")
            && !_MyClass.one.equals("?DNC?"))
                if (! _MyClass.one.equals(this.one))
                     return false;
            if (
            !this.two.equals("?DNC?")
            && !_MyClass.two.equals("?DNC?"))
                if (! _MyClass.two.equals(this.two))
                     return false;
         return true;  }
    public static class Builder {
        private String one = "aaa";
        private String two = "1";
        public Builder one(String one) {
            this.one = one;
            return this;
            }
        public Builder two(String two) {
            this.two = two;
            return this;
            }
        public MyClass build(){
             return new MyClass(
                 one
                 ,two
                );   } 
        } 
    @Override
    public String toString() {
        return "MyClass {"
        +"one = " + one + " "
        +"two = " + two + " "
            + "} "; }  
    InternalClass toInternalClass() {
        return new InternalClass(
         one
        , two
        ); }
    }

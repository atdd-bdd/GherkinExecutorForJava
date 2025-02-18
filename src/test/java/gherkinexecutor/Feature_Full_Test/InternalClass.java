package gherkinexecutor.Feature_Full_Test;
class InternalClass{
     String one = "aaa";
     Int two = "1";
     
    MyClass toMyClass() {
        return new MyClass(
        one.toString()
        ,two.toString()
        ); }
    public InternalClass(
        String one
        ,Int two
        ){
        this.one = "aaa";
        this.two = "1";
        }
    @Override
    public String toString() {
        return "InternalClass {"
        +"one = " + one + " "
        +"two = " + two + " "
            + "} "; }  
    }

package gherkinexecutor.Feature_Data_Definition;
class InternalClass{
     String one = "aaa";
     Integer two = Integer.valueOf("1");
     
    MyClass toMyClass() {
        return new MyClass(
        one
        ,String.valueOf(two)
        ); }
    public InternalClass(
        String one
        ,Integer two
        ){
        this.one = one;
        this.two = two;
        }
    @Override
    public String toString() {
        return "InternalClass {"
        +"one = " + one + " "
        +"two = " + two + " "
            + "} "; }  
    }

package gherkinexecutor.Feature_Full_Test;
class ATestInternal{
     Int anInt = "0";
     String aString = " ";
     Double aDouble = Double.valueOf("1.2");
     
    ATest toATest() {
        return new ATest(
        anInt.toString()
        ,aString.toString()
        ,aDouble.toString()
        ); }
    public ATestInternal(
        Int anInt
        ,String aString
        ,Double aDouble
        ){
        this.anInt = "0";
        this.aString = " ";
        this.aDouble = Double.valueOf("1.2");
        }
    @Override
    public String toString() {
        return "ATestInternal {"
        +"anInt = " + anInt + " "
        +"aString = " + aString + " "
        +"aDouble = " + aDouble + " "
            + "} "; }  
    }

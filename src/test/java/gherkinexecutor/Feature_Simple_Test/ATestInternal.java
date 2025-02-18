package gherkinexecutor.Feature_Simple_Test;
class ATestInternal{
     Integer anInt = Integer.valueOf("0");
     String aString = " ";
     Double aDouble = Double.valueOf("1.2");
     
    ATest toATest() {
        return new ATest(
        anInt.toString()
        ,aString.toString()
        ,aDouble.toString()
        ); }
    public ATestInternal(
        Integer anInt
        ,String aString
        ,Double aDouble
        ){
        this.anInt = Integer.valueOf("0");
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

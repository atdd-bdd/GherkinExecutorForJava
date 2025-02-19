package gherkinexecutor.Feature_Full_Test;
class ATestInternal{
     Integer anInt = Integer.valueOf("0");
     String aString = "^";
     Double aDouble = Double.valueOf("4.0");
     
    ATest toATest() {
        return new ATest(
        String.valueOf(anInt)
        ,aString
        ,String.valueOf(aDouble)
        ); }
    public ATestInternal(
        Integer anInt
        ,String aString
        ,Double aDouble
        ){
        this.anInt = anInt;
        this.aString = aString;
        this.aDouble = aDouble;
        }
    @Override
    public String toString() {
        return "ATestInternal {"
        +"anInt = " + anInt + " "
        +"aString = " + aString + " "
        +"aDouble = " + aDouble + " "
            + "} "; }  
    }

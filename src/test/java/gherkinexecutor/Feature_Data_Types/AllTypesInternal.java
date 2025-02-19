package gherkinexecutor.Feature_Data_Types;
class AllTypesInternal{
     Integer anInt = Integer.valueOf("0");
     double aDouble = Double.parseDouble("0.0");
     Character aChar = Character.valueOf( "x".length() > 0 ?"x".charAt(0) : ' ');
     char achar = ( "y".length() > 0 ?"y".charAt(0) : ' ');
     
    AllTypes toAllTypes() {
        return new AllTypes(
        String.valueOf(anInt)
        ,String.valueOf(aDouble)
        ,String.valueOf(aChar)
        ,String.valueOf(achar)
        ); }
    public AllTypesInternal(
        Integer anInt
        ,double aDouble
        ,Character aChar
        ,char achar
        ){
        this.anInt = anInt;
        this.aDouble = aDouble;
        this.aChar = aChar;
        this.achar = achar;
        }
    @Override
    public String toString() {
        return "AllTypesInternal {"
        +"anInt = " + anInt + " "
        +"aDouble = " + aDouble + " "
        +"aChar = " + aChar + " "
        +"achar = " + achar + " "
            + "} "; }  
    }

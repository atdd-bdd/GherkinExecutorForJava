package gherkinexecutor.Feature_Data_Types;
class AllTypesInternal{
     Integer anInt = Integer.valueOf("0");
     double aDouble = Double.parseDouble("0.0");
     Character aChar = Character.valueOf( "x".length() > 0 ?"x".charAt(0) : ' ');
     char achar = ( "y".length() > 0 ?"y".charAt(0) : ' ');
     
    AllTypes toAllTypes() {
        return new AllTypes(
        anInt.toString()
        ,Double.toString(aDouble)
        ,aChar.toString()
        ,Character.toString(achar)
        ); }
    public AllTypesInternal(
        Integer anInt
        ,double aDouble
        ,Character aChar
        ,char achar
        ){
        this.anInt = Integer.valueOf("0");
        this.aDouble = Double.parseDouble("0.0");
        this.aChar = Character.valueOf( "x".length() > 0 ?"x".charAt(0) : ' ');
        this.achar = ( "y".length() > 0 ?"y".charAt(0) : ' ');
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

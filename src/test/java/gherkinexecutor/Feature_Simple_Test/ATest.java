package gherkinexecutor.Feature_Simple_Test
class ATest{
    String anInt = "0";
    String aString = " ";
    String aDouble = "1.2";
    public ATest(
            String anInt
            ,String aString
            ,String aDouble
    ){
        this.anInt = anInt;
        this.aString = aString;
        this.aDouble = aDouble;
    }
}
 {
         fun toATestInternal() : ATestInternal{
         return ATestInternal(
         anInt.toInt(),
         aString.toString(),
         aDouble.toDouble(),
         ) }
         }

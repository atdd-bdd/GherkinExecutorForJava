package gherkinexecutor.Feature_Simple_Test;


record ATestInternal(int anInt, String aString, double aDouble) {

    public ATestInternal(int anInt, String aString, double aDouble) {
        this.anInt = anInt;
        this.aString = aString;
        this.aDouble = aDouble;
    }

    public ATest toATest() {
        return new ATest(
                Integer.toString(anInt),
                aString,
                Double.toString(aDouble)
        );
    }

    @Override
    public String toString() {
        return "ATestInternal {" +
                "anInt='" + anInt + '\'' +
                ", aString='" + aString + '\'' +
                ", aDouble='" + aDouble + '\'' +
                '}';
    }
    // Getters and setters
    public int getAnInt() {
        return anInt;
    }

    public String getAString() {
        return aString;
    }

    public double getADouble() {
        return aDouble;
    }
}

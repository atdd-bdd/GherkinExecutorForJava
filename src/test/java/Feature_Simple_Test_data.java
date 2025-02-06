public class ATest {
    private String anInt;
    private String aString;
    private String aDouble;

    public ATest() {
        this("0", " ", "1.2");
    }

    public ATest(String anInt, String aString, String aDouble) {
        this.anInt = anInt;
        this.aString = aString;
        this.aDouble = aDouble;
    }

    public ATestInternal toATestInternal() {
        return new ATestInternal(
                Integer.parseInt(anInt),
                aString,
                Double.parseDouble(aDouble)
        );
    }

    // Getters and setters (if needed)
}

public class ATestInternal {
    private int anInt;
    private String aString;
    private double aDouble;

    public ATestInternal() {
        this(0, " ", 1.2);
    }

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

    // Getters and setters (if needed)
}

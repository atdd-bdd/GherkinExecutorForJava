public class ATest {
    private String anInt;
    private String aString;
    private String aDouble;

    private ATest(Builder builder) {
        this.anInt = builder.anInt;
        this.aString = builder.aString;
        this.aDouble = builder.aDouble;
    }

    public ATestInternal toATestInternal() {
        return new ATestInternal(
                Integer.parseInt(anInt),
                aString,
                Double.parseDouble(aDouble)
        );
    }

    public static class Builder {
        private String anInt = "0";
        private String aString = " ";
        private String aDouble = "1.2";

        public Builder anInt(String anInt) {
            this.anInt = anInt;
            return this;
        }

        public Builder aString(String aString) {
            this.aString = aString;
            return this;
        }

        public Builder aDouble(String aDouble) {
            this.aDouble = aDouble;
            return this;
        }

        public ATest build() {
            return new ATest(this);
        }
    }

}

public class ATestInternal {
    private int anInt;
    private String aString;
    private double aDouble;

    private ATestInternal(Builder builder) {
        this.anInt = builder.anInt;
        this.aString = builder.aString;
        this.aDouble = builder.aDouble;
    }

    public ATest toATest() {
        return new ATest.Builder()
                .anInt(Integer.toString(anInt))
                .aString(aString)
                .aDouble(Double.toString(aDouble))
                .build();
    }

    public static class Builder {
        private int anInt = 0;
        private String aString = " ";
        private double aDouble = 1.2;

        public Builder anInt(int anInt) {
            this.anInt = anInt;
            return this;
        }

        public Builder aString(String aString) {
            this.aString = aString;
            return this;
        }

        public Builder aDouble(double aDouble) {
            this.aDouble = aDouble;
            return this;
        }

        public ATestInternal build() {
            return new ATestInternal(this);
        }
    }

    // Getters (if needed)
}

//Using it

public class Main {
    public static void main(String[] args) {
        // Using the builder to create an instance of ATest
        ATest aTest = new ATest.Builder()
                .anInt("1")
                .aString("something")
                .aDouble("1.2")
                .build();

        // Printing the ATest object
        System.out.println("ATest: " + aTest);

        // Converting ATest to ATestInternal using the toATestInternal method
        ATestInternal aTestInternal = aTest.toATestInternal();

        // Printing the ATestInternal object
        System.out.println("ATestInternal: " + aTestInternal);

        // Using the builder to create an instance of ATestInternal
        ATestInternal anotherTestInternal = new ATestInternal.Builder()
                .anInt(2)
                .aString("another")
                .aDouble(2.4)
                .build();

        // Printing the ATestInternal object
        System.out.println("Another ATestInternal: " + anotherTestInternal);

        // Converting ATestInternal to ATest using the toATest method
        ATest anotherTest = anotherTestInternal.toATest();

        // Printing the ATest object
        System.out.println("Another ATest: " + anotherTest);
    }


    final class Student {

        // instance fields
        private int id;
        private String name;
        private String address;

        // Setter Methods
        // Note that all setters method
        // return this reference
        public Student setId(int id) {
            this.id = id;
            return this;
        }

        public Student setName(String name) {
            this.name = name;
            return this;
        }

        public Student setAddress(String address) {
            this.address = address;
            return this;
        }

        @Override
        public String toString() {
            return "id = " + this.id + ", name = " + this.name + ", address = " + this.address;
        }
    }

    // Driver class
    public class MethodChainingDemo {
        public static void main(String args[]) {
            Student student1 = new Student();
            Student student2 = new Student();

            student1.setId(1)
                    .setName("Ram")
                    .setAddress("Noida");
            student2.setId(2)
                    .setName("Shyam")
                    .setAddress("Delhi");

            System.out.println(student1);
            System.out.println(student2);
        }
    }}

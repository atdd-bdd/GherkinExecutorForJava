package gherkinexecutor.Feature_Full_Test;

class ID {
    String value;
    public ID(String value){

        if (value.length() < 5 )
            throw new IllegalArgumentException("Too short");
        if (value.length() > 5)
            throw new IllegalArgumentException("Too long");
        if (value.charAt(0) != 'Q')
            throw new IllegalArgumentException("Must begin with Q");
        this.value = value;
    }
// Alternative validation method
//    boolean isValid() {
//        if (value.length() < 5 )
//            return false
//        if (value.length() > 5)
//            return false
//        if (value.charAt(0) != 'Q')
//            return false
//        return true
//    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ID id = (ID) obj;
        return value.equals(id.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return "ID{" +
                "value='" + value + '\'' +
                '}';
    }

}

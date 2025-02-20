package gherkinexecutor.Feature_Examples;

class ID{

    public ID(String value){

        if (value.length() < 5 )
            throw new IllegalArgumentException("Too short");
        if (value.length() > 5)
            throw new IllegalArgumentException("Too long");
        if (value.charAt(0) != 'Q')
            throw new IllegalArgumentException("Must begin with Q");
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

}

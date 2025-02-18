package gherkinexecutor.Feature_Data_Types;
class AllTypes{
    String anInt = "0";
    String aDouble = "0.0";
    String aChar = "x";
    String achar = "y";
    public AllTypes(
        String anInt
        ,String aDouble
        ,String aChar
        ,String achar
        ){
        this.anInt = anInt;
        this.aDouble = aDouble;
        this.aChar = aChar;
        this.achar = achar;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            AllTypes _AllTypes = (AllTypes) o;
            if (
            !this.anInt.equals("?DNC?")
            && !_AllTypes.anInt.equals("?DNC?"))
                if (! _AllTypes.anInt.equals(this.anInt))
                     return false;
            if (
            !this.aDouble.equals("?DNC?")
            && !_AllTypes.aDouble.equals("?DNC?"))
                if (! _AllTypes.aDouble.equals(this.aDouble))
                     return false;
            if (
            !this.aChar.equals("?DNC?")
            && !_AllTypes.aChar.equals("?DNC?"))
                if (! _AllTypes.aChar.equals(this.aChar))
                     return false;
            if (
            !this.achar.equals("?DNC?")
            && !_AllTypes.achar.equals("?DNC?"))
                if (! _AllTypes.achar.equals(this.achar))
                     return false;
         return true;  }
    public static class Builder {
        private String anInt = "0";
        private String aDouble = "0.0";
        private String aChar = "x";
        private String achar = "y";
        public Builder anInt(String anInt) {
            this.anInt = anInt;
            return this;
            }
        public Builder aDouble(String aDouble) {
            this.aDouble = aDouble;
            return this;
            }
        public Builder aChar(String aChar) {
            this.aChar = aChar;
            return this;
            }
        public Builder achar(String achar) {
            this.achar = achar;
            return this;
            }
        public AllTypes build(){
             return new AllTypes(
                 anInt
                 ,aDouble
                 ,aChar
                 ,achar
                );   } 
        } 
    @Override
    public String toString() {
        return "AllTypes {"
        +"anInt = " + anInt + " "
        +"aDouble = " + aDouble + " "
        +"aChar = " + aChar + " "
        +"achar = " + achar + " "
            + "} "; }  
    AllTypesInternal toAllTypesInternal() {
        return new AllTypesInternal(
         Integer.valueOf(anInt)
        , Double.parseDouble(aDouble)
        , Character.valueOf( aChar.length() > 0 ?aChar.charAt(0) : ' ')
        , ( achar.length() > 0 ?achar.charAt(0) : ' ')
        ); }
    }

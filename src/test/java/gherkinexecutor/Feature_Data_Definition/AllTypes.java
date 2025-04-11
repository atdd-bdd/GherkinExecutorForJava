package gherkinexecutor.Feature_Data_Definition;
import java.util.*;
class AllTypes{
    String anInt = "0";
    String aByte = "0";
    String aShort = "0";
    String aLong = "0";
    String aFloat = "0.0";
    String aDouble = "0.0";
    String aBool = "false";
    String aString = "";
    String aChar = "0";
    String anIntObject = "0";
    String aByteObject = "0";
    String aShortObject = "0";
    String aLongObject = "0";
    String aFloatObject = "0.0";
    String aDoubleObject = "0.0";
    String aBoolObject = "false";
    String aCharObject = "0";
    public AllTypes() { }
    public AllTypes(
        String anInt
        ,String aByte
        ,String aShort
        ,String aLong
        ,String aFloat
        ,String aDouble
        ,String aBool
        ,String aString
        ,String aChar
        ,String anIntObject
        ,String aByteObject
        ,String aShortObject
        ,String aLongObject
        ,String aFloatObject
        ,String aDoubleObject
        ,String aBoolObject
        ,String aCharObject
        ){
        this.anInt = anInt;
        this.aByte = aByte;
        this.aShort = aShort;
        this.aLong = aLong;
        this.aFloat = aFloat;
        this.aDouble = aDouble;
        this.aBool = aBool;
        this.aString = aString;
        this.aChar = aChar;
        this.anIntObject = anIntObject;
        this.aByteObject = aByteObject;
        this.aShortObject = aShortObject;
        this.aLongObject = aLongObject;
        this.aFloatObject = aFloatObject;
        this.aDoubleObject = aDoubleObject;
        this.aBoolObject = aBoolObject;
        this.aCharObject = aCharObject;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
             return false;
        AllTypes _AllTypes = (AllTypes) o;
            boolean result = true;
         if (
             !this.anInt.equals("?DNC?")
                && !_AllTypes.anInt.equals("?DNC?"))
                if (! _AllTypes.anInt.equals(this.anInt)) result = false;
         if (
             !this.aByte.equals("?DNC?")
                && !_AllTypes.aByte.equals("?DNC?"))
                if (! _AllTypes.aByte.equals(this.aByte)) result = false;
         if (
             !this.aShort.equals("?DNC?")
                && !_AllTypes.aShort.equals("?DNC?"))
                if (! _AllTypes.aShort.equals(this.aShort)) result = false;
         if (
             !this.aLong.equals("?DNC?")
                && !_AllTypes.aLong.equals("?DNC?"))
                if (! _AllTypes.aLong.equals(this.aLong)) result = false;
         if (
             !this.aFloat.equals("?DNC?")
                && !_AllTypes.aFloat.equals("?DNC?"))
                if (! _AllTypes.aFloat.equals(this.aFloat)) result = false;
         if (
             !this.aDouble.equals("?DNC?")
                && !_AllTypes.aDouble.equals("?DNC?"))
                if (! _AllTypes.aDouble.equals(this.aDouble)) result = false;
         if (
             !this.aBool.equals("?DNC?")
                && !_AllTypes.aBool.equals("?DNC?"))
                if (! _AllTypes.aBool.equals(this.aBool)) result = false;
         if (
             !this.aString.equals("?DNC?")
                && !_AllTypes.aString.equals("?DNC?"))
                if (! _AllTypes.aString.equals(this.aString)) result = false;
         if (
             !this.aChar.equals("?DNC?")
                && !_AllTypes.aChar.equals("?DNC?"))
                if (! _AllTypes.aChar.equals(this.aChar)) result = false;
         if (
             !this.anIntObject.equals("?DNC?")
                && !_AllTypes.anIntObject.equals("?DNC?"))
                if (! _AllTypes.anIntObject.equals(this.anIntObject)) result = false;
         if (
             !this.aByteObject.equals("?DNC?")
                && !_AllTypes.aByteObject.equals("?DNC?"))
                if (! _AllTypes.aByteObject.equals(this.aByteObject)) result = false;
         if (
             !this.aShortObject.equals("?DNC?")
                && !_AllTypes.aShortObject.equals("?DNC?"))
                if (! _AllTypes.aShortObject.equals(this.aShortObject)) result = false;
         if (
             !this.aLongObject.equals("?DNC?")
                && !_AllTypes.aLongObject.equals("?DNC?"))
                if (! _AllTypes.aLongObject.equals(this.aLongObject)) result = false;
         if (
             !this.aFloatObject.equals("?DNC?")
                && !_AllTypes.aFloatObject.equals("?DNC?"))
                if (! _AllTypes.aFloatObject.equals(this.aFloatObject)) result = false;
         if (
             !this.aDoubleObject.equals("?DNC?")
                && !_AllTypes.aDoubleObject.equals("?DNC?"))
                if (! _AllTypes.aDoubleObject.equals(this.aDoubleObject)) result = false;
         if (
             !this.aBoolObject.equals("?DNC?")
                && !_AllTypes.aBoolObject.equals("?DNC?"))
                if (! _AllTypes.aBoolObject.equals(this.aBoolObject)) result = false;
         if (
             !this.aCharObject.equals("?DNC?")
                && !_AllTypes.aCharObject.equals("?DNC?"))
                if (! _AllTypes.aCharObject.equals(this.aCharObject)) result = false;
             return result;  }
    public static class Builder {
        private String anInt = "0";
        private String aByte = "0";
        private String aShort = "0";
        private String aLong = "0";
        private String aFloat = "0.0";
        private String aDouble = "0.0";
        private String aBool = "false";
        private String aString = "";
        private String aChar = "0";
        private String anIntObject = "0";
        private String aByteObject = "0";
        private String aShortObject = "0";
        private String aLongObject = "0";
        private String aFloatObject = "0.0";
        private String aDoubleObject = "0.0";
        private String aBoolObject = "false";
        private String aCharObject = "0";
        public Builder setAnInt(String anInt) {
            this.anInt = anInt;
            return this;
            }
        public Builder setAByte(String aByte) {
            this.aByte = aByte;
            return this;
            }
        public Builder setAShort(String aShort) {
            this.aShort = aShort;
            return this;
            }
        public Builder setALong(String aLong) {
            this.aLong = aLong;
            return this;
            }
        public Builder setAFloat(String aFloat) {
            this.aFloat = aFloat;
            return this;
            }
        public Builder setADouble(String aDouble) {
            this.aDouble = aDouble;
            return this;
            }
        public Builder setABool(String aBool) {
            this.aBool = aBool;
            return this;
            }
        public Builder setAString(String aString) {
            this.aString = aString;
            return this;
            }
        public Builder setAChar(String aChar) {
            this.aChar = aChar;
            return this;
            }
        public Builder setAnIntObject(String anIntObject) {
            this.anIntObject = anIntObject;
            return this;
            }
        public Builder setAByteObject(String aByteObject) {
            this.aByteObject = aByteObject;
            return this;
            }
        public Builder setAShortObject(String aShortObject) {
            this.aShortObject = aShortObject;
            return this;
            }
        public Builder setALongObject(String aLongObject) {
            this.aLongObject = aLongObject;
            return this;
            }
        public Builder setAFloatObject(String aFloatObject) {
            this.aFloatObject = aFloatObject;
            return this;
            }
        public Builder setADoubleObject(String aDoubleObject) {
            this.aDoubleObject = aDoubleObject;
            return this;
            }
        public Builder setABoolObject(String aBoolObject) {
            this.aBoolObject = aBoolObject;
            return this;
            }
        public Builder setACharObject(String aCharObject) {
            this.aCharObject = aCharObject;
            return this;
            }
        public Builder  setCompare() {
            anInt = "?DNC?";
            aByte = "?DNC?";
            aShort = "?DNC?";
            aLong = "?DNC?";
            aFloat = "?DNC?";
            aDouble = "?DNC?";
            aBool = "?DNC?";
            aString = "?DNC?";
            aChar = "?DNC?";
            anIntObject = "?DNC?";
            aByteObject = "?DNC?";
            aShortObject = "?DNC?";
            aLongObject = "?DNC?";
            aFloatObject = "?DNC?";
            aDoubleObject = "?DNC?";
            aBoolObject = "?DNC?";
            aCharObject = "?DNC?";
            return this;
            }
        public AllTypes build(){
             return new AllTypes(
                 anInt
                 ,aByte
                 ,aShort
                 ,aLong
                 ,aFloat
                 ,aDouble
                 ,aBool
                 ,aString
                 ,aChar
                 ,anIntObject
                 ,aByteObject
                 ,aShortObject
                 ,aLongObject
                 ,aFloatObject
                 ,aDoubleObject
                 ,aBoolObject
                 ,aCharObject
                );   } 
        } 
        @Override
        public String toString() {
            return "AllTypes {"
             +"anInt = " + anInt + " "
             +"aByte = " + aByte + " "
             +"aShort = " + aShort + " "
             +"aLong = " + aLong + " "
             +"aFloat = " + aFloat + " "
             +"aDouble = " + aDouble + " "
             +"aBool = " + aBool + " "
             +"aString = " + aString + " "
             +"aChar = " + aChar + " "
             +"anIntObject = " + anIntObject + " "
             +"aByteObject = " + aByteObject + " "
             +"aShortObject = " + aShortObject + " "
             +"aLongObject = " + aLongObject + " "
             +"aFloatObject = " + aFloatObject + " "
             +"aDoubleObject = " + aDoubleObject + " "
             +"aBoolObject = " + aBoolObject + " "
             +"aCharObject = " + aCharObject + " "
             + "} " + "\n"; }

    public String toJson() {
        return " {"
         +""+"anInt:" + "\"" + anInt + "\""
         + ","         +""+"aByte:" + "\"" + aByte + "\""
         + ","         +""+"aShort:" + "\"" + aShort + "\""
         + ","         +""+"aLong:" + "\"" + aLong + "\""
         + ","         +""+"aFloat:" + "\"" + aFloat + "\""
         + ","         +""+"aDouble:" + "\"" + aDouble + "\""
         + ","         +""+"aBool:" + "\"" + aBool + "\""
         + ","         +""+"aString:" + "\"" + aString + "\""
         + ","         +""+"aChar:" + "\"" + aChar + "\""
         + ","         +""+"anIntObject:" + "\"" + anIntObject + "\""
         + ","         +""+"aByteObject:" + "\"" + aByteObject + "\""
         + ","         +""+"aShortObject:" + "\"" + aShortObject + "\""
         + ","         +""+"aLongObject:" + "\"" + aLongObject + "\""
         + ","         +""+"aFloatObject:" + "\"" + aFloatObject + "\""
         + ","         +""+"aDoubleObject:" + "\"" + aDoubleObject + "\""
         + ","         +""+"aBoolObject:" + "\"" + aBoolObject + "\""
         + ","         +""+"aCharObject:" + "\"" + aCharObject + "\""
                + "} " ; }

        public static AllTypes fromJson(String json) {
              AllTypes instance = new AllTypes();

              	json = json.replaceAll("\\s", "");
                String[] keyValuePairs = json.replace("{", "").replace("}", "").split(",");

                // Iterate over the key-value pairs
                for (String pair : keyValuePairs) {
                    // Split each pair by the colon
                    String[] entry = pair.split(":");

                    // Remove the quotes from the key and value
                    String key = entry[0].replace("\"", "").trim();
                    String value = entry[1].replace("\"", "").trim();


          // Assign the value to the corresponding field
                    switch (key) {
              case "anInt":
                  instance.anInt = value;
                  break;
              case "aByte":
                  instance.aByte = value;
                  break;
              case "aShort":
                  instance.aShort = value;
                  break;
              case "aLong":
                  instance.aLong = value;
                  break;
              case "aFloat":
                  instance.aFloat = value;
                  break;
              case "aDouble":
                  instance.aDouble = value;
                  break;
              case "aBool":
                  instance.aBool = value;
                  break;
              case "aString":
                  instance.aString = value;
                  break;
              case "aChar":
                  instance.aChar = value;
                  break;
              case "anIntObject":
                  instance.anIntObject = value;
                  break;
              case "aByteObject":
                  instance.aByteObject = value;
                  break;
              case "aShortObject":
                  instance.aShortObject = value;
                  break;
              case "aLongObject":
                  instance.aLongObject = value;
                  break;
              case "aFloatObject":
                  instance.aFloatObject = value;
                  break;
              case "aDoubleObject":
                  instance.aDoubleObject = value;
                  break;
              case "aBoolObject":
                  instance.aBoolObject = value;
                  break;
              case "aCharObject":
                  instance.aCharObject = value;
                  break;
        				default:
        				    System.err.println("Invalid JSON element " + key);
                    }
                }
                return instance;
            }


             public static String listToJson(List<AllTypes> list) {
                 StringBuilder jsonBuilder = new StringBuilder();
                 jsonBuilder.append("[");

                 for (int i = 0; i < list.size(); i++) {
                     jsonBuilder.append(list.get(i).toJson());
                     if (i < list.size() - 1) {
                         jsonBuilder.append(",");
                     }
                 }

                 jsonBuilder.append("]");
                 return jsonBuilder.toString();
             }

             public static List<AllTypes> listFromJson(String json) {
                    List<AllTypes> list = new ArrayList<>();
            		json = json.replaceAll("\\s", "");
            		json = json.replaceAll("\\[","").replaceAll("]","");
                    String[] jsonObjects = json.split("(?<=\\}),\\s*(?=\\{)");
                    for (String jsonObject : jsonObjects) {
                         list.add(AllTypes.fromJson(jsonObject));
                         }
                    return list;
                }

    AllTypesInternal toAllTypesInternal() {
        return new AllTypesInternal(
         Integer.parseInt(anInt)
        , Byte.parseByte(aByte)
        , Short.parseShort(aShort)
        , Long.parseLong(aLong)
        , Float.parseFloat(aFloat)
        , Double.parseDouble(aDouble)
        , Boolean.parseBoolean(aBool)
        , aString
        , ( aChar.length() > 0 ?aChar.charAt(0) : ' ')
        , Integer.valueOf(anIntObject)
        , Byte.valueOf(aByteObject)
        , Short.valueOf(aShortObject)
        , Long.valueOf(aLongObject)
        , Float.valueOf(aFloatObject)
        , Double.valueOf(aDoubleObject)
        , Boolean.parseBoolean(aBoolObject)
        , Character.valueOf( aCharObject.length() > 0 ?aCharObject.charAt(0) : ' ')
        ); }
    }

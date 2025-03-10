package gherkinexecutor.Feature_Full_Test;
import java.util.*;
import java.util.regex.Pattern;
import java.math.BigInteger;
class ATest0{
    String anInt = "0";
    String aString = "^";
    String aDouble = "1.2";
    public ATest0() { }
    public ATest0(
        String anInt
        ,String aString
        ,String aDouble
        ){
        this.anInt = anInt;
        this.aString = aString;
        this.aDouble = aDouble;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
             return false;
        ATest0 _ATest0 = (ATest0) o;
            boolean result = true;
         if (
             !this.anInt.equals("?DNC?")
                && !_ATest0.anInt.equals("?DNC?"))
                if (! _ATest0.anInt.equals(this.anInt)) result = false;
         if (
             !this.aString.equals("?DNC?")
                && !_ATest0.aString.equals("?DNC?"))
                if (! _ATest0.aString.equals(this.aString)) result = false;
         if (
             !this.aDouble.equals("?DNC?")
                && !_ATest0.aDouble.equals("?DNC?"))
                if (! _ATest0.aDouble.equals(this.aDouble)) result = false;
             return result;  }
    public static class Builder {
        private String anInt = "0";
        private String aString = "^";
        private String aDouble = "1.2";
        public Builder setAnInt(String anInt) {
            this.anInt = anInt;
            return this;
            }
        public Builder setAString(String aString) {
            this.aString = aString;
            return this;
            }
        public Builder setADouble(String aDouble) {
            this.aDouble = aDouble;
            return this;
            }
        public Builder  setCompare() {
            anInt = "?DNC?";
            aString = "?DNC?";
            aDouble = "?DNC?";
            return this;
            }
        public ATest0 build(){
             return new ATest0(
                 anInt
                 ,aString
                 ,aDouble
                );   } 
        } 
    @Override
    public String toString() {
        return "ATest0 {"
        +"anInt = " + anInt + " "
        +"aString = " + aString + " "
        +"aDouble = " + aDouble + " "
            + "} " + "\n"; }  
    public String toJson() {
        return " {"
        +""+"anInt:" + "\"" + anInt + "\""
        +","+"aString:" + "\"" + aString + "\""
        +","+"aDouble:" + "\"" + aDouble + "\""
            + "} " + "\n"; }  
        public static ATest0 fromJson(String json) {
              ATest0 instance = new ATest0();

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
              case "aString":
                  instance.aString = value;
                  break;
              case "aDouble":
                  instance.aDouble = value;
                  break;
        				default:
        				    System.err.println("Invalid JSON element " + key);
                    }
                }
                return instance;
            }


             public static String listToJson(List<ATest0> list) {
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

             public static List<ATest0> listFromJson(String json) {
                    List<ATest0> list = new ArrayList<>();
            		json = json.replaceAll("\\s", "");
                    String[] jsonObjects = json.replace("[", "").replace("]", "").split("[},{]");

                    for (String jsonObject : jsonObjects) {
                        jsonObject = "{" + jsonObject.replace("{", "").replace("}", "") + "}";
                        list.add(ATest0.fromJson(jsonObject));
                    }
                    return list;
                }

    ATestInternal toATestInternal() {
        return new ATestInternal(
         Integer.valueOf(anInt)
        , aString
        , Double.valueOf(aDouble)
        ); }
    }

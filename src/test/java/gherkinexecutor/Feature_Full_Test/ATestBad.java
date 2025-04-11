package gherkinexecutor.Feature_Full_Test;
import java.util.*;
import java.util.regex.Pattern;
import java.math.BigInteger;
class ATestBad{
    String anInt = "a";
    String aString = " ";
    String aDouble = "b";
    public ATestBad() { }
    public ATestBad(
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
        ATestBad _ATestBad = (ATestBad) o;
            boolean result = true;
         if (
             !this.anInt.equals("?DNC?")
                && !_ATestBad.anInt.equals("?DNC?"))
                if (! _ATestBad.anInt.equals(this.anInt)) result = false;
         if (
             !this.aString.equals("?DNC?")
                && !_ATestBad.aString.equals("?DNC?"))
                if (! _ATestBad.aString.equals(this.aString)) result = false;
         if (
             !this.aDouble.equals("?DNC?")
                && !_ATestBad.aDouble.equals("?DNC?"))
                if (! _ATestBad.aDouble.equals(this.aDouble)) result = false;
             return result;  }
    public static class Builder {
        private String anInt = "a";
        private String aString = " ";
        private String aDouble = "b";
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
        public ATestBad build(){
             return new ATestBad(
                 anInt
                 ,aString
                 ,aDouble
                );   } 
        } 
        @Override
        public String toString() {
            return "ATestBad {"
             +"anInt = " + anInt + " "
             +"aString = " + aString + " "
             +"aDouble = " + aDouble + " "
             + "} " + "\n"; }

    public String toJson() {
        return " {"
         +""+"anInt:" + "\"" + anInt + "\""
         + ","         +""+"aString:" + "\"" + aString + "\""
         + ","         +""+"aDouble:" + "\"" + aDouble + "\""
                + "} " ; }

        public static ATestBad fromJson(String json) {
              ATestBad instance = new ATestBad();

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


             public static String listToJson(List<ATestBad> list) {
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

             public static List<ATestBad> listFromJson(String json) {
                    List<ATestBad> list = new ArrayList<>();
            		json = json.replaceAll("\\s", "");
            		json = json.replaceAll("\\[","").replaceAll("]","");
                    String[] jsonObjects = json.split("(?<=\\}),\\s*(?=\\{)");
                    for (String jsonObject : jsonObjects) {
                         list.add(ATestBad.fromJson(jsonObject));
                         }
                    return list;
                }

    ATestBadInternal toATestBadInternal() {
        return new ATestBadInternal(
         Integer.valueOf(anInt)
        , aString
        , Double.valueOf(aDouble)
        ); }
    }

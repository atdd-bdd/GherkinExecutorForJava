package gherkinexecutor.Feature_Full_Test;
import java.util.*;
import java.util.regex.Pattern;
import java.math.BigInteger;
class TestIn{
    String aValue = "0";
    String bValue = " ";
    String cValue = "4.0";
    public TestIn() { }
    public TestIn(
        String aValue
        ,String bValue
        ,String cValue
        ){
        this.aValue = aValue;
        this.bValue = bValue;
        this.cValue = cValue;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
             return false;
        TestIn _TestIn = (TestIn) o;
            boolean result = true;
         if (
             !this.aValue.equals("?DNC?")
                && !_TestIn.aValue.equals("?DNC?"))
                if (! _TestIn.aValue.equals(this.aValue)) result = false;
         if (
             !this.bValue.equals("?DNC?")
                && !_TestIn.bValue.equals("?DNC?"))
                if (! _TestIn.bValue.equals(this.bValue)) result = false;
         if (
             !this.cValue.equals("?DNC?")
                && !_TestIn.cValue.equals("?DNC?"))
                if (! _TestIn.cValue.equals(this.cValue)) result = false;
             return result;  }
    public static class Builder {
        private String aValue = "0";
        private String bValue = " ";
        private String cValue = "4.0";
        public Builder setAValue(String aValue) {
            this.aValue = aValue;
            return this;
            }
        public Builder setBValue(String bValue) {
            this.bValue = bValue;
            return this;
            }
        public Builder setCValue(String cValue) {
            this.cValue = cValue;
            return this;
            }
        public Builder  setCompare() {
            aValue = "?DNC?";
            bValue = "?DNC?";
            cValue = "?DNC?";
            return this;
            }
        public TestIn build(){
             return new TestIn(
                 aValue
                 ,bValue
                 ,cValue
                );   } 
        } 
        @Override
        public String toString() {
            return "TestIn {"
             +"aValue = " + aValue + " "
             +"bValue = " + bValue + " "
             +"cValue = " + cValue + " "
             + "} " + "\n"; }

    public String toJson() {
        return " {"
         +""+"aValue:" + "\"" + aValue + "\""
         + ","         +""+"bValue:" + "\"" + bValue + "\""
         + ","         +""+"cValue:" + "\"" + cValue + "\""
        + "} " ; }

        public static TestIn fromJson(String json) {
              TestIn instance = new TestIn();

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
              case "aValue":
                  instance.aValue = value;
                  break;
              case "bValue":
                  instance.bValue = value;
                  break;
              case "cValue":
                  instance.cValue = value;
                  break;
        				default:
        				    System.err.println("Invalid JSON element " + key);
                    }
                }
                return instance;
            }


             public static String listToJson(List<TestIn> list) {
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

             public static List<TestIn> listFromJson(String json) {
                    List<TestIn> list = new ArrayList<>();
            		json = json.replaceAll("\\s", "");
            		json = json.replaceAll("\\[","").replaceAll("]","");
                    String[] jsonObjects = json.split("(?<=\\}),\\s*(?=\\{)");
                    for (String jsonObject : jsonObjects) {
                         list.add(TestIn.fromJson(jsonObject));
                         }
                    return list;
                }

    Existing toExisting() {
        return new Existing(
         Integer.parseInt(aValue)
        , bValue
        , Double.parseDouble(cValue)
        ); }
    }

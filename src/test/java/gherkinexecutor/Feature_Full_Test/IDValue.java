package gherkinexecutor.Feature_Full_Test;
import java.util.*;
import java.util.regex.Pattern;
import java.math.BigInteger;
class IDValue{
    String iD = "";
    String value = "";
    public IDValue() { }
    public IDValue(
        String iD
        ,String value
        ){
        this.iD = iD;
        this.value = value;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
             return false;
        IDValue _IDValue = (IDValue) o;
            boolean result = true;
         if (
             !this.iD.equals("?DNC?")
                && !_IDValue.iD.equals("?DNC?"))
                if (! _IDValue.iD.equals(this.iD)) result = false;
         if (
             !this.value.equals("?DNC?")
                && !_IDValue.value.equals("?DNC?"))
                if (! _IDValue.value.equals(this.value)) result = false;
             return result;  }
    public static class Builder {
        private String iD = "";
        private String value = "";
        public Builder setID(String iD) {
            this.iD = iD;
            return this;
            }
        public Builder setValue(String value) {
            this.value = value;
            return this;
            }
        public Builder  setCompare() {
            iD = "?DNC?";
            value = "?DNC?";
            return this;
            }
        public IDValue build(){
             return new IDValue(
                 iD
                 ,value
                );   } 
        } 
    @Override
    public String toString() {
        return "IDValue {"
        +"iD = " + iD + " "
        +"value = " + value + " "
            + "} " + "\n"; }  
    public String toJson() {
        return " {"
        +""+"iD:" + "\"" + iD + "\""
        +","+"value:" + "\"" + value + "\""
            + "} " + "\n"; }  
        public static IDValue fromJson(String json) {
              IDValue instance = new IDValue();

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
              case "iD":
                  instance.iD = value;
                  break;
              case "value":
                  instance.value = value;
                  break;
        				default:
        				    System.err.println("Invalid JSON element " + key);
                    }
                }
                return instance;
            }


             public static String listToJson(List<IDValue> list) {
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

             public static List<IDValue> listFromJson(String json) {
                    List<IDValue> list = new ArrayList<>();
            		json = json.replaceAll("\\s", "");
                    String[] jsonObjects = json.replace("[", "").replace("]", "").split("[},{]");

                    for (String jsonObject : jsonObjects) {
                        jsonObject = "{" + jsonObject.replace("{", "").replace("}", "") + "}";
                        list.add(IDValue.fromJson(jsonObject));
                    }
                    return list;
                }

    }

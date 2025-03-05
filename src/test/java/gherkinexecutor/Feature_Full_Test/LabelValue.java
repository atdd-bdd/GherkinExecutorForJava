package gherkinexecutor.Feature_Full_Test;
import java.util.*;
import java.util.regex.Pattern;
import java.math.BigInteger;
class LabelValue{
    String label = "";
    String value = "0";
    public LabelValue() { }
    public LabelValue(
        String label
        ,String value
        ){
        this.label = label;
        this.value = value;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
             return false;
        LabelValue _LabelValue = (LabelValue) o;
            boolean result = true;
         if (
             !this.label.equals("?DNC?")
                && !_LabelValue.label.equals("?DNC?"))
                if (! _LabelValue.label.equals(this.label)) result = false;
         if (
             !this.value.equals("?DNC?")
                && !_LabelValue.value.equals("?DNC?"))
                if (! _LabelValue.value.equals(this.value)) result = false;
             return result;  }
    public static class Builder {
        private String label = "";
        private String value = "0";
        public Builder label(String label) {
            this.label = label;
            return this;
            }
        public Builder value(String value) {
            this.value = value;
            return this;
            }
        public Builder  setCompare() {
            label = "?DNC?";
            value = "?DNC?";
            return this;
            }
        public LabelValue build(){
             return new LabelValue(
                 label
                 ,value
                );   } 
        } 
    @Override
    public String toString() {
        return "LabelValue {"
        +"label = " + label + " "
        +"value = " + value + " "
            + "} " + "\n"; }  
    public String toJson() {
        return " {"
        +""+"label:" + "\"" + label + "\""
        +","+"value:" + "\"" + value + "\""
            + "} " + "\n"; }  
        public static LabelValue fromJson(String json) {
              LabelValue instance = new LabelValue();

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
              case "label":
                  instance.label = value;
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


             public static String listToJson(List<LabelValue> list) {
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

             public static List<LabelValue> listFromJson(String json) {
                    List<LabelValue> list = new ArrayList<>();
            		json = json.replaceAll("\\s", "");
                    String[] jsonObjects = json.replace("[", "").replace("]", "").split("\\},\\{");

                    for (String jsonObject : jsonObjects) {
                        jsonObject = "{" + jsonObject.replace("{", "").replace("}", "") + "}";
                        list.add(LabelValue.fromJson(jsonObject));
                    }
                    return list;
                }

    LabelValueInternal toLabelValueInternal() {
        return new LabelValueInternal(
         label
        , Integer.valueOf(value)
        ); }
    }

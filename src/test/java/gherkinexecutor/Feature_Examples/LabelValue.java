package gherkinexecutor.Feature_Examples;
import java.util.*;
class LabelValue{
    String iD = "";
    String value = "0";
    public LabelValue() { }
    public LabelValue(
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
        LabelValue _LabelValue = (LabelValue) o;
            boolean result = true;
         if (
             !this.iD.equals("?DNC?")
                && !_LabelValue.iD.equals("?DNC?"))
                if (! _LabelValue.iD.equals(this.iD)) result = false;
         if (
             !this.value.equals("?DNC?")
                && !_LabelValue.value.equals("?DNC?"))
                if (! _LabelValue.value.equals(this.value)) result = false;
             return result;  }
    public static class Builder {
        private String iD = "";
        private String value = "0";
        public Builder iD(String iD) {
            this.iD = iD;
            return this;
            }
        public Builder value(String value) {
            this.value = value;
            return this;
            }
        public Builder  setCompare() {
            iD = "?DNC?";
            value = "?DNC?";
            return this;
            }
        public LabelValue build(){
             return new LabelValue(
                 iD
                 ,value
                );   } 
        } 
    @Override
    public String toString() {
        return "LabelValue {"
        +"iD = " + iD + " "
        +"value = " + value + " "
            + "} " + "\n"; }  
    public String toJson() {
        return " {"
        +""+"iD:" + "\"" + iD + "\""
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
         new ID(iD)
        , Integer.valueOf(value)
        ); }
    }

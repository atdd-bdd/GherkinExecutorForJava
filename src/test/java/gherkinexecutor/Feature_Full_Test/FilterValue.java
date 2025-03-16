package gherkinexecutor.Feature_Full_Test;
import java.util.*;
import java.util.regex.Pattern;
import java.math.BigInteger;
class FilterValue{
    String name = "";
    String value = "Q0000";
    public FilterValue() { }
    public FilterValue(
        String name
        ,String value
        ){
        this.name = name;
        this.value = value;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
             return false;
        FilterValue _FilterValue = (FilterValue) o;
            boolean result = true;
         if (
             !this.name.equals("?DNC?")
                && !_FilterValue.name.equals("?DNC?"))
                if (! _FilterValue.name.equals(this.name)) result = false;
         if (
             !this.value.equals("?DNC?")
                && !_FilterValue.value.equals("?DNC?"))
                if (! _FilterValue.value.equals(this.value)) result = false;
             return result;  }
    public static class Builder {
        private String name = "";
        private String value = "Q0000";
        public Builder setName(String name) {
            this.name = name;
            return this;
            }
        public Builder setValue(String value) {
            this.value = value;
            return this;
            }
        public Builder  setCompare() {
            name = "?DNC?";
            value = "?DNC?";
            return this;
            }
        public FilterValue build(){
             return new FilterValue(
                 name
                 ,value
                );   } 
        } 
    @Override
    public String toString() {
        return "FilterValue {"
        +"name = " + name + " "
        +"value = " + value + " "
            + "} " + "\n"; }  
    public String toJson() {
        return " {"
        +""+"name:" + "\"" + name + "\""
        +","+"value:" + "\"" + value + "\""
            + "} " + "\n"; }  
        public static FilterValue fromJson(String json) {
              FilterValue instance = new FilterValue();

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
              case "name":
                  instance.name = value;
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


             public static String listToJson(List<FilterValue> list) {
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

             public static List<FilterValue> listFromJson(String json) {
                    List<FilterValue> list = new ArrayList<>();
            		json = json.replaceAll("\\s", "");
            		json = json.replaceAll("\\[","").replaceAll("]","");
                    String[] jsonObjects = json.split("(?<=\\}),\\s*(?=\\{)");
                    for (String jsonObject : jsonObjects) {
                         list.add(FilterValue.fromJson(jsonObject));
                         }
                    return list;
                }

    FilterValueInternal toFilterValueInternal() {
        return new FilterValueInternal(
         name
        , new ID(value)
        ); }
    }

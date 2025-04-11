package gherkinexecutor.Feature_Full_Test;
import java.util.*;
import java.util.regex.Pattern;
import java.math.BigInteger;
class ExampleClassWithBlanks{
    String field_1 = " ";
    String field_2 = " ";
    public ExampleClassWithBlanks() { }
    public ExampleClassWithBlanks(
        String field_1
        ,String field_2
        ){
        this.field_1 = field_1;
        this.field_2 = field_2;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
             return false;
        ExampleClassWithBlanks _ExampleClassWithBlanks = (ExampleClassWithBlanks) o;
            boolean result = true;
         if (
             !this.field_1.equals("?DNC?")
                && !_ExampleClassWithBlanks.field_1.equals("?DNC?"))
                if (! _ExampleClassWithBlanks.field_1.equals(this.field_1)) result = false;
         if (
             !this.field_2.equals("?DNC?")
                && !_ExampleClassWithBlanks.field_2.equals("?DNC?"))
                if (! _ExampleClassWithBlanks.field_2.equals(this.field_2)) result = false;
             return result;  }
    public static class Builder {
        private String field_1 = " ";
        private String field_2 = " ";
        public Builder setField_1(String field_1) {
            this.field_1 = field_1;
            return this;
            }
        public Builder setField_2(String field_2) {
            this.field_2 = field_2;
            return this;
            }
        public Builder  setCompare() {
            field_1 = "?DNC?";
            field_2 = "?DNC?";
            return this;
            }
        public ExampleClassWithBlanks build(){
             return new ExampleClassWithBlanks(
                 field_1
                 ,field_2
                );   } 
        } 
        @Override
        public String toString() {
            return "ExampleClassWithBlanks {"
             +"field_1 = " + field_1 + " "
             +"field_2 = " + field_2 + " "
             + "} " + "\n"; }

    public String toJson() {
        return " {"
         +""+"field_1:" + "\"" + field_1 + "\""
         + ","         +""+"field_2:" + "\"" + field_2 + "\""
                + "} " ; }

        public static ExampleClassWithBlanks fromJson(String json) {
              ExampleClassWithBlanks instance = new ExampleClassWithBlanks();

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
              case "field_1":
                  instance.field_1 = value;
                  break;
              case "field_2":
                  instance.field_2 = value;
                  break;
        				default:
        				    System.err.println("Invalid JSON element " + key);
                    }
                }
                return instance;
            }


             public static String listToJson(List<ExampleClassWithBlanks> list) {
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

             public static List<ExampleClassWithBlanks> listFromJson(String json) {
                    List<ExampleClassWithBlanks> list = new ArrayList<>();
            		json = json.replaceAll("\\s", "");
            		json = json.replaceAll("\\[","").replaceAll("]","");
                    String[] jsonObjects = json.split("(?<=\\}),\\s*(?=\\{)");
                    for (String jsonObject : jsonObjects) {
                         list.add(ExampleClassWithBlanks.fromJson(jsonObject));
                         }
                    return list;
                }

    }

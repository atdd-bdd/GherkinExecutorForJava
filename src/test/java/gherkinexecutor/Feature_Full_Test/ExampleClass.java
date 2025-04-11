package gherkinexecutor.Feature_Full_Test;
import java.util.*;
import java.util.regex.Pattern;
import java.math.BigInteger;
class ExampleClass{
    String fieldA = "y";
    String fieldB = "x";
    public ExampleClass() { }
    public ExampleClass(
        String fieldA
        ,String fieldB
        ){
        this.fieldA = fieldA;
        this.fieldB = fieldB;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
             return false;
        ExampleClass _ExampleClass = (ExampleClass) o;
            boolean result = true;
         if (
             !this.fieldA.equals("?DNC?")
                && !_ExampleClass.fieldA.equals("?DNC?"))
                if (! _ExampleClass.fieldA.equals(this.fieldA)) result = false;
         if (
             !this.fieldB.equals("?DNC?")
                && !_ExampleClass.fieldB.equals("?DNC?"))
                if (! _ExampleClass.fieldB.equals(this.fieldB)) result = false;
             return result;  }
    public static class Builder {
        private String fieldA = "y";
        private String fieldB = "x";
        public Builder setFieldA(String fieldA) {
            this.fieldA = fieldA;
            return this;
            }
        public Builder setFieldB(String fieldB) {
            this.fieldB = fieldB;
            return this;
            }
        public Builder  setCompare() {
            fieldA = "?DNC?";
            fieldB = "?DNC?";
            return this;
            }
        public ExampleClass build(){
             return new ExampleClass(
                 fieldA
                 ,fieldB
                );   } 
        } 
        @Override
        public String toString() {
            return "ExampleClass {"
             +"fieldA = " + fieldA + " "
             +"fieldB = " + fieldB + " "
             + "} " + "\n"; }

    public String toJson() {
        return " {"
         +""+"fieldA:" + "\"" + fieldA + "\""
         + ","         +""+"fieldB:" + "\"" + fieldB + "\""
                + "} " ; }

        public static ExampleClass fromJson(String json) {
              ExampleClass instance = new ExampleClass();

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
              case "fieldA":
                  instance.fieldA = value;
                  break;
              case "fieldB":
                  instance.fieldB = value;
                  break;
        				default:
        				    System.err.println("Invalid JSON element " + key);
                    }
                }
                return instance;
            }


             public static String listToJson(List<ExampleClass> list) {
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

             public static List<ExampleClass> listFromJson(String json) {
                    List<ExampleClass> list = new ArrayList<>();
            		json = json.replaceAll("\\s", "");
            		json = json.replaceAll("\\[","").replaceAll("]","");
                    String[] jsonObjects = json.split("(?<=\\}),\\s*(?=\\{)");
                    for (String jsonObject : jsonObjects) {
                         list.add(ExampleClass.fromJson(jsonObject));
                         }
                    return list;
                }

    }

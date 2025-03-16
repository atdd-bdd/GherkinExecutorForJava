package gherkinexecutor.Feature_Full_Test;
import java.util.*;
import java.util.regex.Pattern;
import java.math.BigInteger;
class CSVContents{
    String a = "";
    String b = "";
    String c = "";
    public CSVContents() { }
    public CSVContents(
        String a
        ,String b
        ,String c
        ){
        this.a = a;
        this.b = b;
        this.c = c;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
             return false;
        CSVContents _CSVContents = (CSVContents) o;
            boolean result = true;
         if (
             !this.a.equals("?DNC?")
                && !_CSVContents.a.equals("?DNC?"))
                if (! _CSVContents.a.equals(this.a)) result = false;
         if (
             !this.b.equals("?DNC?")
                && !_CSVContents.b.equals("?DNC?"))
                if (! _CSVContents.b.equals(this.b)) result = false;
         if (
             !this.c.equals("?DNC?")
                && !_CSVContents.c.equals("?DNC?"))
                if (! _CSVContents.c.equals(this.c)) result = false;
             return result;  }
    public static class Builder {
        private String a = "";
        private String b = "";
        private String c = "";
        public Builder setA(String a) {
            this.a = a;
            return this;
            }
        public Builder setB(String b) {
            this.b = b;
            return this;
            }
        public Builder setC(String c) {
            this.c = c;
            return this;
            }
        public Builder  setCompare() {
            a = "?DNC?";
            b = "?DNC?";
            c = "?DNC?";
            return this;
            }
        public CSVContents build(){
             return new CSVContents(
                 a
                 ,b
                 ,c
                );   } 
        } 
    @Override
    public String toString() {
        return "CSVContents {"
        +"a = " + a + " "
        +"b = " + b + " "
        +"c = " + c + " "
            + "} " + "\n"; }  
    public String toJson() {
        return " {"
        +""+"a:" + "\"" + a + "\""
        +","+"b:" + "\"" + b + "\""
        +","+"c:" + "\"" + c + "\""
            + "} " + "\n"; }  
        public static CSVContents fromJson(String json) {
              CSVContents instance = new CSVContents();

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
              case "a":
                  instance.a = value;
                  break;
              case "b":
                  instance.b = value;
                  break;
              case "c":
                  instance.c = value;
                  break;
        				default:
        				    System.err.println("Invalid JSON element " + key);
                    }
                }
                return instance;
            }


             public static String listToJson(List<CSVContents> list) {
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

             public static List<CSVContents> listFromJson(String json) {
                    List<CSVContents> list = new ArrayList<>();
            		json = json.replaceAll("\\s", "");
            		json = json.replaceAll("\\[","").replaceAll("]","");
                    String[] jsonObjects = json.split("(?<=\\}),\\s*(?=\\{)");
                    for (String jsonObject : jsonObjects) {
                         list.add(CSVContents.fromJson(jsonObject));
                         }
                    return list;
                }

    }

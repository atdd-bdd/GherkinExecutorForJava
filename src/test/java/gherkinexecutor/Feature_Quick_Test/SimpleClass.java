package gherkinexecutor.Feature_Quick_Test;
import java.util.*;
class SimpleClass{
    String anInt = "0";
    String aString = "Q";
    public SimpleClass() { }
    public SimpleClass(
        String anInt
        ,String aString
        ){
        this.anInt = anInt;
        this.aString = aString;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
             return false;
        SimpleClass _SimpleClass = (SimpleClass) o;
            boolean result = true;
         if (
             !this.anInt.equals("?DNC?")
                && !_SimpleClass.anInt.equals("?DNC?"))
                if (! _SimpleClass.anInt.equals(this.anInt)) result = false;
         if (
             !this.aString.equals("?DNC?")
                && !_SimpleClass.aString.equals("?DNC?"))
                if (! _SimpleClass.aString.equals(this.aString)) result = false;
             return result;  }
    public static class Builder {
        private String anInt = "0";
        private String aString = "Q";
        public Builder setAnInt(String anInt) {
            this.anInt = anInt;
            return this;
            }
        public Builder setAString(String aString) {
            this.aString = aString;
            return this;
            }
        public Builder  setCompare() {
            anInt = "?DNC?";
            aString = "?DNC?";
            return this;
            }
        public SimpleClass build(){
             return new SimpleClass(
                 anInt
                 ,aString
                );   } 
        } 
    @Override
    public String toString() {
        return "SimpleClass {"
        +"anInt = " + anInt + " "
        +"aString = " + aString + " "
            + "} " + "\n"; }  
    public String toJson() {
        return " {"
        +""+"anInt:" + "\"" + anInt + "\""
        +","+"aString:" + "\"" + aString + "\""
            + "} " + "\n"; }  
        public static SimpleClass fromJson(String json) {
              SimpleClass instance = new SimpleClass();

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
        				default:
        				    System.err.println("Invalid JSON element " + key);
                    }
                }
                return instance;
            }


             public static String listToJson(List<SimpleClass> list) {
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

             public static List<SimpleClass> listFromJson(String json) {
                    List<SimpleClass> list = new ArrayList<>();
            		json = json.replaceAll("\\s", "");
                    String[] jsonObjects = json.replace("[", "").replace("]", "").split("[},{]");

                    for (String jsonObject : jsonObjects) {
                        jsonObject = "{" + jsonObject.replace("{", "").replace("}", "") + "}";
                        list.add(SimpleClass.fromJson(jsonObject));
                    }
                    return list;
                }

    SimpleClassInternal toSimpleClassInternal() {
        return new SimpleClassInternal(
         Integer.valueOf(anInt)
        , aString
        ); }
    }

package gherkinexecutor.Feature_Full_Test;
import java.util.*;
import java.util.regex.Pattern;
import java.math.BigInteger;
class FandC{
    String f = "0";
    String c = "0";
    String notes = "";
    public FandC() { }
    public FandC(
        String f
        ,String c
        ,String notes
        ){
        this.f = f;
        this.c = c;
        this.notes = notes;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
             return false;
        FandC _FandC = (FandC) o;
            boolean result = true;
         if (
             !this.f.equals("?DNC?")
                && !_FandC.f.equals("?DNC?"))
                if (! _FandC.f.equals(this.f)) result = false;
         if (
             !this.c.equals("?DNC?")
                && !_FandC.c.equals("?DNC?"))
                if (! _FandC.c.equals(this.c)) result = false;
         if (
             !this.notes.equals("?DNC?")
                && !_FandC.notes.equals("?DNC?"))
                if (! _FandC.notes.equals(this.notes)) result = false;
             return result;  }
    public static class Builder {
        private String f = "0";
        private String c = "0";
        private String notes = "";
        public Builder setF(String f) {
            this.f = f;
            return this;
            }
        public Builder setC(String c) {
            this.c = c;
            return this;
            }
        public Builder setNotes(String notes) {
            this.notes = notes;
            return this;
            }
        public Builder  setCompare() {
            f = "?DNC?";
            c = "?DNC?";
            notes = "?DNC?";
            return this;
            }
        public FandC build(){
             return new FandC(
                 f
                 ,c
                 ,notes
                );   } 
        } 
        @Override
        public String toString() {
            return "FandC {"
             +"f = " + f + " "
             +"c = " + c + " "
             +"notes = " + notes + " "
             + "} " + "\n"; }

    public String toJson() {
        return " {"
         +""+"f:" + "\"" + f + "\""
         + ","         +""+"c:" + "\"" + c + "\""
         + ","         +""+"notes:" + "\"" + notes + "\""
        + "} " ; }

        public static FandC fromJson(String json) {
              FandC instance = new FandC();

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
              case "f":
                  instance.f = value;
                  break;
              case "c":
                  instance.c = value;
                  break;
              case "notes":
                  instance.notes = value;
                  break;
        				default:
        				    System.err.println("Invalid JSON element " + key);
                    }
                }
                return instance;
            }


             public static String listToJson(List<FandC> list) {
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

             public static List<FandC> listFromJson(String json) {
                    List<FandC> list = new ArrayList<>();
            		json = json.replaceAll("\\s", "");
            		json = json.replaceAll("\\[","").replaceAll("]","");
                    String[] jsonObjects = json.split("(?<=\\}),\\s*(?=\\{)");
                    for (String jsonObject : jsonObjects) {
                         list.add(FandC.fromJson(jsonObject));
                         }
                    return list;
                }

    FandCInternal toFandCInternal() {
        return new FandCInternal(
         Integer.valueOf(f)
        , Integer.valueOf(c)
        , notes
        ); }
    }

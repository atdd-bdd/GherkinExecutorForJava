package gherkinexecutor.Feature_Data_Types;
import java.util.*;
//noinspection CanBeFinal
//noinspection UnusedImports
@SuppressWarnings({"unused", "EnhancedSwitchMigration", "ClassCanBeRecord", "NewClassNamingConvention", "RedundantSuppression"})
class SomeTypes{
    String anInt = "0";
    String aDouble = "0.0";
    String aChar = "x";
    String achar = "y";
    public SomeTypes() { }
    public SomeTypes(
        String anInt
        ,String aDouble
        ,String aChar
        ,String achar
        ){
        this.anInt = anInt;
        this.aDouble = aDouble;
        this.aChar = aChar;
        this.achar = achar;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
             return false;
        SomeTypes _SomeTypes = (SomeTypes) o;
            boolean result = true;
         if (
             !this.anInt.equals("?DNC?")
                && !_SomeTypes.anInt.equals("?DNC?"))
                if (! _SomeTypes.anInt.equals(this.anInt)) result = false;
         if (
             !this.aDouble.equals("?DNC?")
                && !_SomeTypes.aDouble.equals("?DNC?"))
                if (! _SomeTypes.aDouble.equals(this.aDouble)) result = false;
         if (
             !this.aChar.equals("?DNC?")
                && !_SomeTypes.aChar.equals("?DNC?"))
                if (! _SomeTypes.aChar.equals(this.aChar)) result = false;
         if (
             !this.achar.equals("?DNC?")
                && !_SomeTypes.achar.equals("?DNC?"))
                if (! _SomeTypes.achar.equals(this.achar)) result = false;
             return result;  }
//noinspection CanBeFinal
//noinspection UnusedImports
@SuppressWarnings({"unused", "EnhancedSwitchMigration", "ClassCanBeRecord", "NewClassNamingConvention", "RedundantSuppression"})
    public static class Builder {
        private String anInt = "0";
        private String aDouble = "0.0";
        private String aChar = "x";
        private String achar = "y";
        public Builder setAnInt(String anInt) {
            this.anInt = anInt;
            return this;
            }
        public Builder setADouble(String aDouble) {
            this.aDouble = aDouble;
            return this;
            }
        public Builder setAChar(String aChar) {
            this.aChar = aChar;
            return this;
            }
        public Builder setAchar(String achar) {
            this.achar = achar;
            return this;
            }
        public Builder  setCompare() {
            anInt = "?DNC?";
            aDouble = "?DNC?";
            aChar = "?DNC?";
            achar = "?DNC?";
            return this;
            }
        public SomeTypes build(){
             return new SomeTypes(
                 anInt
                 ,aDouble
                 ,aChar
                 ,achar
                );   } 
        } 
        @Override
        public String toString() {
            return "SomeTypes {"
             +"anInt = " + anInt + " "
             +"aDouble = " + aDouble + " "
             +"aChar = " + aChar + " "
             +"achar = " + achar + " "
             + "} " + "\n"; }

    public String toJson() {
        return " {"
         +""+"anInt:" + "\"" + anInt + "\""
         + ","         +""+"aDouble:" + "\"" + aDouble + "\""
         + ","         +""+"aChar:" + "\"" + aChar + "\""
         + ","         +""+"achar:" + "\"" + achar + "\""
                + "} " ; }

        public static SomeTypes fromJson(String json) {
              SomeTypes instance = new SomeTypes();

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
              case "aDouble":
                  instance.aDouble = value;
                  break;
              case "aChar":
                  instance.aChar = value;
                  break;
              case "achar":
                  instance.achar = value;
                  break;
        				default:
        				    System.err.println("Invalid JSON element " + key);
                    }
                }
                return instance;
            }


             public static String listToJson(List<SomeTypes> list) {
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

             public static List<SomeTypes> listFromJson(String json) {
                    List<SomeTypes> list = new ArrayList<>();
            		json = json.replaceAll("\\s", "");
            		json = json.replaceAll("\\[","").replaceAll("]","");
                    String[] jsonObjects = json.split("(?<=\\}),\\s*(?=\\{)");
                    for (String jsonObject : jsonObjects) {
                         list.add(SomeTypes.fromJson(jsonObject));
                         }
                    return list;
                }

    SomeTypesInternal toSomeTypesInternal() {
        return new SomeTypesInternal(
         Integer.parseInt(anInt)
        , Double.valueOf(aDouble)
        , Character.valueOf( aChar.length() > 0 ?aChar.charAt(0) : ' ')
        , ( achar.length() > 0 ?achar.charAt(0) : ' ')
        ); }
    }

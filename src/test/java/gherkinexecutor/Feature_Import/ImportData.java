package gherkinexecutor.Feature_Import;
import java.util.*;
import java.util.regex.Pattern;
import java.math.BigInteger;
class ImportData{
    String myPattern = "a.*";
    String myWeekday = "MONDAY";
    String myBigInt = "1";
    public ImportData() { }
    public ImportData(
        String myPattern
        ,String myWeekday
        ,String myBigInt
        ){
        this.myPattern = myPattern;
        this.myWeekday = myWeekday;
        this.myBigInt = myBigInt;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
             return false;
        ImportData _ImportData = (ImportData) o;
            boolean result = true;
         if (
             !this.myPattern.equals("?DNC?")
                && !_ImportData.myPattern.equals("?DNC?"))
                if (! _ImportData.myPattern.equals(this.myPattern)) result = false;
         if (
             !this.myWeekday.equals("?DNC?")
                && !_ImportData.myWeekday.equals("?DNC?"))
                if (! _ImportData.myWeekday.equals(this.myWeekday)) result = false;
         if (
             !this.myBigInt.equals("?DNC?")
                && !_ImportData.myBigInt.equals("?DNC?"))
                if (! _ImportData.myBigInt.equals(this.myBigInt)) result = false;
             return result;  }
    public static class Builder {
        private String myPattern = "a.*";
        private String myWeekday = "MONDAY";
        private String myBigInt = "1";
        public Builder setMyPattern(String myPattern) {
            this.myPattern = myPattern;
            return this;
            }
        public Builder setMyWeekday(String myWeekday) {
            this.myWeekday = myWeekday;
            return this;
            }
        public Builder setMyBigInt(String myBigInt) {
            this.myBigInt = myBigInt;
            return this;
            }
        public Builder  setCompare() {
            myPattern = "?DNC?";
            myWeekday = "?DNC?";
            myBigInt = "?DNC?";
            return this;
            }
        public ImportData build(){
             return new ImportData(
                 myPattern
                 ,myWeekday
                 ,myBigInt
                );   } 
        } 
        @Override
        public String toString() {
            return "ImportData {"
             +"myPattern = " + myPattern + " "
             +"myWeekday = " + myWeekday + " "
             +"myBigInt = " + myBigInt + " "
             + "} " + "\n"; }

    public String toJson() {
        return " {"
         +""+"myPattern:" + "\"" + myPattern + "\""
         + ","         +""+"myWeekday:" + "\"" + myWeekday + "\""
         + ","         +""+"myBigInt:" + "\"" + myBigInt + "\""
                + "} " ; }

        public static ImportData fromJson(String json) {
              ImportData instance = new ImportData();

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
              case "myPattern":
                  instance.myPattern = value;
                  break;
              case "myWeekday":
                  instance.myWeekday = value;
                  break;
              case "myBigInt":
                  instance.myBigInt = value;
                  break;
        				default:
        				    System.err.println("Invalid JSON element " + key);
                    }
                }
                return instance;
            }


             public static String listToJson(List<ImportData> list) {
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

             public static List<ImportData> listFromJson(String json) {
                    List<ImportData> list = new ArrayList<>();
            		json = json.replaceAll("\\s", "");
            		json = json.replaceAll("\\[","").replaceAll("]","");
                    String[] jsonObjects = json.split("(?<=\\}),\\s*(?=\\{)");
                    for (String jsonObject : jsonObjects) {
                         list.add(ImportData.fromJson(jsonObject));
                         }
                    return list;
                }

    ImportDataInternal toImportDataInternal() {
        return new ImportDataInternal(
         Pattern.compile(myPattern)
        , Weekday.valueOf(myWeekday)
        , new BigInteger(myBigInt)
        ); }
    }

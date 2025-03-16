package gherkinexecutor.Feature_Examples;
import java.util.*;
class ResultValue{
    String sum = "";
    public ResultValue() { }
    public ResultValue(
        String sum
        ){
        this.sum = sum;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
             return false;
        ResultValue _ResultValue = (ResultValue) o;
            boolean result = true;
         if (
             !this.sum.equals("?DNC?")
                && !_ResultValue.sum.equals("?DNC?"))
                if (! _ResultValue.sum.equals(this.sum)) result = false;
             return result;  }
    public static class Builder {
        private String sum = "";
        public Builder setSum(String sum) {
            this.sum = sum;
            return this;
            }
        public Builder  setCompare() {
            sum = "?DNC?";
            return this;
            }
        public ResultValue build(){
             return new ResultValue(
                 sum
                );   } 
        } 
    @Override
    public String toString() {
        return "ResultValue {"
        +"sum = " + sum + " "
            + "} " + "\n"; }  
    public String toJson() {
        return " {"
        +""+"sum:" + "\"" + sum + "\""
            + "} " + "\n"; }  
        public static ResultValue fromJson(String json) {
              ResultValue instance = new ResultValue();

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
              case "sum":
                  instance.sum = value;
                  break;
        				default:
        				    System.err.println("Invalid JSON element " + key);
                    }
                }
                return instance;
            }


             public static String listToJson(List<ResultValue> list) {
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

             public static List<ResultValue> listFromJson(String json) {
                    List<ResultValue> list = new ArrayList<>();
            		json = json.replaceAll("\\s", "");
            		json = json.replaceAll("\\[","").replaceAll("]","");
                    String[] jsonObjects = json.split("(?<=\\}),\\s*(?=\\{)");
                    for (String jsonObject : jsonObjects) {
                         list.add(ResultValue.fromJson(jsonObject));
                         }
                    return list;
                }

    ResultValueInternal toResultValueInternal() {
        return new ResultValueInternal(
         Integer.valueOf(sum)
        ); }
    }

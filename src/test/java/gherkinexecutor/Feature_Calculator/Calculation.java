package gherkinexecutor.Feature_Calculator;
import java.util.*;
class Calculation{
    String number1 = "0";
    String number2 = "0";
    String result = "0";
    public Calculation() { }
    public Calculation(
        String number1
        ,String number2
        ,String result
        ){
        this.number1 = number1;
        this.number2 = number2;
        this.result = result;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
             return false;
        Calculation _Calculation = (Calculation) o;
            boolean result = true;
         if (
             !this.number1.equals("?DNC?")
                && !_Calculation.number1.equals("?DNC?"))
                if (! _Calculation.number1.equals(this.number1)) result = false;
         if (
             !this.number2.equals("?DNC?")
                && !_Calculation.number2.equals("?DNC?"))
                if (! _Calculation.number2.equals(this.number2)) result = false;
         if (
             !this.result.equals("?DNC?")
                && !_Calculation.result.equals("?DNC?"))
                if (! _Calculation.result.equals(this.result)) result = false;
             return result;  }
    public static class Builder {
        private String number1 = "0";
        private String number2 = "0";
        private String result = "0";
        public Builder number1(String number1) {
            this.number1 = number1;
            return this;
            }
        public Builder number2(String number2) {
            this.number2 = number2;
            return this;
            }
        public Builder result(String result) {
            this.result = result;
            return this;
            }
        public Builder  setCompare() {
            number1 = "?DNC?";
            number2 = "?DNC?";
            result = "?DNC?";
            return this;
            }
        public Calculation build(){
             return new Calculation(
                 number1
                 ,number2
                 ,result
                );   } 
        } 
    @Override
    public String toString() {
        return "Calculation {"
        +"number1 = " + number1 + " "
        +"number2 = " + number2 + " "
        +"result = " + result + " "
            + "} " + "\n"; }  
    public String toJson() {
        return " {"
        +""+"number1:" + "\"" + number1 + "\""
        +","+"number2:" + "\"" + number2 + "\""
        +","+"result:" + "\"" + result + "\""
            + "} " + "\n"; }  
        public static Calculation fromJson(String json) {
              Calculation instance = new Calculation();

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
              case "number1":
                  instance.number1 = value;
                  break;
              case "number2":
                  instance.number2 = value;
                  break;
              case "result":
                  instance.result = value;
                  break;
        				default:
        				    System.err.println("Invalid JSON element " + key);
                    }
                }
                return instance;
            }


             public static String listToJson(List<Calculation> list) {
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

             public static List<Calculation> listFromJson(String json) {
                    List<Calculation> list = new ArrayList<>();
            		json = json.replace ("\\s", "");
                    String[] jsonObjects = json.replace("[", "").replace("]", "").split("\\},\\{");

                    for (String jsonObject : jsonObjects) {
                        jsonObject = "{" + jsonObject.replace("{", "").replace("}", "") + "}";
                        list.add(Calculation.fromJson(jsonObject));
                    }
                    return list;
                }

    CalculationInternal toCalculationInternal() {
        return new CalculationInternal(
         Integer.parseInt(number1)
        , Integer.parseInt(number2)
        , Integer.parseInt(result)
        ); }
    }

package gherkinexecutor.Feature_Forth;
import java.util.*;
class InputOutput{
    String input = "";
    String output = "";
    public InputOutput() { }
    public InputOutput(
        String input
        ,String output
        ){
        this.input = input;
        this.output = output;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
             return false;
        InputOutput _InputOutput = (InputOutput) o;
            boolean result = true;
         if (
             !this.input.equals("?DNC?")
                && !_InputOutput.input.equals("?DNC?"))
                if (! _InputOutput.input.equals(this.input)) result = false;
         if (
             !this.output.equals("?DNC?")
                && !_InputOutput.output.equals("?DNC?"))
                if (! _InputOutput.output.equals(this.output)) result = false;
             return result;  }
    public static class Builder {
        private String input = "";
        private String output = "";
        public Builder input(String input) {
            this.input = input;
            return this;
            }
        public Builder output(String output) {
            this.output = output;
            return this;
            }
        public Builder  setCompare() {
            input = "?DNC?";
            output = "?DNC?";
            return this;
            }
        public InputOutput build(){
             return new InputOutput(
                 input
                 ,output
                );   } 
        } 
    @Override
    public String toString() {
        return "InputOutput {"
        +"input = " + input + " "
        +"output = " + output + " "
            + "} " + "\n"; }  
    public String toJson() {
        return " {"
        +""+"input:" + "\"" + input + "\""
        +","+"output:" + "\"" + output + "\""
            + "} " + "\n"; }  
        public static InputOutput fromJson(String json) {
              InputOutput instance = new InputOutput();

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
              case "input":
                  instance.input = value;
                  break;
              case "output":
                  instance.output = value;
                  break;
        				default:
        				    System.err.println("Invalid JSON element " + key);
                    }
                }
                return instance;
            }


             public static String listToJson(List<InputOutput> list) {
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

             public static List<InputOutput> listFromJson(String json) {
                    List<InputOutput> list = new ArrayList<>();
            		json = json.replaceAll("\\s", "");
                    String[] jsonObjects = json.replace("[", "").replace("]", "").split("\\},\\{");

                    for (String jsonObject : jsonObjects) {
                        jsonObject = "{" + jsonObject.replace("{", "").replace("}", "") + "}";
                        list.add(InputOutput.fromJson(jsonObject));
                    }
                    return list;
                }

    }

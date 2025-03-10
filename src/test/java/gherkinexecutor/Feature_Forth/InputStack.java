package gherkinexecutor.Feature_Forth;
import java.util.*;
class InputStack{
    String input = "";
    String stack = "";
    String notes = "";
    public InputStack() { }
    public InputStack(
        String input
        ,String stack
        ,String notes
        ){
        this.input = input;
        this.stack = stack;
        this.notes = notes;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
             return false;
        InputStack _InputStack = (InputStack) o;
            boolean result = true;
         if (
             !this.input.equals("?DNC?")
                && !_InputStack.input.equals("?DNC?"))
                if (! _InputStack.input.equals(this.input)) result = false;
         if (
             !this.stack.equals("?DNC?")
                && !_InputStack.stack.equals("?DNC?"))
                if (! _InputStack.stack.equals(this.stack)) result = false;
         if (
             !this.notes.equals("?DNC?")
                && !_InputStack.notes.equals("?DNC?"))
                if (! _InputStack.notes.equals(this.notes)) result = false;
             return result;  }
    public static class Builder {
        private String input = "";
        private String stack = "";
        private String notes = "";
        public Builder input(String input) {
            this.input = input;
            return this;
            }
        public Builder stack(String stack) {
            this.stack = stack;
            return this;
            }
        public Builder notes(String notes) {
            this.notes = notes;
            return this;
            }
        public Builder  setCompare() {
            input = "?DNC?";
            stack = "?DNC?";
            notes = "?DNC?";
            return this;
            }
        public InputStack build(){
             return new InputStack(
                 input
                 ,stack
                 ,notes
                );   } 
        } 
    @Override
    public String toString() {
        return "InputStack {"
        +"input = " + input + " "
        +"stack = " + stack + " "
        +"notes = " + notes + " "
            + "} " + "\n"; }  
    public String toJson() {
        return " {"
        +""+"input:" + "\"" + input + "\""
        +","+"stack:" + "\"" + stack + "\""
        +","+"notes:" + "\"" + notes + "\""
            + "} " + "\n"; }  
        public static InputStack fromJson(String json) {
              InputStack instance = new InputStack();

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
              case "stack":
                  instance.stack = value;
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


             public static String listToJson(List<InputStack> list) {
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

             public static List<InputStack> listFromJson(String json) {
                    List<InputStack> list = new ArrayList<>();
            		json = json.replaceAll("\\s", "");
                    String[] jsonObjects = json.replace("[", "").replace("]", "").split("[},{]");

                    for (String jsonObject : jsonObjects) {
                        jsonObject = "{" + jsonObject.replace("{", "").replace("}", "") + "}";
                        list.add(InputStack.fromJson(jsonObject));
                    }
                    return list;
                }

    }

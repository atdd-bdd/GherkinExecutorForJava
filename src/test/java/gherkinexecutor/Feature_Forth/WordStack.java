package gherkinexecutor.Feature_Forth;
import java.util.*;
class WordStack{
    String word = "";
    String stack = "";
    String notes = "";
    public WordStack() { }
    public WordStack(
        String word
        ,String stack
        ,String notes
        ){
        this.word = word;
        this.stack = stack;
        this.notes = notes;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
             return false;
        WordStack _WordStack = (WordStack) o;
            boolean result = true;
         if (
             !this.word.equals("?DNC?")
                && !_WordStack.word.equals("?DNC?"))
                if (! _WordStack.word.equals(this.word)) result = false;
         if (
             !this.stack.equals("?DNC?")
                && !_WordStack.stack.equals("?DNC?"))
                if (! _WordStack.stack.equals(this.stack)) result = false;
         if (
             !this.notes.equals("?DNC?")
                && !_WordStack.notes.equals("?DNC?"))
                if (! _WordStack.notes.equals(this.notes)) result = false;
             return result;  }
    public static class Builder {
        private String word = "";
        private String stack = "";
        private String notes = "";
        public Builder word(String word) {
            this.word = word;
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
            word = "?DNC?";
            stack = "?DNC?";
            notes = "?DNC?";
            return this;
            }
        public WordStack build(){
             return new WordStack(
                 word
                 ,stack
                 ,notes
                );   } 
        } 
    @Override
    public String toString() {
        return "WordStack {"
        +"word = " + word + " "
        +"stack = " + stack + " "
        +"notes = " + notes + " "
            + "} " + "\n"; }  
    public String toJson() {
        return " {"
        +""+"word:" + "\"" + word + "\""
        +","+"stack:" + "\"" + stack + "\""
        +","+"notes:" + "\"" + notes + "\""
            + "} " + "\n"; }  
        public static WordStack fromJson(String json) {
              WordStack instance = new WordStack();

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
              case "word":
                  instance.word = value;
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


             public static String listToJson(List<WordStack> list) {
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

             public static List<WordStack> listFromJson(String json) {
                    List<WordStack> list = new ArrayList<>();
            		json = json.replaceAll("\\s", "");
                    String[] jsonObjects = json.replace("[", "").replace("]", "").split("\\},\\{");

                    for (String jsonObject : jsonObjects) {
                        jsonObject = "{" + jsonObject.replace("{", "").replace("}", "") + "}";
                        list.add(WordStack.fromJson(jsonObject));
                    }
                    return list;
                }

    }

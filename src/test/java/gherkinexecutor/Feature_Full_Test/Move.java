package gherkinexecutor.Feature_Full_Test;
import java.util.*;
import java.util.regex.Pattern;
import java.math.BigInteger;
class Move{
    String row = "0";
    String column = "0";
    String mark = "^";
    public Move() { }
    public Move(
        String row
        ,String column
        ,String mark
        ){
        this.row = row;
        this.column = column;
        this.mark = mark;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
             return false;
        Move _Move = (Move) o;
            boolean result = true;
         if (
             !this.row.equals("?DNC?")
                && !_Move.row.equals("?DNC?"))
                if (! _Move.row.equals(this.row)) result = false;
         if (
             !this.column.equals("?DNC?")
                && !_Move.column.equals("?DNC?"))
                if (! _Move.column.equals(this.column)) result = false;
         if (
             !this.mark.equals("?DNC?")
                && !_Move.mark.equals("?DNC?"))
                if (! _Move.mark.equals(this.mark)) result = false;
             return result;  }
    public static class Builder {
        private String row = "0";
        private String column = "0";
        private String mark = "^";
        public Builder setRow(String row) {
            this.row = row;
            return this;
            }
        public Builder setColumn(String column) {
            this.column = column;
            return this;
            }
        public Builder setMark(String mark) {
            this.mark = mark;
            return this;
            }
        public Builder  setCompare() {
            row = "?DNC?";
            column = "?DNC?";
            mark = "?DNC?";
            return this;
            }
        public Move build(){
             return new Move(
                 row
                 ,column
                 ,mark
                );   } 
        } 
        @Override
        public String toString() {
            return "Move {"
             +"row = " + row + " "
             +"column = " + column + " "
             +"mark = " + mark + " "
             + "} " + "\n"; }

    public String toJson() {
        return " {"
         +""+"row:" + "\"" + row + "\""
         + ","         +""+"column:" + "\"" + column + "\""
         + ","         +""+"mark:" + "\"" + mark + "\""
        + "} " ; }

        public static Move fromJson(String json) {
              Move instance = new Move();

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
              case "row":
                  instance.row = value;
                  break;
              case "column":
                  instance.column = value;
                  break;
              case "mark":
                  instance.mark = value;
                  break;
        				default:
        				    System.err.println("Invalid JSON element " + key);
                    }
                }
                return instance;
            }


             public static String listToJson(List<Move> list) {
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

             public static List<Move> listFromJson(String json) {
                    List<Move> list = new ArrayList<>();
            		json = json.replaceAll("\\s", "");
            		json = json.replaceAll("\\[","").replaceAll("]","");
                    String[] jsonObjects = json.split("(?<=\\}),\\s*(?=\\{)");
                    for (String jsonObject : jsonObjects) {
                         list.add(Move.fromJson(jsonObject));
                         }
                    return list;
                }

    MoveInternal toMoveInternal() {
        return new MoveInternal(
         Integer.valueOf(row)
        , Integer.valueOf(column)
        , Character.valueOf( mark.length() > 0 ?mark.charAt(0) : ' ')
        ); }
    }

package gherkinexecutor.Feature_Editor_Examples;
import java.util.*;
//noinspection CanBeFinal
//noinspection UnusedImports
@SuppressWarnings({"unused", "EnhancedSwitchMigration", "ClassCanBeRecord", "NewClassNamingConvention", "RedundantSuppression"})
class QuantityDiscount{
    String quantity = "0";
    String discount = "0%";
    String notes = "";
    public QuantityDiscount() { }
    public QuantityDiscount(
        String quantity
        ,String discount
        ,String notes
        ){
        this.quantity = quantity;
        this.discount = discount;
        this.notes = notes;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
             return false;
        QuantityDiscount _QuantityDiscount = (QuantityDiscount) o;
            boolean result = true;
         if (
             !this.quantity.equals("?DNC?")
                && !_QuantityDiscount.quantity.equals("?DNC?"))
                if (! _QuantityDiscount.quantity.equals(this.quantity)) result = false;
         if (
             !this.discount.equals("?DNC?")
                && !_QuantityDiscount.discount.equals("?DNC?"))
                if (! _QuantityDiscount.discount.equals(this.discount)) result = false;
         if (
             !this.notes.equals("?DNC?")
                && !_QuantityDiscount.notes.equals("?DNC?"))
                if (! _QuantityDiscount.notes.equals(this.notes)) result = false;
             return result;  }
//noinspection CanBeFinal
//noinspection UnusedImports
@SuppressWarnings({"unused", "EnhancedSwitchMigration", "ClassCanBeRecord", "NewClassNamingConvention", "RedundantSuppression"})
    public static class Builder {
        private String quantity = "0";
        private String discount = "0%";
        private String notes = "";
        public Builder setQuantity(String quantity) {
            this.quantity = quantity;
            return this;
            }
        public Builder setDiscount(String discount) {
            this.discount = discount;
            return this;
            }
        public Builder setNotes(String notes) {
            this.notes = notes;
            return this;
            }
        public Builder  setCompare() {
            quantity = "?DNC?";
            discount = "?DNC?";
            notes = "?DNC?";
            return this;
            }
        public QuantityDiscount build(){
             return new QuantityDiscount(
                 quantity
                 ,discount
                 ,notes
                );   } 
        } 
        @Override
        public String toString() {
            return "QuantityDiscount {"
             +"quantity = " + quantity + " "
             +"discount = " + discount + " "
             +"notes = " + notes + " "
             + "} " + "\n"; }

    public String toJson() {
        return " {"
         +""+"quantity:" + "\"" + quantity + "\""
         + ","         +""+"discount:" + "\"" + discount + "\""
         + ","         +""+"notes:" + "\"" + notes + "\""
                + "} " ; }

        public static QuantityDiscount fromJson(String json) {
              QuantityDiscount instance = new QuantityDiscount();

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
              case "quantity":
                  instance.quantity = value;
                  break;
              case "discount":
                  instance.discount = value;
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


             public static String listToJson(List<QuantityDiscount> list) {
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

             public static List<QuantityDiscount> listFromJson(String json) {
                    List<QuantityDiscount> list = new ArrayList<>();
            		json = json.replaceAll("\\s", "");
            		json = json.replaceAll("\\[","").replaceAll("]","");
                    String[] jsonObjects = json.split("(?<=\\}),\\s*(?=\\{)");
                    for (String jsonObject : jsonObjects) {
                         list.add(QuantityDiscount.fromJson(jsonObject));
                         }
                    return list;
                }

    QuantityDiscountInternal toQuantityDiscountInternal() {
        return new QuantityDiscountInternal(
         Integer.valueOf(quantity)
        , new Percentage(discount)
        , notes
        ); }
    }

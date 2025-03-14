package gherkinexecutor.Feature_Quick_Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class Feature_Quick_Test_glue {
    final String DNCString = "?DNC?";


    void Given_A_Table_to_List_Of_List_Of_Object(List<List<String>> values ) {
    List<List<Integer>> is = convertList(values);
    System.out.println(is);
        fail("Must implement");
    }

    void Given_values_are(List<SimpleClass> values ) {
        System.out.println("---  " + "Given_values_are");
        for (SimpleClass value : values){
             System.out.println(value);
             // Add calls to production code and asserts
              SimpleClassInternal i = value.toSimpleClassInternal();
              }
        fail("Must implement");
    }

        public static List<List<Integer>> convertList(List<List<String>> stringList) {
            List<List<Integer>> classList = new ArrayList<>();
            for (List<String> innerList : stringList) {
                List<Integer> innerClassList = new ArrayList<>();
                for (String s : innerList) {
                    innerClassList.add(Integer.valueOf(s));
                }
                classList.add(innerClassList);
            }
        return classList;
        }

    }

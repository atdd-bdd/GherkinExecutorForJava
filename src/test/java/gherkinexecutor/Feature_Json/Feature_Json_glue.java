package gherkinexecutor.Feature_Json;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.AssertJUnit.fail;

class Feature_Json_glue {
    final String DNCString = "?DNC?";


    List<SimpleClass> original;

    void Given_one_object_is(List<SimpleClass> values ) {
        System.out.println("---  " + "Given_one_object_is");
        for (SimpleClass value : values) {
            System.out.println(value);
            // Add calls to production code and asserts
            SimpleClassInternal i = value.toSimpleClassInternal();
        }
        original = values;
    }

    void Then_Json_should_be(String value) {
        System.out.println("---  " + "Then_Json_should_be");
        System.out.println(value);
        String result = original.get(0).toJson().trim();
        assertEquals(value.trim(), result);
    }

    String originalJson;

    void Given_Json_is(String value) {
        System.out.println("---  " + "Given_Json_is");
        System.out.println(value);
        originalJson = value;
    }

    void Then_the_converted_object_is(List<SimpleClass> values ) {
        System.out.println("---  " + "Then_the_converted_object_is");
        SimpleClass expected = SimpleClass.fromJson(originalJson);
        SimpleClass value = values.get(0);
        assertEquals(expected, value);
        // Can check the data with this call, will throw exception
        SimpleClassInternal i = value.toSimpleClassInternal();
    }

    List<SimpleClass> originalList;
    void Given_a_table_is(List<SimpleClass> values ) {
        System.out.println("---  " + "Given_a_table_is");

        for (SimpleClass value : values){
            System.out.println(value);
        }
        originalList = values;

    }

    void Then_Json_for_table_should_be(String value ) {
        System.out.println("---  " + "Then_Json_for_table_should_be");
        System.out.println(value);
        String result = SimpleClass.listToJson(originalList).replaceAll("\\s","");
        String expected = value.replaceAll("\\s","");
        assertEquals(expected, result);
    }


    void Given_Json_for_table_is(String value ) {
        System.out.println("---  " + "Given_Json_for_table_is");
        System.out.println(value);
        originalJson = value;
    }

    void Then_the_converted_table_should_be(List<SimpleClass> values ) {
        System.out.println("---  " + "Then_the_converted_table_should_be");
        for (SimpleClass value : values){
            System.out.println(value);
        }
        List<SimpleClass> result = SimpleClass.listFromJson(originalJson);
        assertEquals(values, result);
    }

}

package gherkinexecutor.Feature_Forth;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class Feature_Forth_glue {
    final String DNCString = "?DNC?";


    void Given_stack_starts_as(List<List<String>> values ) {
        System.out.println("---  " + "Given_stack_starts_as");
        for (List<String> value : values){
             System.out.println(value);
             // Add calls to production code and asserts
              }
        fail("Must implement");
    }

    void When_word_is_input_then_stack_becomes(List<WordStack> values ) {
        System.out.println("---  " + "When_word_is_input_then_stack_becomes");
        for (WordStack value : values){
             System.out.println(value);
             // Add calls to production code and asserts
              }
        fail("Must implement");
    }

    void Star_Given_an_input__what_the_stack_becomes(List<InputStack> values ) {
        System.out.println("---  " + "Star_Given_an_input__what_the_stack_becomes");
        for (InputStack value : values){
             System.out.println(value);
             // Add calls to production code and asserts
              }
        fail("Must implement");
    }

    void Star_Given_this_input(String value ) {
        System.out.println("---  " + "Star_Given_this_input");
        System.out.println(value);
        fail("Must implement");
    }

    void Star_Given_an_input__this_is_the_output(List<InputOutput> values ) {
        System.out.println("---  " + "Star_Given_an_input__this_is_the_output");
        for (InputOutput value : values){
             System.out.println(value);
             // Add calls to production code and asserts
              }
        fail("Must implement");
    }

    }

package gherkinexecutor.Feature_Forth;
import org.junit.jupiter.api.Test;
import java.util.List;
class Feature_Forth{


    @Test
    void test_Scenario_Individual_Instructions(){
         Feature_Forth_glue feature_Forth_glue_object = new Feature_Forth_glue();

        List<List<String>> stringListList1 = List.of(
           List.of(
            "2 5 7"
            )
            );
        feature_Forth_glue_object.Given_stack_starts_as(stringListList1);

        List<WordStack> objectList2 = List.of(
             new WordStack.Builder()
                .word("DUP")
                .stack("2 5 7 7")
                .notes("Duplicates the top element of the stack.")
                .build()
            , new WordStack.Builder()
                .word("SWAP")
                .stack("2 7 5")
                .notes("Swaps the top two elements of the stack.")
                .build()
            , new WordStack.Builder()
                .word("OVER")
                .stack("2 5 7 5")
                .notes("Copies the second element from the top of the stack to the top.")
                .build()
            , new WordStack.Builder()
                .word("ROT")
                .stack("5 7 2")
                .notes("Rotates the third element to the top.")
                .build()
            , new WordStack.Builder()
                .word("DROP")
                .stack("2 5")
                .notes("Removes the top element of the stack")
                .build()
            , new WordStack.Builder()
                .word("+")
                .stack("2 12")
                .notes("Adds the top two elements of the stack.")
                .build()
            , new WordStack.Builder()
                .word("*")
                .stack("2 35")
                .notes("Multiplies the top two elements of the stack.")
                .build()
            , new WordStack.Builder()
                .word("-")
                .stack("2 -2")
                .notes("Subtracts the top element from the second top element.")
                .build()
            );
        feature_Forth_glue_object.When_word_is_input_then_stack_becomes(objectList2);
        }
    @Test
    void test_Scenario_Sequence_of_Input(){
         Feature_Forth_glue feature_Forth_glue_object = new Feature_Forth_glue();

        List<InputStack> objectList1 = List.of(
             new InputStack.Builder()
                .input("2 5 7")
                .stack("2 5 7")
                .build()
            , new InputStack.Builder()
                .input("DUP")
                .stack("2 5 7 7")
                .build()
            , new InputStack.Builder()
                .input("SWAP")
                .stack("2 5 7 7")
                .build()
            , new InputStack.Builder()
                .input("OVER")
                .stack("2 5 7 7 7")
                .build()
            , new InputStack.Builder()
                .input("ROT")
                .stack("2 7 7 7 5")
                .build()
            , new InputStack.Builder()
                .input("DROP")
                .stack("2 7 7 7")
                .build()
            , new InputStack.Builder()
                .input("+")
                .stack("2 7 14")
                .build()
            , new InputStack.Builder()
                .input("*")
                .stack("2 98")
                .build()
            , new InputStack.Builder()
                .input("-")
                .stack("-96")
                .build()
            );
        feature_Forth_glue_object.Star_Given_an_input__what_the_stack_becomes(objectList1);
        }
    @Test
    void test_Scenario_Example_Program(){
         Feature_Forth_glue feature_Forth_glue_object = new Feature_Forth_glue();

        String string1 =
            """
            "No Weighting" from Starting Forth Chapter 12
            VARIABLE DENSITY
            VARIABLE THETA
            VARIABLE ID
            : " ( -- addr )   [CHAR] " WORD DUP C@ 1+ ALLOT ;
            : MATERIAL ( addr n1 n2 -- )    \\ addr=string, n1=density, n2=theta
            CREATE  , , ,
            DOES> ( -- )   DUP @ THETA !
            CELL+ DUP @ DENSITY !  CELL+ @ ID ! ;
            : .SUBSTANCE ( -- )   ID @ COUNT TYPE ;
            : FOOT ( n1 -- n2 )   10 * ;
            : INCH ( n1 -- n2 )   100 12 */  5 +  10 /  + ;
            : /TAN ( n1 -- n2 )   1000 THETA @ */ ;
            : PILE ( n -- )     
            DUP DUP 10 */ 1000 */  355 339 */  /TAN /TAN
            DENSITY @ 200 */  ." = " . ." tons of "  .SUBSTANCE ;
            \\ table of materials
            \\   string-address  density  tan[theta]
            " cement"           131        700  MATERIAL CEMENT
            " loose gravel"      93        649  MATERIAL LOOSE-GRAVEL
            " packed gravel"    100        700  MATERIAL PACKED-GRAVEL
            " dry sand"          90        754  MATERIAL DRY-SAND
            " wet sand"         118        900  MATERIAL WET-SAND
            " clay"             120        727  MATERIAL CLAY
            """.stripIndent();
        feature_Forth_glue_object.Star_Given_this_input(string1);

        List<InputOutput> objectList2 = List.of(
             new InputOutput.Builder()
                .input("CEMENT")
                .output("")
                .build()
            , new InputOutput.Builder()
                .input("10 FOOT PILE")
                .output("138 tons of cement")
                .build()
            , new InputOutput.Builder()
                .input("10 FOOT 3 INCH PILE")
                .output("151 tons of cement")
                .build()
            , new InputOutput.Builder()
                .input("DRY-SAND")
                .output("")
                .build()
            , new InputOutput.Builder()
                .input("10 FOOT PILE")
                .output("81 tons of dry sand")
                .build()
            );
        feature_Forth_glue_object.Star_Given_an_input__this_is_the_output(objectList2);
        }
    }


package gherkinexecutor.Feature_Tic_Tac_Toe_Game;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.List;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Feature_Tic_Tac_Toe_Game{


    @Test
    void test_Scenario_Make_a_move(){
         Feature_Tic_Tac_Toe_Game_glue feature_Tic_Tac_Toe_Game_glue_object = new Feature_Tic_Tac_Toe_Game_glue();

        List<List<String>> stringListList1 = List.of(
           List.of(
            ""
            ,""
            ,""
            )
           ,List.of(
            ""
            ,""
            ,""
            )
           ,List.of(
            ""
            ,""
            ,""
            )
            );
        feature_Tic_Tac_Toe_Game_glue_object.Given_board_is(stringListList1);

        List<Move> objectList2 = List.of(
             new Move.Builder()
                .row("1")
                .column("2")
                .mark("X")
                .build()
            );
        feature_Tic_Tac_Toe_Game_glue_object.When_move_is(objectList2);

        String table3 =
            """
            |   | X  |   |
            |   |    |   |
            |   |    |   |
            """.stripIndent();
        feature_Tic_Tac_Toe_Game_glue_object.Then_board_is_now(table3);
        }
    @Test
    void test_Scenario_Make_a_move_using_single_element(){
         Feature_Tic_Tac_Toe_Game_glue feature_Tic_Tac_Toe_Game_glue_object = new Feature_Tic_Tac_Toe_Game_glue();

        List<List<String>> stringListList1 = List.of(
           List.of(
            ""
            ,""
            ,""
            )
           ,List.of(
            ""
            ,""
            ,""
            )
           ,List.of(
            ""
            ,""
            ,""
            )
            );
        feature_Tic_Tac_Toe_Game_glue_object.Given_board_is(stringListList1);

        List<List<String>> stringListList2 = List.of(
           List.of(
            "1,2,X"
            )
            );
        feature_Tic_Tac_Toe_Game_glue_object.When_one_move_is(stringListList2);

        String table3 =
            """
            |   | X  |   |
            |   |    |   |
            |   |    |   |
            """.stripIndent();
        feature_Tic_Tac_Toe_Game_glue_object.Then_board_is_now(table3);
        }
    @Test
    void test_Scenario_Make_multiple_moves(){
         Feature_Tic_Tac_Toe_Game_glue feature_Tic_Tac_Toe_Game_glue_object = new Feature_Tic_Tac_Toe_Game_glue();

        List<List<String>> stringListList1 = List.of(
           List.of(
            ""
            ,""
            ,""
            )
           ,List.of(
            ""
            ,""
            ,""
            )
           ,List.of(
            ""
            ,""
            ,""
            )
            );
        feature_Tic_Tac_Toe_Game_glue_object.Given_board_is(stringListList1);

        List<Move> objectList2 = List.of(
             new Move.Builder()
                .row("1")
                .column("2")
                .mark("X")
                .build()
            , new Move.Builder()
                .row("2")
                .column("3")
                .mark("O")
                .build()
            );
        feature_Tic_Tac_Toe_Game_glue_object.When_moves_are(objectList2);

        String table3 =
            """
            |   | X  |    |
            |   |    | O  |
            |   |    |    |
            """.stripIndent();
        feature_Tic_Tac_Toe_Game_glue_object.Then_board_is_now(table3);
        }
    @Test
    void test_Scenario_check_the_prints_to_see_how_it_works(){
         Feature_Tic_Tac_Toe_Game_glue feature_Tic_Tac_Toe_Game_glue_object = new Feature_Tic_Tac_Toe_Game_glue();

        List<List<String>> stringListList1 = List.of(
           List.of(
            "0"
            ,"x"
            ,"0"
            )
           ,List.of(
            "x"
            ,"0"
            ,"x"
            )
           ,List.of(
            "0"
            ,"x"
            ,"0"
            )
            );
        feature_Tic_Tac_Toe_Game_glue_object.Given_board_is(stringListList1);

        String table2 =
            """
            | 0  | x  | 0  |
            | x  | 0  | x  |
            | 0  | x  | 0  |
            """.stripIndent();
        feature_Tic_Tac_Toe_Game_glue_object.Then_board_is_now(table2);
        }
    }


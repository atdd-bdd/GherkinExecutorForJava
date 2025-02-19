package gherkinexecutor.Feature_Tic_Tac_Toe_Game;
import static org.junit.Assert.fail;
import java.util.List;

class Feature_Tic_Tac_Toe_Game_glue {

    void Given_board_is(List<List<String>> value ) {
        System.out.println("---  " + "Given_board_is");
        System.out.println("*******");
        System.out.println(value);
    }

    void When_move_is(List<Move> value ) {
        System.out.println("---  " + "When_move_is");
        System.out.println("*******");
        System.out.println(value);
    }

    void Then_board_is_now(String value ) {
        System.out.println("---  " + "Then_board_is_now");
        System.out.println("*******");
        System.out.println(value);
    }

    void When_one_move_is(List<List<String>> value ) {
        System.out.println("---  " + "When_one_move_is");
        System.out.println("*******");
        System.out.println(value);
    }

    void When_moves_are(List<Move> value ) {
        System.out.println("---  " + "When_moves_are");
        System.out.println("*******");
        System.out.println(value);
    }

}

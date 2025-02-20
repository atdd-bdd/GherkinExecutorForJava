package gherkinexecutor.Feature_Tic_Tac_Toe_Game;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

class Feature_Tic_Tac_Toe_Game_glue {
    TicTacToeGame game = new TicTacToeGame();
    void log(String value) {
        try {
            FileWriter mylog = new FileWriter("src/test/java/gherkinexecutor/Feature_Tic_Tac_Toe_Game/log.txt", true);
            mylog.write(value + "\n");
            mylog.close();
        } catch (IOException e) {
            System.out.println("**** Cannot write to log ");
        }
    }


    void Given_board_is(List<List<String>> value ) {
        System.out.println("---  " + "Given_board_is");
        System.out.println("*******");
        log("---  " + "Given_board_is");
        log("*******");
        log(value.toString());
        System.out.println(value);
        for (List<String> v : value){
            System.out.println(v);
            game.setBoard(value);
        };
    }

    void When_move_is(List<Move> value ) {
        System.out.println("---  " + "When_move_is");
        System.out.println("*******");
        log("---  " + "When_move_is");
        log("*******");
        log(value.toString());
        System.out.println(value);
        for (Move v : value){
            System.out.println(v);
            MoveInternal i = v.toMoveInternal();
            game.makeAMove(i.row, i.column, i.mark);
        };
    }

    void Then_board_is_now(String value ) {
        System.out.println("---  " + "Then_board_is_now");
        System.out.println("*******");
        log("---  " + "Then_board_is_now");
        log("*******");
        log(value.toString());
        System.out.println(value);
        value = value.substring(0, value.length() - 1);
        String result = game.toString();
        assertEquals(value, result);
    }

    void When_one_move_is(List<List<String>> value ) {
        System.out.println("---  " + "When_one_move_is");
        System.out.println("*******");
        log("---  " + "When_one_move_is");
        log("*******");
        log(value.toString());
        System.out.println(value);
        String s = value.get(0).get(0);
        MoveIn mi = new MoveIn(s);
        Move m = mi.toMove();
        MoveInternal oneMove = m.toMoveInternal();
        game.makeAMove(oneMove.row, oneMove.column,
                    oneMove.mark);

    }

    void When_moves_are(List<Move> value ) {
        System.out.println("---  " + "When_moves_are");
        System.out.println("*******");
        log("---  " + "When_moves_are");
        log("*******");
        log(value.toString());
        System.out.println(value);
        for (Move v : value){
            MoveInternal i = v.toMoveInternal();
            game.makeAMove(i.row, i.column, i.mark);
            System.out.println(v);
        };
    }

}

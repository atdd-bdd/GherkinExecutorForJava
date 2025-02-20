package gherkinexecutor.Feature_Tic_Tac_Toe_Game;
import production.*;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

class Feature_Tic_Tac_Toe_Game_glue {
    final TicTacToeGame game = new TicTacToeGame();
    void log(String value) {
        try {
            FileWriter mylog = new FileWriter("src/test/java/gherkinexecutor/Feature_Tic_Tac_Toe_Game/log.txt", true);
            mylog.write(value + "\n");
            mylog.close();
        } catch (IOException e) {
            System.err.println("**** Cannot write to log ");
        }
    }


    void Given_board_is(List<List<String>> value ) {
        System.out.println("---  " + "Given_board_is");
        log("---  " + "Given_board_is");
        log(value.toString());
        System.out.println(value);
        for (List<String> v : value){
            System.out.println(v);
            game.setBoard(value);
        }
    }

    void When_move_is(List<Move> value ) {
        System.out.println("---  " + "When_move_is");
        log("---  " + "When_move_is");
        log(value.toString());
        System.out.println(value);
        for (Move v : value){
            System.out.println(v);
            try {
                MoveInternal i = v.toMoveInternal();
                game.makeAMove(i.row, i.column, i.mark);
            }
            catch (Exception e){
                System.err.println("Argument Error " + v.toString());
            }
        }
    }

    void Then_board_is_now(String value ) {
        System.out.println("---  " + "Then_board_is_now");
        log("---  " + "Then_board_is_now");
        log(value);
        System.out.println(value);
        value = value.substring(0, value.length() - 1);
        String result = game.toString();
        assertEquals(value, result);
    }

    void When_one_move_is(List<List<String>> value ) {
        System.out.println("---  " + "When_one_move_is");
        log("---  " + "When_one_move_is");
        log(value.toString());
        System.out.println(value);
        String s = value.get(0).get(0);
        MoveIn mi = new MoveIn(s);
        Move m = mi.toMove();
        try {
            MoveInternal oneMove = m.toMoveInternal();
            game.makeAMove(oneMove.row, oneMove.column,
                    oneMove.mark);
        }
        catch(Exception e){
            System.err.println("Argument error" + m.toString());
        }
    }

    void When_moves_are(List<Move> value ) {
        System.out.println("---  " + "When_moves_are");
        log("---  " + "When_moves_are");
        log(value.toString());
        System.out.println(value);
        for (Move v : value){
            try {
                MoveInternal i = v.toMoveInternal();
                game.makeAMove(i.row, i.column, i.mark);
            }
            catch(Exception e)
            {
                System.out.println("Argument error" + v.toString());
            }
            System.out.println(v);
        }
    }

}

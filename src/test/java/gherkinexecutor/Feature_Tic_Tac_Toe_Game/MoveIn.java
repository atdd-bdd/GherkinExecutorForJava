package gherkinexecutor.Feature_Tic_Tac_Toe_Game;

class MoveIn {
    String row = "0";
    String column = "0";
    String mark = "^";

    public MoveIn(
            String row
            , String column
            , String mark
    ) {
        this.row = row;
        this.column = column;
        this.mark = mark;
    }

    MoveIn(String moveString) {
        String[] parts = moveString.split(",");
        if (parts.length == 3) {
            this.row = parts[0];
            this.column = parts[1];
            this.mark = parts[2];
        } else {
            throw new IllegalArgumentException("Invalid move string format");
        }
    }


    Move toMove() {
        return new Move(
                row,
                column,
                mark
        );
    }
}

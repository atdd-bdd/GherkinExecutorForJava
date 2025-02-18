package gherkinexecutor.Feature_Tic_Tac_Toe_Game;
class MoveInternal{
     Int row = "0";
     Int column = "0";
     Char mark = " ";
     
    Move toMove() {
        return new Move(
        row.toString()
        ,column.toString()
        ,mark.toString()
        ); }
    public MoveInternal(
        Int row
        ,Int column
        ,Char mark
        ){
        this.row = "0";
        this.column = "0";
        this.mark = " ";
        }
    @Override
    public String toString() {
        return "MoveInternal {"
        +"row = " + row + " "
        +"column = " + column + " "
        +"mark = " + mark + " "
            + "} "; }  
    }

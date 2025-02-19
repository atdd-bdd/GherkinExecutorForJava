package gherkinexecutor.Feature_Tic_Tac_Toe_Game;
class MoveInternal{
     Integer row = Integer.valueOf("0");
     Integer column = Integer.valueOf("0");
     Character mark = Character.valueOf( "^".length() > 0 ?"^".charAt(0) : ' ');
     
    Move toMove() {
        return new Move(
        String.valueOf(row)
        ,String.valueOf(column)
        ,String.valueOf(mark)
        ); }
    public MoveInternal(
        Integer row
        ,Integer column
        ,Character mark
        ){
        this.row = row;
        this.column = column;
        this.mark = mark;
        }
    @Override
    public String toString() {
        return "MoveInternal {"
        +"row = " + row + " "
        +"column = " + column + " "
        +"mark = " + mark + " "
            + "} "; }  
    }

package gherkinexecutor.Feature_Tic_Tac_Toe_Game;
import java.util.*;
class MoveInternal{
     Integer row;
     Integer column;
     Character mark;
     
    public static String toDataTypeString() {
        return "MoveInternal {"
        +"Integer " 
        +"Integer " 
        +"Character " 
            + "} "; }  
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
        )  {
        this.row = row;
        this.column = column;
        this.mark = mark;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoveInternal _MoveInternal = (MoveInternal) o;
         return 
                ( _MoveInternal.row.equals(this.row))
                 && ( _MoveInternal.column.equals(this.column))
                 && ( _MoveInternal.mark.equals(this.mark))
             ;  }
    @Override
    public String toString() {
        return "MoveInternal {"
        +"row = " + row + " "
        +"column = " + column + " "
        +"mark = " + mark + " "
            + "} " + "\n"; }  
    }

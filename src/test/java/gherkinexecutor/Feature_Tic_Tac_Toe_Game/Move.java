package gherkinexecutor.Feature_Tic_Tac_Toe_Game;
import java.util.*;
class Move{
    String row = "0";
    String column = "0";
    String mark = "^";
    public Move() { }
    public Move(
        String row
        ,String column
        ,String mark
        ){
        this.row = row;
        this.column = column;
        this.mark = mark;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
             return false;
        Move _Move = (Move) o;
            boolean result = true;
         if (
             !this.row.equals("?DNC?")
                && !_Move.row.equals("?DNC?"))
                if (! _Move.row.equals(this.row)) result = false;
         if (
             !this.column.equals("?DNC?")
                && !_Move.column.equals("?DNC?"))
                if (! _Move.column.equals(this.column)) result = false;
         if (
             !this.mark.equals("?DNC?")
                && !_Move.mark.equals("?DNC?"))
                if (! _Move.mark.equals(this.mark)) result = false;
             return result;  }
    public static class Builder {
        private String row = "0";
        private String column = "0";
        private String mark = "^";
        public Builder row(String row) {
            this.row = row;
            return this;
            }
        public Builder column(String column) {
            this.column = column;
            return this;
            }
        public Builder mark(String mark) {
            this.mark = mark;
            return this;
            }
        public Builder  setCompare() {
            row = "?DNC?";
            column = "?DNC?";
            mark = "?DNC?";
            return this;
            }
        public Move build(){
             return new Move(
                 row
                 ,column
                 ,mark
                );   } 
        } 
    @Override
    public String toString() {
        return "Move {"
        +"row = " + row + " "
        +"column = " + column + " "
        +"mark = " + mark + " "
            + "} " + "\n"; }  
    MoveInternal toMoveInternal() {
        return new MoveInternal(
         Integer.valueOf(row)
        , Integer.valueOf(column)
        , Character.valueOf( mark.length() > 0 ?mark.charAt(0) : ' ')
        ); }
    }

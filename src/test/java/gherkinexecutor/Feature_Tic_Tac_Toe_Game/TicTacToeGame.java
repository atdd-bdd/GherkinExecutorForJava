package gherkinexecutor.Feature_Tic_Tac_Toe_Game;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeGame {
    private List<List<String>> gameBoard = new ArrayList<>();

    public TicTacToeGame() {
        gameBoard.add(new ArrayList<>());
    }

    public void setBoard(List<List<String>> value) {
        gameBoard.clear();
        for (List<String> row : value) {
            List<String> inRow = new ArrayList<>();
            for (String cell : row) {
                inRow.add(cell);
            }
            gameBoard.add(inRow);
        }


    }

    @Override
    public String toString() {
        return ListOfListToString(this.gameBoard);
    }

    public void makeAMove(int row, int column, char mark) {
        System.out.println("Row " + row + " Col " + column + " Mark " + mark);
        gameBoard.get(row - 1).set(column - 1, Character.toString(mark));
      }

    public static String ListOfListToString(List<List<String>> value) {
        List<Integer> maxSizes = new ArrayList<>();
        for (List<String> row : value) {
            int column = 0;
            for (String cell : row) {
                if (maxSizes.size() < column + 1) {
                    maxSizes.add(0);
                }
                if (cell.length() > maxSizes.get(column)) {
                    maxSizes.set(column, cell.length());
                }
                column++;
            }
        }
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (List<String> row : value) {
            result.append("|");
            int column = 0;
            for (String cell : row) {
                result.append(" ");
                int numberSpaces = maxSizes.get(column) - cell.length() + 1;
                result.append(cell);
                for (int i = 0; i <= numberSpaces; i++) {
                    result.append(" ");
                }
                result.append("|");
                column++;
            }
            if (count < value.size())
                result.append("\n");
            count++;
        }

        return result.toString().trim();
    }
}

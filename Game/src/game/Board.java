package game;

import utils.Position;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Stack>> board;

    public Board(int size) {
        board = new ArrayList<List<Stack>>();
        for (int row = 0; row < size; row++) {
            List<Stack> boardRow = new ArrayList<Stack>();
            for (int col = 0; col < size; col++) {
                Stack stack = new Stack();
                boardRow.add(stack);
            }
            board.add(boardRow);
        }
    }

    public void placeStone(Stone stone, Position position) {
        board.get(position.y).get(position.x).addStone(stone);
    }

    public void printBoard() {
        for (int row = 0; row < board.size(); row++) {
            for (int col = 0; col < board.size(); col++) {
                System.out.print(board.get(row).get(col).stack.size() + " ");
            }
            System.out.println();
        }

    }
}

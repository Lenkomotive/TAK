import game.Board;
import game.Stone;
import utils.Color;
import utils.Position;
import utils.StoneType;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(3);
        board.printBoard();
        Stone stone = new Stone(new Position(0,2), Color.BLACK, StoneType.CAPSTONE);
        board.placeStone(stone, stone.position);
        board.printBoard();


    }
}
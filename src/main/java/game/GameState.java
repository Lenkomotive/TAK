package game;

import game.Stack;
import utils.Color;
import utils.StoneType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameState {
    public int boardLength;
    public List<Integer> remainingStones = new ArrayList<Integer>();
    public List<Integer> remainingCapStones = new ArrayList<Integer>();
    public List<Stack> board = new ArrayList<Stack>();

    public GameState(int boardLength, List<Integer> remainingStones, List<Integer> remainingCapStones, List<Stack> board) {
        this.boardLength = boardLength;
        this.remainingStones = remainingStones;
        this.remainingCapStones = remainingCapStones;
        this.board = board;
    }

    public static GameState getDummyGameState3x3() {
        List<Integer> remainingStones = new ArrayList<Integer>();
        remainingStones.add(10);
        remainingStones.add(10);

        List<Stack> board = new ArrayList<Stack>();
        for (int i = 0; i < 9; i++) {
            board.add(new Stack());
        }

        Stone whiteStone = new Stone(Color.WHITE, StoneType.FLAT);
        Stone blackStone = new Stone(Color.BLACK, StoneType.FLAT);
        board.get(0).addStone(whiteStone);
        board.get(8).addStone(blackStone);

        GameState state = new GameState(3, remainingStones, Collections.emptyList(), board);
        return state;
    }
}

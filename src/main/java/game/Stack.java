package game;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    public List<Stone> stack;

    public Stack() {
        stack = new ArrayList<Stone>();
    }

    public void addStone(Stone stone) {
        stack.add(stone);
    }
}

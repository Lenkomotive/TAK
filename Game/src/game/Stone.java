package game;

import utils.Color;
import utils.Position;
import utils.StoneType;

public class Stone {
    public Color color;
    public StoneType type;

    public Stone(Color color, StoneType type) {
        this.color = color;
        this.type = type;
    }
}

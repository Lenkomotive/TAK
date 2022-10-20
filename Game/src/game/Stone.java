package game;

import utils.Color;
import utils.Position;
import utils.StoneType;

public class Stone {
    public Color color;
    public StoneType type;
    public Position position;

    public Stone(Position position, Color color, StoneType type) {
        this.position = position;
        this.color = color;
        this.type = type;
    }
}

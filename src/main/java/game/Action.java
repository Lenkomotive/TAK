package game;

import utils.ActionType;
import utils.Direction;
import utils.Position;

import java.util.List;

public class Action {
    public ActionType type;
    public Position position;
    public Direction direction;
    public List<Integer> drops;

    public Action(Position position) {
        this.type = ActionType.PLACE_ACTION;
        this.position = position;
    }

    public Action(Direction direction, List<Integer> drops) {
        this.type = ActionType.MOVE_ACTION;
        this.direction = direction;
        this.drops = drops;
    }


}

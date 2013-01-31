package retaliation.game.entities;

import retaliation.game.shapes.Shape;
import retaliation.game.shapes.ShapeMovementListener;

public class Level implements ShapeMovementListener {

    private final Fighter fighter;

    public Level(Fighter fighter) {
        this.fighter = fighter;        
    }

    public Fighter getFighter() {
        return fighter;
    }

    @Override
    public void shapeMoved(Shape shape) {
        
    }
}

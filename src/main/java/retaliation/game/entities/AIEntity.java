package retaliation.game.entities;

import retaliation.game.shapes.Shape;

public abstract class AIEntity extends Entity {

    public AIEntity(Shape shape) {
        super(shape);
    }
    
    public abstract void update(int delta);

}

package retaliation.game.entities;

import retaliation.game.geometry.Shape;

public abstract class AIEntity extends Spaceship {

    public AIEntity(Shape shape) {
        super(shape);
    }
    
    public abstract void update(int delta);

}

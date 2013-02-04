package retaliation.game.entities;

import retaliation.game.geometry.Rectangle;

public abstract class AIEntity extends Spaceship {

    public AIEntity(Rectangle shape) {
        super(shape);
    }
    
    public abstract void update(int delta);

}

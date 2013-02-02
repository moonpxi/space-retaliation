package retaliation.game.entities;

import java.util.ArrayList;
import java.util.List;

import retaliation.game.shapes.Shape;

public abstract class Entity {
    
    private Shape shape;
    private final List<EntityMovementListener> movementListeners;

    public Entity(Shape shape) {
        this.shape = shape;
        movementListeners = new ArrayList<EntityMovementListener>();
    }
    
    public Shape getShape() {
        return shape;
    }

    public void move(int xMovement, int yMovement) {
        shape = shape.move(xMovement, yMovement);
        for (EntityMovementListener listener : movementListeners) {
            listener.entityMoved(this);
        }
    }

    public void registerMovementListener(EntityMovementListener listener) {
        movementListeners.add(listener);
    }
}

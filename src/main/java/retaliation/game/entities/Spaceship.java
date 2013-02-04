package retaliation.game.entities;

import java.util.ArrayList;
import java.util.List;

import retaliation.game.geometry.Rectangle;

public class Spaceship {
    
    private Rectangle shape;
    private final List<SpaceshipMovementListener> movementListeners;

    public Spaceship(Rectangle shape) {
        this.shape = shape;
        movementListeners = new ArrayList<SpaceshipMovementListener>();
    }
    
    public Rectangle getShape() {
        return shape;
    }

    public void move(float xMovement, float yMovement) {
        shape = shape.move(xMovement, yMovement);
        for (SpaceshipMovementListener listener : movementListeners) {
            listener.notifyMoved(this);
        }
    }

    public void registerMovementListener(SpaceshipMovementListener listener) {
        movementListeners.add(listener);
    }
}

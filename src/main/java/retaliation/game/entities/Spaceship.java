package retaliation.game.entities;

import java.util.ArrayList;
import java.util.List;

import retaliation.game.geometry.Shape;

public class Spaceship {
    
    private Shape shape;
    private final List<SpaceshipMovementListener> movementListeners;

    public Spaceship(Shape shape) {
        this.shape = shape;
        movementListeners = new ArrayList<SpaceshipMovementListener>();
    }
    
    public Shape getShape() {
        return shape;
    }

    public void move(int xMovement, int yMovement) {
        shape = shape.move(xMovement, yMovement);
        for (SpaceshipMovementListener listener : movementListeners) {
            listener.notifyMoved(this);
        }
    }

    public void registerMovementListener(SpaceshipMovementListener listener) {
        movementListeners.add(listener);
    }
}

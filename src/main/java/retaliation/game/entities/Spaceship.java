package retaliation.game.entities;

import java.util.ArrayList;
import java.util.List;

import retaliation.game.entities.listener.SpaceshipMovementListener;
import retaliation.game.geometry.Dimension;
import retaliation.game.geometry.Position;

public class Spaceship {
    
    private final List<SpaceshipMovementListener> movementListeners;
    private final Dimension dimension;
    private Position position;

    public Spaceship(Position position, Dimension dimension) {
        this.position = position;
        this.dimension = dimension;
        movementListeners = new ArrayList<SpaceshipMovementListener>();
    }

    public void move(float xMovement, float yMovement) {
        position = Position.at(position.x() + xMovement, position.y() + yMovement);
        for (SpaceshipMovementListener listener : movementListeners) {
            listener.notifyMoved(this);
        }
    }
    
    public void shoot() {
        System.out.println("Shooting");
    }

    public void registerMovementListener(SpaceshipMovementListener listener) {
        movementListeners.add(listener);
    }

    public Position position() {
        return position;
    }

    public Dimension dimension() {
        return dimension;
    }
}

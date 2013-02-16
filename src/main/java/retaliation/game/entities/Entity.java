package retaliation.game.entities;

import retaliation.game.entities.listener.MovementListener;
import retaliation.game.geometry.Dimension;
import retaliation.game.geometry.Position;

import java.util.ArrayList;
import java.util.List;

public class Entity {

    private final EntityType type;
    private Position position;
    private final Dimension dimension;
    private final List<MovementListener> movementListeners;

    public Entity(EntityType type, Position position, Dimension dimension) {
        this.type = type;
        this.position = position;
        this.dimension = dimension;
        movementListeners = new ArrayList<MovementListener>();
    }
    
    public void move(float xMovement, float yMovement) {
        position = Position.at(position.x() + xMovement, position.y() + yMovement);
        for (MovementListener listener : movementListeners) {
            listener.notifyMoved(this);
        }
    }
    
    public Position position() {
        return position;
    }

    public Dimension dimension() {
        return dimension;
    }

    public void registerMovementListener(MovementListener listener) {
        movementListeners.add(listener);
    }
}

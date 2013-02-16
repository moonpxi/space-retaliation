package retaliation.game.entities;

import retaliation.game.geometry.Dimension;
import retaliation.game.geometry.Position;

public class Entity {

    private final EntityType type;
    private Position position;
    private final Dimension dimension;

    public Entity(EntityType type, Position position, Dimension dimension) {
        this.type = type;
        this.position = position;
        this.dimension = dimension;
    }
    
    public void move(float xMovement, float yMovement) {
        position = Position.at(position.x() + xMovement, position.y() + yMovement);
    }
    
    public Position position() {
        return position;
    }

    public Dimension dimension() {
        return dimension;
    }

    public EntityType getType() {
        return type;
    }
}

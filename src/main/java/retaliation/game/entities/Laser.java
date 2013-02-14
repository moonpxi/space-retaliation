package retaliation.game.entities;

import retaliation.game.geometry.Dimension;
import retaliation.game.geometry.Position;

public class Laser {
    
    private Position position;
    private final Dimension dimension;

    // TODO is laser parent of spaceship?
    public Laser(Position position, Dimension dimension) {
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

}

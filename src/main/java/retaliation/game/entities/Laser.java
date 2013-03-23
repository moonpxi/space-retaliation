package retaliation.game.entities;

import retaliation.game.geometry.Position;

import static retaliation.game.entities.Laser.Direction.Upwards;
import static retaliation.game.geometry.Dimension.size;

public class Laser extends Entity {

    public enum Direction { Upwards, Downwards}

    private final Direction direction;

    public Laser(Position position, Direction direction) {
        super(EntityType.Laser, position, size(1, 4));
        this.direction = direction;
    }

    public void fly(float speed) {
        float adjustedSpeed = direction == Upwards ? -speed : speed;
        move(0, adjustedSpeed);
    }

    public Direction direction() {
        return direction;
    }
}

package retaliation.game.entities;

import retaliation.game.geometry.Position;

import static retaliation.game.geometry.Dimension.size;

public class Laser extends Entity {

    public Laser(Position position) {
        super(EntityType.Laser, position, size(1, 4));
    }
}

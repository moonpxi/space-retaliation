package retaliation.game.rules;

import retaliation.game.entities.Entities;
import retaliation.game.entities.Entity;
import retaliation.game.geometry.Rectangle;

import static retaliation.game.entities.Entity.State.Destroyed;
import static retaliation.game.entities.EntityType.Laser;

public class DestroyOutOfBoundaryLasersRule implements Rule {

    private final Rectangle boundary;

    public DestroyOutOfBoundaryLasersRule(Rectangle boundary) {
        this.boundary = boundary;
    }

    @Override
    public void apply(Entities entities) {
        for (Entity laser : entities.filterByType(Laser)) {
            if (laser.position().y() > boundary.getTopmostY() || laser.position().y() < boundary.getY()) {
                laser.changeTo(Destroyed);
            }
        }
    }
}

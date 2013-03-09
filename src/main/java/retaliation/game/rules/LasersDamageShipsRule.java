package retaliation.game.rules;

import retaliation.game.entities.Entities;
import retaliation.game.entities.Entity;
import retaliation.game.entities.Spaceship;

import static retaliation.game.entities.Entity.State.Destroyed;
import static retaliation.game.entities.EntityType.Laser;

public class LasersDamageShipsRule implements Rule {

    @Override public void apply(Entities entities) {
        Iterable<Entity> lasers = entities.filterByType(Laser);
        Iterable<Spaceship> ships = entities.allShips();

        for (Entity laser : lasers) {
            for (Spaceship ship : ships) {
                if (laser.collideWith(ship)) {
                    ship.takeHit();
                    laser.changeTo(Destroyed);
                }
            }
        }
    }
}

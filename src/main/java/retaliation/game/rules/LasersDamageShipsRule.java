package retaliation.game.rules;

import retaliation.game.entities.Entities;
import retaliation.game.entities.Laser;
import retaliation.game.entities.Spaceship;

import static retaliation.game.entities.Entity.State.Destroyed;
import static retaliation.game.entities.Laser.Direction.Upwards;

public class LasersDamageShipsRule implements Rule {

    @Override public void apply(Entities entities) {
        Iterable<Laser> lasers = entities.allLasers();
        Iterable<Spaceship> ships = entities.allShips();

        for (Laser laser : lasers) {
            for (Spaceship ship : ships) {
                if (laser.collideWith(ship) && laser.direction() == Upwards) {
                    ship.takeHit();
                    laser.changeTo(Destroyed);
                }
            }
        }
    }
}

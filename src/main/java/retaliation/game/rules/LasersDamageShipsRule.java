package retaliation.game.rules;

import retaliation.game.entities.Entities;
import retaliation.game.entities.Laser;
import retaliation.game.entities.Spaceship;

import static retaliation.game.entities.Entity.State.Destroyed;
import static retaliation.game.entities.EntityType.Enemy;
import static retaliation.game.entities.EntityType.Player;
import static retaliation.game.entities.Laser.Direction.Downwards;
import static retaliation.game.entities.Laser.Direction.Upwards;

public class LasersDamageShipsRule implements Rule {

    @Override public void apply(Entities entities) {
        Iterable<Laser> lasers = entities.allLasers();
        Iterable<Spaceship> ships = entities.allShips();

        for (Laser laser : lasers) {
            for (Spaceship ship : ships) {
                if (laserDestroysShip(laser, ship)) {
                    ship.takeHit();
                    laser.changeTo(Destroyed);
                }
            }
        }
    }

    private boolean laserDestroysShip(Laser laser, Spaceship ship) {
        return laser.collideWith(ship) &&
               ((ship.getType() == Enemy && laser.direction() == Upwards) ||
                (ship.getType() == Player && laser.direction() == Downwards));
    }
}

package retaliation.game.rules;

import org.junit.Test;
import retaliation.game.entities.*;
import retaliation.game.entities.listener.EntityListener;
import retaliation.game.geometry.Dimension;
import retaliation.game.geometry.Position;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static retaliation.game.entities.Entity.State.Alive;
import static retaliation.game.entities.Entity.State.Destroyed;
import static retaliation.game.entities.EntityType.Enemy;
import static retaliation.game.entities.Laser.Direction.Downwards;
import static retaliation.game.entities.Laser.Direction.Upwards;
import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

public class LasersDamageShipsRuleTest {

    private final Entities entities = new Entities(EntityListener.NULL_LISTENER);

    @Test public void
    laserHitsAShip() {
        Entity laser = laser(at(20, 20), Upwards);
        Spaceship ship = ship(Enemy, at(10, 10), size(50, 50));

        new LasersDamageShipsRule().apply(entities);

        assertThat(ship.state(), is(Destroyed));
        assertThat(laser.state(), is(Destroyed));
    }

    @Test public void
    laserMissesAShip() {
        Entity laser = laser(at(20, 20), Upwards);
        Spaceship ship = ship(Enemy, at(30, 30), size(50, 50));

        new LasersDamageShipsRule().apply(entities);

        assertThat(ship.state(), is(Alive));
        assertThat(laser.state(), is(Alive));
    }

    @Test public void
    aFewShipsHitAndMissed() {
        laser(at(10, 10), Upwards); laser(at(20, 24), Upwards); laser(at(50, 55), Upwards);
        Spaceship hit = ship(Enemy, at(10, 15), size(30, 30));
        Spaceship alsoHit = ship(Enemy, at(43, 10), size(100, 100));
        Spaceship missed = ship(Enemy, at(100, 105), size(30, 30));

        new LasersDamageShipsRule().apply(entities);

        assertThat(hit.state(), is(Destroyed));
        assertThat(alsoHit.state(), is(Destroyed));
        assertThat(missed.state(), is(Alive));
    }

    @Test public void
    onlyUpwardLasersDestroyEnemiesAndDownwardLasersDestroyPlayer() {
        Laser upwardsOnEnemy = laser(at(10, 10), Upwards);
        Spaceship enemyDestroyed = ship(Enemy, at(0, 0), size(20, 20));
        Laser downwardsOnEnemy = laser(at(50, 10), Downwards);
        Spaceship enemyAlive = ship(Enemy, at(40, 0), size(20, 20));

        new LasersDamageShipsRule().apply(entities);

        assertThat(enemyDestroyed.state(), is(Destroyed));
        assertThat(enemyAlive.state(), is(Alive));
    }

    private Laser laser(Position position, Laser.Direction direction) {
        Laser laser = new Laser(position, direction);
        entities.add(laser);
        return laser;
    }

    private Spaceship ship(EntityType type, Position position, Dimension dimension) {
        Spaceship spaceship = new Spaceship(type, position, dimension);
        entities.add(spaceship);
        return spaceship;
    }
}

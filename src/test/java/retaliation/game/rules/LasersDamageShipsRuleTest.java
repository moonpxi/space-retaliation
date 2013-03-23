package retaliation.game.rules;

import org.junit.Test;
import retaliation.game.entities.Entities;
import retaliation.game.entities.Entity;
import retaliation.game.entities.Laser;
import retaliation.game.entities.Spaceship;
import retaliation.game.entities.listener.EntityListener;
import retaliation.game.geometry.Dimension;
import retaliation.game.geometry.Position;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static retaliation.game.entities.Entity.State.Alive;
import static retaliation.game.entities.Entity.State.Destroyed;
import static retaliation.game.entities.EntityType.Enemy;
import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

public class LasersDamageShipsRuleTest {

    private final Entities entities = new Entities(EntityListener.NULL_LISTENER);

    @Test public void
    laserHitsAShip() {
        Entity laser = laser(at(20, 20));
        Spaceship ship = ship(at(10, 10), size(50, 50));

        new LasersDamageShipsRule().apply(entities);

        assertThat(ship.state(), is(Destroyed));
        assertThat(laser.state(), is(Destroyed));
    }

    @Test public void
    laserMissesAShip() {
        Entity laser = laser(at(20, 20));
        Spaceship ship = ship(at(30, 30), size(50, 50));

        new LasersDamageShipsRule().apply(entities);

        assertThat(ship.state(), is(Alive));
        assertThat(laser.state(), is(Alive));
    }

    @Test public void
    aFewShipsHitAndMissed() {
        laser(at(10, 10)); laser(at(20, 24)); laser(at(50, 55));
        Spaceship hit = ship(at(10, 15), size(30, 30));
        Spaceship alsoHit = ship(at(43, 10), size(100, 100));
        Spaceship missed = ship(at(100, 105), size(30, 30));

        new LasersDamageShipsRule().apply(entities);

        assertThat(hit.state(), is(Destroyed));
        assertThat(alsoHit.state(), is(Destroyed));
        assertThat(missed.state(), is(Alive));
    }

    private Entity laser(Position position) {
        Entity laser = new Laser(position);
        entities.add(laser);
        return laser;
    }

    private Spaceship ship(Position position, Dimension dimension) {
        Spaceship spaceship = new Spaceship(Enemy, position, dimension);
        entities.add(spaceship);
        return spaceship;
    }
}

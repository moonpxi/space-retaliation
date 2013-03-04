package retaliation.game.rules;

import org.junit.Test;
import retaliation.game.entities.Entities;
import retaliation.game.entities.Spaceship;
import retaliation.game.entities.listener.EntityListener;

import static retaliation.game.entities.EntityType.Enemy;
import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

public class LasersDamageShipsRuleTest {

    @Test public void
    laserHitsAShip() {
        Entities entities = new Entities(EntityListener.NULL_LISTENER);
        entities.add(new Spaceship(Enemy, at(10, 10), size(50, 50)));
        entities.fired(at(20, 20));

        new LasersDamageShipsRule().apply(entities);
    }
}

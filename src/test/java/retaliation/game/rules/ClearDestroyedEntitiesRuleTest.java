package retaliation.game.rules;

import org.junit.Test;
import retaliation.game.entities.*;
import retaliation.game.entities.listener.EntityListener;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;
import static retaliation.game.entities.Entity.State.Alive;
import static retaliation.game.entities.Entity.State.Destroyed;
import static retaliation.game.entities.EntityType.Enemy;
import static retaliation.game.entities.EntityType.Player;
import static retaliation.game.entities.Laser.Direction.Upwards;
import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

public class ClearDestroyedEntitiesRuleTest {

    private final Entities entities = new Entities(EntityListener.NULL_LISTENER);

    @Test
    public void
    removeAllEntitiesWithDestroyedStatus() {
        Spaceship playerAlive = ship(Player, Alive);
        ship(Enemy, Destroyed);
        Spaceship liveEnemy = ship(Enemy, Alive);
        Entity laser = laser(Alive);
        laser(Destroyed);

        new ClearDestroyedEntitiesRule().apply(entities);

        assertThat(entities.activeEntities(), containsInAnyOrder(playerAlive, liveEnemy, laser));
    }

    private Entity laser(Entity.State state) {
        Entity laser = new Laser(at(10, 10), Upwards);
        laser.changeTo(state);
        entities.add(laser);
        return laser;
    }

    private Spaceship ship(EntityType type, Entity.State state) {
        Spaceship spaceship = new Spaceship(type, at(10, 10), size(100, 100));
        spaceship.changeTo(state);
        entities.add(spaceship);
        return spaceship;
    }
}

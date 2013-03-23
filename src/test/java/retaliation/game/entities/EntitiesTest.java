package retaliation.game.entities;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;
import retaliation.game.entities.listener.EntityListener;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static retaliation.game.entities.Entity.State.Destroyed;
import static retaliation.game.entities.EntityType.*;
import static retaliation.game.entities.EntityType.Laser;
import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

public class EntitiesTest {
    private final Mockery context = new Mockery();
    private final EntityListener listener = context.mock(EntityListener.class);

    private final Laser laser = new Laser(at(10, 10));
    private final Spaceship player = new Spaceship(Player, at(20, 20), size(200, 30));
    private final Spaceship enemy = new Spaceship(Enemy, at(30, 30), size(300, 40));

    @Test public void
    returnsListOfAllActiveEntities() {
        Entities entities = entitiesIgnoreListener();
        entities.add(laser);
        entities.add(player);
        entities.add(enemy);

        assertThat(entities.activeEntities(), contains(laser, player, enemy));
    }

    @Test public void
    notifiesListenerWhenEntityCreated() {
        context.checking(new Expectations() {{
            oneOf(listener).laserCreated(laser);
        }});

        new Entities(listener).add(laser);

        context.assertIsSatisfied();
    }

    @Test public void
    notifiesListenerWhenEntityDestroyed() {
        context.checking(new Expectations() {{
            oneOf(listener).entityDestroyed(laser);

            allowing(listener);
        }});


        Entities entities = new Entities(listener);
        laser.changeTo(Destroyed);
        entities.add(laser);

        entities.clearDestroyed();

        context.assertIsSatisfied();
    }

    @Test public void
    notifiesListenerWhenSpaceshipCreated() {
        context.checking(new Expectations() {{
            oneOf(listener).spaceshipCreated(player);
        }});

        new Entities(listener).add(player);

        context.assertIsSatisfied();
    }

    @Test public void
    createsLaserWhenFired() {
        Entities entities = entitiesIgnoreListener();

        entities.fired(at(20, 20));

        assertThat(entities.activeEntities(), contains(hasProperty("type", equalTo(Laser))));
    }

    @Test public void
    getsPlayerShip() {
        Entities entities = entitiesIgnoreListener();
        entities.add(enemy);
        entities.add(player);
        entities.add(enemy);

        assertThat(entities.playerShip(), equalTo(player));
    }

    @Test public void
    filterEntitiesByType() {
        Entities entities = entitiesIgnoreListener();
        Entity anotherLaser = new Laser(null);
        entities.add(laser);
        entities.add(enemy);
        entities.add(player);
        entities.add(anotherLaser);

        assertThat(entities.filterByType(Laser), contains(laser, anotherLaser));
    }

    private Entities entitiesIgnoreListener() {
        context.checking(new Expectations() {{
            allowing(listener);
        }});

        return new Entities(listener);
    }

}

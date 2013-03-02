package retaliation.game.entities;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;
import retaliation.game.entities.listener.EntityListener;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static retaliation.game.entities.EntityType.*;
import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

public class EntitiesTest {
    private final Mockery context = new Mockery();
    private final EntityListener listener = context.mock(EntityListener.class);

    private final Entity laser = new Entity(Laser, at(10, 10), size(100, 20));
    private final Spaceship player = new Spaceship(Player, at(20, 20), size(200, 30));
    private final Spaceship enemy = new Spaceship(Enemy, at(30, 30), size(300, 40));

    @Test public void
    returnsListOfAllActiveEntities() {
        context.checking(new Expectations() {{
            allowing(listener);
        }});

        Entities entities = new Entities(listener);
        entities.add(laser);
        entities.add(player);
        entities.add(enemy);

        assertThat(entities.activeEntities(), contains(laser, player, enemy));
    }

    @Test public void
    notifiesListenerWhenEntityCreated() {
        context.checking(new Expectations() {{
            oneOf(listener).entityCreated(laser);
        }});

        new Entities(listener).add(laser);

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
        context.checking(new Expectations() {{
            allowing(listener);
        }});

        Entities entities = new Entities(listener);
        entities.fired(at(20, 20));

        assertThat(entities.activeEntities(), contains(hasProperty("type", equalTo(Laser))));
    }
}

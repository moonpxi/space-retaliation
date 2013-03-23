package retaliation.game.rules;

import org.junit.Test;
import retaliation.game.entities.Entities;
import retaliation.game.entities.Entity;
import retaliation.game.entities.Laser;
import retaliation.game.entities.listener.EntityListener;
import retaliation.game.geometry.Position;
import retaliation.game.geometry.Rectangle;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static retaliation.game.entities.Entity.State.Alive;
import static retaliation.game.entities.Entity.State.Destroyed;
import static retaliation.game.entities.Laser.Direction.Upwards;
import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

public class DestroyOutOfBoundaryLasersRuleTest {
    private final Entities entities = new Entities(EntityListener.NULL_LISTENER);

    @Test public void
    destroyLasersOutOfBounds() {
        Entity outOfBoundsAtTop = laser(at(30, 30));
        Entity outOfBoundsAtBottom = laser(at(10, 2));
        Entity inBounds = laser(at(10, 10));

        new DestroyOutOfBoundaryLasersRule(new Rectangle(at(0, 5), size(100, 20))).apply(entities);

        assertThat(outOfBoundsAtTop.state(), is(Destroyed));
        assertThat(outOfBoundsAtBottom.state(), is(Destroyed));
        assertThat(inBounds.state(), is(Alive));
    }

    private Entity laser(Position position) {
        Entity laser = new Laser(position, Upwards);
        entities.add(laser);
        return laser;
    }
}

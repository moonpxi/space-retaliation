package retaliation.game.entities;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static retaliation.game.entities.Entity.State.Alive;
import static retaliation.game.entities.Entity.State.Destroyed;
import static retaliation.game.entities.EntityType.Player;
import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

public class EntityTest {

    private final Entity entity = new Entity(Player, at(5, 8), size(10, 10));

    @Test
    public void movesRelativeToAdjustment() {
        entity.move(15, 42);

        assertThat(entity.position().x(), equalTo(20f));
        assertThat(entity.position().y(), equalTo(50f));
    }

    @Test public void
    isAliveWhenCreated() {
        assertThat(entity.state(), is(Alive));
    }

    @Test public void
    canChangeToAnotherState() {
        entity.changeTo(Destroyed);

        assertThat(entity.state(), is(Destroyed));
    }
}

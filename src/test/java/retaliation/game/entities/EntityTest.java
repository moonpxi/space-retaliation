package retaliation.game.entities;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;
import retaliation.game.entities.listener.MovementListener;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static retaliation.game.entities.EntityType.Player;
import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

public class EntityTest {
    private final Mockery context = new Mockery();
    private final MovementListener listener = context.mock(MovementListener.class, "ML1");
    private final MovementListener anotherListener = context.mock(MovementListener.class, "ML2");

    @Test
    public void movesRelativeToAdjustmentAndNotifiesMovementListeners() {
        final Entity entity = new Entity(Player, at(5, 8), size(10, 10));

        entity.registerMovementListener(listener);
        entity.registerMovementListener(anotherListener);

        context.checking(new Expectations() {{
            oneOf(listener).notifyMoved(entity);
            oneOf(anotherListener).notifyMoved(entity);
        }});

        entity.move(15, 42);

        assertThat(entity.position().x(), equalTo(20f));
        assertThat(entity.position().y(), equalTo(50f));

        context.assertIsSatisfied();
    }
}

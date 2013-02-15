package retaliation.game.entities;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;
import retaliation.game.entities.listener.MovementListener;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

public class MoveableTest {
    private final Mockery context = new Mockery();
    private final MovementListener listener = context.mock(MovementListener.class, "ML1");
    private final MovementListener anotherListener = context.mock(MovementListener.class, "ML2");

    @Test
    public void movesRelativeToAdjustmentAndNotifiesMovementListeners() {
        final Moveable moveable = new Moveable(at(5, 8), size(10, 10));

        moveable.registerMovementListener(listener);
        moveable.registerMovementListener(anotherListener);

        context.checking(new Expectations() {{
            oneOf(listener).notifyMoved(moveable);
            oneOf(anotherListener).notifyMoved(moveable);
        }});

        moveable.move(15, 42);

        assertThat(moveable.position().x(), equalTo(20f));
        assertThat(moveable.position().y(), equalTo(50f));

        context.assertIsSatisfied();
    }
}

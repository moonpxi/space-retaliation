package retaliation.game.entities;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

public class SpaceshipTest {
    private final Mockery context = new Mockery();
    private final SpaceshipMovementListener listener = context.mock(SpaceshipMovementListener.class, "ML1");
    private final SpaceshipMovementListener anotherListener = context.mock(SpaceshipMovementListener.class, "ML2");

    @Test
    public void movesRelativeToAdjustmentAndNotifiesListeners() {
        final Spaceship ship = new Spaceship(at(5, 8), size(10, 10));
        
        ship.registerMovementListener(listener);
        ship.registerMovementListener(anotherListener);
        
        context.checking(new Expectations() {{
            oneOf(listener).notifyMoved(ship);
            oneOf(anotherListener).notifyMoved(ship);
        }});
        
        ship.move(15, 42);
        
        assertThat(ship.position().x(), equalTo(20f));
        assertThat(ship.position().y(), equalTo(50f));
        
        context.assertIsSatisfied();
    }
   
}

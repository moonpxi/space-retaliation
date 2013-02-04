package retaliation.game.entities;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import retaliation.game.geometry.Shape;

public class SpaceshipTest {
    private final Mockery context = new Mockery();
    private final SpaceshipMovementListener listener = context.mock(SpaceshipMovementListener.class, "ML1");
    private final SpaceshipMovementListener anotherListener = context.mock(SpaceshipMovementListener.class, "ML2");

    @Test
    public void notifiesListenersWhenItMoves() {
        final Spaceship ship = new Spaceship(new Shape(0, 0, 10, 10));
        ship.registerMovementListener(listener);
        ship.registerMovementListener(anotherListener);
        
        context.checking(new Expectations() {{
            oneOf(listener).notifyMoved(ship);
            oneOf(anotherListener).notifyMoved(ship);
        }});
        
        ship.move(15, 42);
        
        context.assertIsSatisfied();
    }
   
}

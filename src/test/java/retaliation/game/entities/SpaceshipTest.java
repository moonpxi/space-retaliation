package retaliation.game.entities;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import retaliation.game.geometry.Dimension;
import retaliation.game.geometry.Position;
import retaliation.game.geometry.Rectangle;

public class SpaceshipTest {
    private final Mockery context = new Mockery();
    private final SpaceshipMovementListener listener = context.mock(SpaceshipMovementListener.class, "ML1");
    private final SpaceshipMovementListener anotherListener = context.mock(SpaceshipMovementListener.class, "ML2");

    @Test
    public void notifiesListenersWhenItMoves() {
        final Spaceship ship = new Spaceship(new Rectangle(Position.at(0, 0), Dimension.size(10, 10)));
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

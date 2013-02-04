package retaliation.game.entities;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import retaliation.game.geometry.Rectangle;

public class SpaceshipTest {
    private final Mockery context = new Mockery();
    private final SpaceshipMovementListener listener = context.mock(SpaceshipMovementListener.class, "ML1");
    private final SpaceshipMovementListener anotherListener = context.mock(SpaceshipMovementListener.class, "ML2");

    @Test
    public void returnsShapeWithFightersDimension() {
        Rectangle rect = new Spaceship(new Rectangle(at(30, 50), size(100, 20))).getShape();
        
        assertThat(rect.getX(), is(30f));
        assertThat(rect.getY(), is(50f));
        assertThat(rect.getWidth(), is(100f));
        assertThat(rect.getHeight(), is(20f));
    }

    
    @Test
    public void notifiesListenersWhenItMoves() {
        final Spaceship ship = new Spaceship(new Rectangle(at(0, 0), size(10, 10)));
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

package retaliation.game.entities;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import retaliation.game.entities.listener.SpaceshipMovementListener;
import retaliation.game.entities.listener.SpaceshipShootingListener;

public class SpaceshipTest {
    private final Mockery context = new Mockery();
    private final SpaceshipMovementListener listener = context.mock(SpaceshipMovementListener.class, "ML1");
    private final SpaceshipMovementListener anotherListener = context.mock(SpaceshipMovementListener.class, "ML2");
    private final SpaceshipShootingListener shootingListener = context.mock(SpaceshipShootingListener.class);

    @Test
    public void movesRelativeToAdjustmentAndNotifiesMovementListeners() {
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
    
    @Test 
    public void notifiesShootingListenerWhenShooting() {
        final Spaceship ship = new Spaceship(at(5, 8), size(10, 10));
        
        ship.registerShootingListener(shootingListener);
        
        context.checking(new Expectations() {{
            oneOf(shootingListener).fired(at(10, 7));
        }});
        
        ship.shoot();
        
        context.assertIsSatisfied();
    }
   
}

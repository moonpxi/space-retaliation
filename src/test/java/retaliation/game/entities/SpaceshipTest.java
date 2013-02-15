package retaliation.game.entities;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;
import retaliation.game.entities.listener.SpaceshipShootingListener;

import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

public class SpaceshipTest {
    private final Mockery context = new Mockery();
    private final SpaceshipShootingListener shootingListener = context.mock(SpaceshipShootingListener.class);

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

package retaliation.game.entities;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;
import retaliation.game.entities.listener.SpaceshipShootingListener;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static retaliation.game.entities.EntityType.Player;
import static retaliation.game.entities.Spaceship.State.Alive;
import static retaliation.game.entities.Spaceship.State.Destroyed;
import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

public class SpaceshipTest {
    private final Mockery context = new Mockery();
    private final SpaceshipShootingListener shootingListener = context.mock(SpaceshipShootingListener.class);
    private Spaceship ship;

    @Before
    public void createShip() {
        ship = new Spaceship(Player, at(5, 8), size(10, 10));
    }

    @Test
    public void notifiesShootingListenerWhenShooting() {
        ship.registerShootingListener(shootingListener);
        
        context.checking(new Expectations() {{
            oneOf(shootingListener).fired(at(10, 7));
        }});
        
        ship.shoot();
        
        context.assertIsSatisfied();
    }

    @Test public void
    isAliveWhenCreated() {
        assertThat(ship.state(), is(Alive));
    }

    @Test public void
    isDestroyedWhenItTakesAHit() {
        ship.takeHit();

        assertThat(ship.state(), is(Destroyed));
    }
   
}

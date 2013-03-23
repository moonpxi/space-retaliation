package retaliation.game.entities;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;
import retaliation.game.entities.listener.SpaceshipShootingListener;

import static java.lang.Thread.sleep;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static retaliation.game.entities.Entity.State.Destroyed;
import static retaliation.game.entities.EntityType.Player;
import static retaliation.game.entities.Laser.Direction.Upwards;
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
        expectFiredNotificationsOnly(1, Upwards);
        
        ship.shoot();
        
        context.assertIsSatisfied();
    }


    @Test public void
    limitRateOfFire() {
        expectFiredNotificationsOnly(1, Upwards);

        ship.shoot();
        ship.shoot();

        context.assertIsSatisfied();
    }

    @Test public void
    allowAnotherShotAfterCooldownPeriod() throws InterruptedException {
        expectFiredNotificationsOnly(2, Upwards);

        ship.shoot();
        sleep(1000); // Yes, this is horrible.
        ship.shoot();

        context.assertIsSatisfied();
    }

    @Test public void
    isDestroyedWhenItTakesAHit() {
        ship.takeHit();

        assertThat(ship.state(), is(Destroyed));
    }

    private void expectFiredNotificationsOnly(final int times, final Laser.Direction direction) {
        ship.registerShootingListener(shootingListener);

        context.checking(new Expectations() {{
            exactly(times).of(shootingListener).fired(at(10, 7), direction);
        }});
    }
}

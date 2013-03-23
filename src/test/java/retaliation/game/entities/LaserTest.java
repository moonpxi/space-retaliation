package retaliation.game.entities;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static retaliation.game.entities.Laser.Direction.Downwards;
import static retaliation.game.entities.Laser.Direction.Upwards;
import static retaliation.game.geometry.Position.at;

public class LaserTest {

    @Test public void
    laserFliesUpwardsAtGivenSpeed() {
        Laser laser = new Laser(at(0, 0), Upwards);

        laser.fly(5);

        assertThat(laser.position(), equalTo(at(0, -5)));
    }

    @Test public void
    laserFliesDownwardsAtGivenSpeed() {
        Laser laser = new Laser(at(0, 0), Downwards);

        laser.fly(5);

        assertThat(laser.position(), equalTo(at(0, 5)));
    }
}

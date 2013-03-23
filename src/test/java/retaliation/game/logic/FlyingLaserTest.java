package retaliation.game.logic;

import org.junit.Test;
import retaliation.game.entities.Laser;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static retaliation.game.geometry.Position.at;

public class FlyingLaserTest {

    @Test public void
    laserFliesAtConstantSpeed() {
        Laser laser = new Laser(at(0, 0));

        new FlyingLaser(laser).update(null, 0);

        assertThat(laser.position(), equalTo(at(0, -4)));
    }
}

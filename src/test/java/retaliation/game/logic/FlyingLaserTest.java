package retaliation.game.logic;

import org.junit.Test;
import retaliation.game.entities.Entity;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static retaliation.game.entities.EntityType.Laser;
import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

public class FlyingLaserTest {

    @Test public void
    laserFliesAtConstantSpeed() {
        Entity laser = new Entity(Laser, at(0, 0), size(2, 2));

        new FlyingLaser(laser).update(null, 0);

        assertThat(laser.position(), equalTo(at(0, -4)));
    }
}

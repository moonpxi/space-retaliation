package retaliation.game.entities;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

import org.junit.Test;

public class LaserTest {


    @Test
    public void movesRelativeToAdjustment() {
        final Laser laser = new Laser(at(5, 8), size(10, 10));
        
        laser.move(15, 42);
        
        assertThat(laser.position().x(), equalTo(20f));
        assertThat(laser.position().y(), equalTo(50f));
    }
}

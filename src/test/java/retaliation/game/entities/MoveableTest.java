package retaliation.game.entities;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

import org.junit.Test;

public class MoveableTest {


    @Test
    public void movesRelativeToAdjustment() {
        final Moveable moveable = new Moveable(at(5, 8), size(10, 10));
        
        moveable.move(15, 42);
        
        assertThat(moveable.position().x(), equalTo(20f));
        assertThat(moveable.position().y(), equalTo(50f));
    }
}

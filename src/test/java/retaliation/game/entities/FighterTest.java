package retaliation.game.entities;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import retaliation.game.geometry.Rectangle;

public class FighterTest {

    @Test
    public void returnsShapeWithFightersDimension() {
        Rectangle shape = new Fighter(30, 50).getShape();
        
        assertThat(shape.getX(), is(30f));
        assertThat(shape.getY(), is(50f));
        assertThat(shape.getWidth(), is(100f));
        assertThat(shape.getHeight(), is(20f));
    }

}

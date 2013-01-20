package retaliation.game.entities;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import retaliation.game.shapes.Quad;

public class FighterTest {

    @Test
    public void returnsShapeWithFightersDimension() {
        Quad shape = new Fighter(30, 50).getShape();
        
        assertThat(shape.getX(), is(30));
        assertThat(shape.getY(), is(50));
        assertThat(shape.getWidth(), is(100));
        assertThat(shape.getHeight(), is(20));
    }

}

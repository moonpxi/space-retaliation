package retaliation.game.shapes;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ShapeTest {

    @Test
    public void movingQuadIsAnImmutableOperation() {
        Shape startingQuad = new Shape(10, 20, 30, 40);
        
        Shape movedQuad = startingQuad.move(1, 2);
        
        assertThat(startingQuad.getX(), equalTo(10));
        assertThat(startingQuad.getY(), equalTo(20));
        
        assertThat(movedQuad.getX(), equalTo(11));
        assertThat(movedQuad.getY(), equalTo(22));
    }
   
}

package retaliation.game.geometry;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import retaliation.game.geometry.Shape;

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
    
    @Test
    public void calculateRightmostXAndTopmostY() {
        Shape shape = new Shape(10, 20, 100, 200);
        
        assertThat(shape.getRightmostX(), equalTo(110));
        assertThat(shape.getTopmostY(), equalTo(220));
    }
   
}

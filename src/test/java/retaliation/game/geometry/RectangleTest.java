package retaliation.game.geometry;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RectangleTest {

    @Test
    public void movingQuadIsAnImmutableOperation() {
        Rectangle startingQuad = new Rectangle(Position.at(10, 20), Dimension.size(30, 40));
        
        Rectangle movedQuad = startingQuad.move(1, 2);
        
        assertThat(startingQuad.getX(), equalTo(10f));
        assertThat(startingQuad.getY(), equalTo(20f));
        
        assertThat(movedQuad.getX(), equalTo(11f));
        assertThat(movedQuad.getY(), equalTo(22f));
    }
    
    @Test
    public void calculateRightmostXAndTopmostY() {
        Rectangle shape = new Rectangle(Position.at(10, 20), Dimension.size(100, 200));
        
        assertThat(shape.getRightmostX(), equalTo(110f));
        assertThat(shape.getTopmostY(), equalTo(220f));
    }
   
}

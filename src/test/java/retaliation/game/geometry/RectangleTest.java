package retaliation.game.geometry;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

public class RectangleTest {

    @Test
    public void movingRectangleIsAnImmutableOperation() {
        Rectangle startingQuad = new Rectangle(at(10, 20), size(30, 40));
        
        Rectangle movedQuad = startingQuad.move(1, 2);
        
        assertThat(startingQuad.getX(), equalTo(10f));
        assertThat(startingQuad.getY(), equalTo(20f));
        
        assertThat(movedQuad.getX(), equalTo(11f));
        assertThat(movedQuad.getY(), equalTo(22f));
    }
    
    @Test
    public void calculateRightmostXAndTopmostY() {
        Rectangle shape = new Rectangle(at(10, 20), size(100, 200));
        
        assertThat(shape.getRightmostX(), equalTo(110f));
        assertThat(shape.getTopmostY(), equalTo(220f));
    }

    @Test public void
    intersectWithAnotherRectangle() {
        Rectangle rect1 = new Rectangle(at(10, 10), size(50, 50));
        Rectangle rect2 = new Rectangle(at(5, 5), size(10, 10));
        Rectangle rect3 = new Rectangle(at(55, 55), size(10, 10));
        Rectangle innerRect = new Rectangle(at(15, 15), size(10, 10));
        Rectangle outerRect = new Rectangle(at(5, 5), size(70, 70));

        assertThat(rect1.isIntersectedWith(rect2), is(true));
        assertThat(rect1.isIntersectedWith(rect3), is(true));
        assertThat(rect1.isIntersectedWith(innerRect), is(true));
        assertThat(rect1.isIntersectedWith(outerRect), is(true));
    }

    @Test public void
    doesNotIntersectWithOutOfBoundsRectangle() {
        Rectangle rect1 = new Rectangle(at(10, 10), size(50, 50));
        Rectangle rect2 = new Rectangle(at(51, 51), size(10, 10));

        assertThat(rect1.isIntersectedWith(rect2), is(false));
    }

}

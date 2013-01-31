package retaliation.game.shapes;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matcher;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

public class ShapeTest {
    private final Mockery context = new Mockery();
    private final ShapeMovementListener listener = context.mock(ShapeMovementListener.class, "ML1");
    private final ShapeMovementListener anotherListener = context.mock(ShapeMovementListener.class, "ML2");

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
    public void notifiesListenersWhenItMoves() {
        final Shape shape = new Shape(0, 0, 10, 10);
        shape.registerMovementListener(listener);
        shape.registerMovementListener(anotherListener);
        
        context.checking(new Expectations() {{
            Matcher<Shape> shapeAfterMoving = allOf(hasProperty("x", equalTo(15)), 
                                                    hasProperty("y", equalTo(42)));
            
            oneOf(listener).shapeMoved(with(shapeAfterMoving));
            oneOf(anotherListener).shapeMoved(with(shapeAfterMoving));
        }});
        
        shape.move(15, 42);
        
        context.assertIsSatisfied();
    }

}

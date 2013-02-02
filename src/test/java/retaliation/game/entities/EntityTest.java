package retaliation.game.entities;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import retaliation.game.shapes.Shape;

public class EntityTest {
    private final Mockery context = new Mockery();
    private final EntityMovementListener listener = context.mock(EntityMovementListener.class, "ML1");
    private final EntityMovementListener anotherListener = context.mock(EntityMovementListener.class, "ML2");

    @Test
    public void notifiesListenersWhenItMoves() {
        final RealEntity entity = new RealEntity(new Shape(0, 0, 10, 10));
        entity.registerMovementListener(listener);
        entity.registerMovementListener(anotherListener);
        
        context.checking(new Expectations() {{
            oneOf(listener).entityMoved(entity);
            oneOf(anotherListener).entityMoved(entity);
        }});
        
        entity.move(15, 42);
        
        context.assertIsSatisfied();
    }
    
    
    
    private final class RealEntity extends Entity {
        public RealEntity(Shape shape) {
            super(shape);
        }
    }
}

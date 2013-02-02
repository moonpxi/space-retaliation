package retaliation.game.constraints;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import retaliation.game.entities.Entity;
import retaliation.game.shapes.Shape;

public class RestrictEntityToBoundaryTest {

    private final Shape boundary = new Shape(5, 6, 20, 21);
        
    @Test
    public void restrictEntityFromLeavingLeftBoundary() {
        Entity entity = entityAt(2, 10);
        
        whenRestricting(entity);
        
        assertThat(entity.getShape().getX(), equalTo(5));
    }
    
    @Test
    public void restrictEntityFromLeavingRightBoundary() {
        Entity entity = entityAt(28, 10);
        
        whenRestricting(entity);
        
        assertThat(entity.getShape().getX(), equalTo(20));
    }
    
    @Test
    public void restrictEntityFromLeavingBottomBoundary() {
        Entity entity = entityAt(10, 1);
        
        whenRestricting(entity);
        
        assertThat(entity.getShape().getY(), equalTo(6));
    }

    @Test
    public void restrictEntityFromLeavingTopBoundary() {
        Entity entity = entityAt(10, 30);
        
        whenRestricting(entity);
        
        assertThat(entity.getShape().getY(), equalTo(22));
    }
    
    private void whenRestricting(Entity entity) {
        RestrictEntityToBoundary restriction = new RestrictEntityToBoundary(entity, boundary);
        restriction.entityMoved(entity);
    }

    private RealEntity entityAt(int x, int y) {
        return new RealEntity(new Shape(x, y, 5, 5));
    }

    private final class RealEntity extends Entity {
        public RealEntity(Shape shape) {
            super(shape);
        }
    }
}

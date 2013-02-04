package retaliation.game.constraints;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import retaliation.game.entities.Spaceship;
import retaliation.game.geometry.Shape;

public class RestrictEntityToBoundaryTest {

    private final Shape boundary = new Shape(5, 6, 20, 21);
    private final Spaceship entity = new RealEntity(new Shape(10, 10, 5, 5));
    
    @Before
    public void configureRestriction() {
        new RestrictEntityToBoundary(entity, boundary);
    }
    
    @Test
    public void restrictEntityFromLeavingLeftBoundary() {
        whenEntityMovesTo(2, 10);
        
        assertThat(entity.getShape().getX(), equalTo(5));
    }
    
    @Test
    public void restrictEntityFromLeavingRightBoundary() {
        whenEntityMovesTo(28, 10);
        
        assertThat(entity.getShape().getX(), equalTo(20));
    }
    
    @Test
    public void restrictEntityFromLeavingBottomBoundary() {
        whenEntityMovesTo(10, 1);
        
        assertThat(entity.getShape().getY(), equalTo(6));
    }

    @Test
    public void restrictEntityFromLeavingTopBoundary() {
        whenEntityMovesTo(10, 30);
        
        assertThat(entity.getShape().getY(), equalTo(22));
    }
    
    @Test
    public void restrictEntityFromLeavingACornerBoundary() {
        whenEntityMovesTo(2, 30);
        
        assertThat(entity.getShape().getX(), equalTo(5));
        assertThat(entity.getShape().getY(), equalTo(22));
    }
    
    private void whenEntityMovesTo(int x, int y) {
        entity.move(x - entity.getShape().getX(), y - entity.getShape().getY()); 
    }
   
    private final class RealEntity extends Spaceship {
        public RealEntity(Shape shape) {
            super(shape);
        }
    }
}

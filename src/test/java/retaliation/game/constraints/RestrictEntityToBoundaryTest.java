package retaliation.game.constraints;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

import org.junit.Before;
import org.junit.Test;

import retaliation.game.entities.Spaceship;
import retaliation.game.geometry.Rectangle;

public class RestrictEntityToBoundaryTest {

    private final Rectangle boundary = new Rectangle(at(5, 6), size(20, 21));
    private final Spaceship entity = new RealEntity(new Rectangle(at(10, 10), size(5, 5)));
    
    @Before
    public void configureRestriction() {
        new RestrictEntityToBoundary(entity, boundary);
    }
    
    @Test
    public void restrictEntityFromLeavingLeftBoundary() {
        whenEntityMovesTo(2, 10);
        
        assertThat(entity.getShape().getX(), equalTo(5f));
    }
    
    @Test
    public void restrictEntityFromLeavingRightBoundary() {
        whenEntityMovesTo(28, 10);
        
        assertThat(entity.getShape().getX(), equalTo(20f));
    }
    
    @Test
    public void restrictEntityFromLeavingBottomBoundary() {
        whenEntityMovesTo(10, 1);
        
        assertThat(entity.getShape().getY(), equalTo(6f));
    }

    @Test
    public void restrictEntityFromLeavingTopBoundary() {
        whenEntityMovesTo(10, 30);
        
        assertThat(entity.getShape().getY(), equalTo(22f));
    }
    
    @Test
    public void restrictEntityFromLeavingACornerBoundary() {
        whenEntityMovesTo(2, 30);
        
        assertThat(entity.getShape().getX(), equalTo(5f));
        assertThat(entity.getShape().getY(), equalTo(22f));
    }
    
    private void whenEntityMovesTo(float x, float y) {
        entity.move(x - entity.getShape().getX(), y - entity.getShape().getY()); 
    }
   
    private final class RealEntity extends Spaceship {
        public RealEntity(Rectangle shape) {
            super(shape);
        }
    }
}

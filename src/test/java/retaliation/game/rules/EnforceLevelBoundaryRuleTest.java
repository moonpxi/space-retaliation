package retaliation.game.rules;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

import org.junit.Before;
import org.junit.Test;

import retaliation.game.entities.Spaceship;
import retaliation.game.geometry.Rectangle;
import retaliation.game.rules.EnforceLevelBoundaryRule;

public class EnforceLevelBoundaryRuleTest {

    private final Rectangle boundary = new Rectangle(at(5, 6), size(20, 21));
    private final Spaceship ship = new Spaceship(at(10, 10), size(5, 5));
    
    @Before
    public void configureRestriction() {
        new EnforceLevelBoundaryRule(ship, boundary);
    }
    
    @Test
    public void restrictEntityFromLeavingLeftBoundary() {
        whenEntityMovesTo(2, 10);
        
        assertThat(ship.position().x(), equalTo(5f));
    }
    
    @Test
    public void restrictEntityFromLeavingRightBoundary() {
        whenEntityMovesTo(28, 10);
        
        assertThat(ship.position().x(), equalTo(20f));
    }
    
    @Test
    public void restrictEntityFromLeavingBottomBoundary() {
        whenEntityMovesTo(10, 1);
        
        assertThat(ship.position().y(), equalTo(6f));
    }

    @Test
    public void restrictEntityFromLeavingTopBoundary() {
        whenEntityMovesTo(10, 30);
        
        assertThat(ship.position().y(), equalTo(22f));
    }
    
    @Test
    public void restrictEntityFromLeavingACornerBoundary() {
        whenEntityMovesTo(2, 30);
        
        assertThat(ship.position().x(), equalTo(5f));
        assertThat(ship.position().y(), equalTo(22f));
    }
    
    private void whenEntityMovesTo(float x, float y) {
        ship.move(x - ship.position().x(), y - ship.position().y()); 
    }
   
 }

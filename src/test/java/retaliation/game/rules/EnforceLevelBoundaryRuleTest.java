package retaliation.game.rules;

import org.junit.Before;
import org.junit.Test;
import retaliation.game.entities.Spaceship;
import retaliation.game.geometry.Rectangle;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static retaliation.game.entities.EntityType.Enemy;
import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

public class EnforceLevelBoundaryRuleTest {

    private final Rectangle boundary = new Rectangle(at(5, 6), size(20, 21));
    private EnforceLevelBoundaryRule rule;
    
    @Before
    public void configureRestriction() {
        rule = new EnforceLevelBoundaryRule(boundary, null);
    }
    
    @Test
    public void restrictShipFromLeavingLeftBoundary() {
        Spaceship ship = shipAt(2, 10);
        
        rule.enforceBoundaryOn(ship);
        
        assertThat(ship.position().x(), equalTo(5f));
    }
    
    @Test
    public void restrictShipFromLeavingRightBoundary() {
        Spaceship ship = shipAt(28, 10);
        
        rule.enforceBoundaryOn(ship);
        
        assertThat(ship.position().x(), equalTo(20f));
    }
    
    @Test
    public void restrictShipFromLeavingBottomBoundary() {
        Spaceship ship = shipAt(10, 1);
        
        rule.enforceBoundaryOn(ship);
        
        assertThat(ship.position().y(), equalTo(6f));
    }

    @Test
    public void restrictShipFromLeavingTopBoundary() {
        Spaceship ship = shipAt(10, 30);
        
        rule.enforceBoundaryOn(ship);
        
        assertThat(ship.position().y(), equalTo(22f));
    }
    
    @Test
    public void restrictShipFromLeavingACornerBoundary() {
        Spaceship ship = shipAt(2, 30);
        
        rule.enforceBoundaryOn(ship);
        
        assertThat(ship.position().x(), equalTo(5f));
        assertThat(ship.position().y(), equalTo(22f));
    }
   
    private Spaceship shipAt(float x, float y) {
        return new Spaceship(Enemy, at(x, y), size(5, 5));
    }

 }

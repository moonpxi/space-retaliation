package retaliation.game.rules;

import retaliation.game.entities.Spaceship;
import retaliation.game.geometry.Rectangle;

public class EnforceLevelBoundaryRule {

    private final Rectangle boundary;

    public EnforceLevelBoundaryRule(Rectangle boundary) {
        this.boundary = boundary;
    }
    
    public void enforceBoundaryOn(Spaceship ship) {
        Rectangle newPosition = new Rectangle(ship.position(), ship.dimension());
        
        float xAdjustment = calculateAdjustment(newPosition.getX(), newPosition.getRightmostX(),
                                              boundary.getX(), boundary.getRightmostX()),
              yAdjustment = calculateAdjustment(newPosition.getY(), newPosition.getTopmostY(),
                                              boundary.getY(), boundary.getTopmostY());
                
        if (xAdjustment != 0 || yAdjustment != 0) {
            ship.move(xAdjustment, yAdjustment);
        } 
    }

    private float calculateAdjustment(float lowerPosition, float upperPosition, float lowerBoundary, float upperBoundary) {
        if (lowerPosition < lowerBoundary) {
            return lowerBoundary - lowerPosition;
        } else if (upperPosition > upperBoundary) {
            return upperBoundary - upperPosition;
        }
        return 0;
    }

}

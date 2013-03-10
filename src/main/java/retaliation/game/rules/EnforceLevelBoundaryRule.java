package retaliation.game.rules;

import retaliation.game.entities.Entities;
import retaliation.game.entities.Entity;
import retaliation.game.geometry.Rectangle;

public class EnforceLevelBoundaryRule implements Rule {

    private final Rectangle boundary;

    public EnforceLevelBoundaryRule(Rectangle boundary) {
        this.boundary = boundary;
    }
    
    public void enforceBoundaryOn(Entity ship) {
        Rectangle newPosition = ship.rectangle();
        
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

    @Override
    public void apply(Entities entities) {
        enforceBoundaryOn(entities.playerShip());
    }
}

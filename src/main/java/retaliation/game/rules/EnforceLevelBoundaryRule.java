package retaliation.game.rules;

import retaliation.game.entities.Spaceship;
import retaliation.game.entities.listener.SpaceshipMovementListener;
import retaliation.game.geometry.Rectangle;

public class EnforceLevelBoundaryRule implements SpaceshipMovementListener {

    private final Rectangle boundary;

    public EnforceLevelBoundaryRule(Spaceship entity, Rectangle boundary) {
        this.boundary = boundary;
        entity.registerMovementListener(this);
    }
    
    @Override
    public void notifyMoved(Spaceship ship) {
        enforceBoundaryOn(ship);
    }
    
    public void enforceBoundaryOn(Spaceship ship) {
        // TODO: revise this
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

package retaliation.game.constraints;

import retaliation.game.entities.Spaceship;
import retaliation.game.entities.SpaceshipMovementListener;
import retaliation.game.geometry.Rectangle;

public class RestrictEntityToBoundary implements SpaceshipMovementListener {

    private final Rectangle boundary;

    public RestrictEntityToBoundary(Spaceship entity, Rectangle boundary) {
        this.boundary = boundary;
        entity.registerMovementListener(this);
    }
    
    @Override
    public void notifyMoved(Spaceship entity) {
        Rectangle newPosition = entity.getShape();
        float xAdjustment = calculateAdjustment(newPosition.getX(), newPosition.getRightmostX(),
                                              boundary.getX(), boundary.getRightmostX()),
              yAdjustment = calculateAdjustment(newPosition.getY(), newPosition.getTopmostY(),
                                              boundary.getY(), boundary.getTopmostY());
                
        if (xAdjustment != 0 || yAdjustment != 0) {
            entity.move(xAdjustment, yAdjustment);
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

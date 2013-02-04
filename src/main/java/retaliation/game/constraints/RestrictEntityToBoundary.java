package retaliation.game.constraints;

import retaliation.game.entities.Spaceship;
import retaliation.game.entities.SpaceshipMovementListener;
import retaliation.game.geometry.Shape;

public class RestrictEntityToBoundary implements SpaceshipMovementListener {

    private final Shape boundary;

    public RestrictEntityToBoundary(Spaceship entity, Shape boundary) {
        this.boundary = boundary;
        entity.registerMovementListener(this);
    }
    
    @Override
    public void notifyMoved(Spaceship entity) {
        Shape newPosition = entity.getShape();
        int xAdjustment = calculateAdjustment(newPosition.getX(), newPosition.getRightmostX(),
                                              boundary.getX(), boundary.getRightmostX()),
            yAdjustment = calculateAdjustment(newPosition.getY(), newPosition.getTopmostY(),
                                              boundary.getY(), boundary.getTopmostY());
                
        if (xAdjustment != 0 || yAdjustment != 0) {
            entity.move(xAdjustment, yAdjustment);
        }
    }

    private int calculateAdjustment(int lowerPosition, int upperPosition, int lowerBoundary, int upperBoundary) {
        if (lowerPosition < lowerBoundary) {
            return lowerBoundary - lowerPosition;
        } else if (upperPosition > upperBoundary) {
            return upperBoundary - upperPosition;
        }
        return 0;
    }

}

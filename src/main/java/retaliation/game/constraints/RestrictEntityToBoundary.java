package retaliation.game.constraints;

import retaliation.game.entities.Entity;
import retaliation.game.entities.EntityMovementListener;
import retaliation.game.shapes.Shape;

public class RestrictEntityToBoundary implements EntityMovementListener {

    private final Shape boundary;

    public RestrictEntityToBoundary(Entity entity, Shape boundary) {
        this.boundary = boundary;
        entity.registerMovementListener(this);
    }
    
    @Override
    public void entityMoved(Entity entity) {
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

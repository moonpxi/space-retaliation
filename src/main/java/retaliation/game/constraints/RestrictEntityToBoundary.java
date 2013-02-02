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
        int xAdjustment = 0,
            yAdjustment = 0;
        
        if (newPosition.getX() < boundary.getX()) {
            xAdjustment = boundary.getX() - newPosition.getX();
        } 
        if (newPosition.getRightmostX() > boundary.getRightmostX()) {
            xAdjustment = -(newPosition.getRightmostX() - boundary.getRightmostX());
        }
        if (newPosition.getY() < boundary.getY()) {
            yAdjustment = boundary.getY() - newPosition.getY();
        } 
        if (newPosition.getTopmostY() > boundary.getTopmostY()) {
            yAdjustment = -(newPosition.getTopmostY() - boundary.getTopmostY());
        }
        
        if (xAdjustment != 0 || yAdjustment != 0) {
            entity.move(xAdjustment, yAdjustment);
        }
    }

}

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
        
        if (newPosition.getX() < boundary.getX()) {
            entity.move(boundary.getX() - newPosition.getX(), 0);
        } 
        if (newPosition.getRightmostX() > boundary.getRightmostX()) {
            entity.move(-(newPosition.getRightmostX() - boundary.getRightmostX()), 0);
        }
        if (newPosition.getY() < boundary.getY()) {
            entity.move(0, boundary.getY() - newPosition.getY());
        } 
        if (newPosition.getTopmostY() > boundary.getTopmostY()) {
            entity.move(0, -(newPosition.getTopmostY() - boundary.getTopmostY()));
        }
    }

}

package retaliation.game.entities;

import retaliation.game.shapes.Shape;


public class Level implements EntityMovementListener {

    private final Fighter fighter;
    private final Shape boundary;

    public Level(Fighter fighter) {
        this.fighter = fighter;        
        boundary = new Shape(0, 0, 800, 600);
        this.fighter.registerMovementListener(this);
    }

    public Fighter getFighter() {
        return fighter;
    }

    @Override
    public void entityMoved(Entity entity, int newX, int newY) {
        Shape newPosition = entity.getShape();
        
        if (newPosition.getX() < boundary.getX()) {
            entity.move(-newPosition.getX(), 0);
        } 
        if (newPosition.getRightmostX() > boundary.getRightmostX()) {
            entity.move(-(newPosition.getRightmostX() - boundary.getRightmostX()), 0);
        }
        if (newPosition.getY() < boundary.getY()) {
            entity.move(0, -newPosition.getY());
        } 
        if (newPosition.getTopmostY() > boundary.getTopmostY()) {
            entity.move(0, -(newPosition.getTopmostY() - boundary.getTopmostY()));
        }
    }
    
}

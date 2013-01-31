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
        if (newX < boundary.getX()) {
            entity.move(-newX, 0);
        }        
    }
    
}

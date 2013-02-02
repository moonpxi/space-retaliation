package retaliation.game.entities;

import retaliation.game.constraints.RestrictEntityToBoundary;
import retaliation.game.shapes.Shape;


public class Level {

    private final Fighter fighter;
    private final Shape boundary;

    public Level(Fighter fighter) {
        this.fighter = fighter;        
        boundary = new Shape(0, 0, 800, 600);
        new RestrictEntityToBoundary(fighter, boundary);
    }

    public Fighter getFighter() {
        return fighter;
    }
    
}

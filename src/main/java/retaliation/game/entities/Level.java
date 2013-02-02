package retaliation.game.entities;

import retaliation.game.constraints.RestrictEntityToBoundary;
import retaliation.game.shapes.Shape;


public class Level {

    private final Fighter fighter;
    private final Shape boundary;
    private final RestrictEntityToBoundary restrictEntityToBoundary;

    public Level(Fighter fighter) {
        this.fighter = fighter;        
        boundary = new Shape(0, 0, 800, 600);
        restrictEntityToBoundary = new RestrictEntityToBoundary(fighter, boundary);
    }

    public Fighter getFighter() {
        return fighter;
    }
    
}

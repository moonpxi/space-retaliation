package retaliation.game.entities;

import java.util.List;

import retaliation.game.constraints.RestrictEntityToBoundary;
import retaliation.game.shapes.Shape;


public class Level {

    private final Fighter fighter;
    private final Shape boundary;
    private final List<AIEntity> enemies;

    public Level(Fighter fighter, List<AIEntity> enemies) {
        this.fighter = fighter;
        this.enemies = enemies;        
        boundary = new Shape(0, 0, 800, 600);
        new RestrictEntityToBoundary(fighter, boundary);
    }

    public Fighter getFighter() {
        return fighter;
    }

    public List<AIEntity> getEnemies() {
        return enemies;
    }
    
}

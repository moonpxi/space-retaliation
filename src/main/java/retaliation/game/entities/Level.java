package retaliation.game.entities;

import java.util.List;

import retaliation.game.constraints.RestrictEntityToBoundary;
import retaliation.game.geometry.Shape;


public class Level {

    private final Fighter fighter;
    private final List<AIEntity> enemies;

    public Level(Fighter fighter, List<AIEntity> enemies) {
        this.fighter = fighter;
        this.enemies = enemies;        
        
        new RestrictEntityToBoundary(fighter, new Shape(0, 0, 800, 600));
    }

    public void updateEnemyEntities(int delta) {
        for (AIEntity enemy : enemies) {
            enemy.update(delta);
        }
    }

    public Fighter getFighter() {
        return fighter;
    }

    public List<AIEntity> getEnemies() {
        return enemies;
    }
}

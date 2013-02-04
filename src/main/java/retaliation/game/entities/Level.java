package retaliation.game.entities;

import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

import java.util.List;

import retaliation.game.constraints.RestrictEntityToBoundary;
import retaliation.game.geometry.Rectangle;


public class Level {

    private final Fighter fighter;
    private final List<AIEntity> enemies;

    public Level(Fighter fighter, List<AIEntity> enemies) {
        this.fighter = fighter;
        this.enemies = enemies;        
        
        new RestrictEntityToBoundary(fighter, new Rectangle(at(0, 0), size(800, 600)));
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

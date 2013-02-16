package retaliation.game.logic;

import org.newdawn.slick.Input;
import retaliation.game.entities.Level;

public class LevelGameLoop implements GameLogic {

    private final Level level;

    public LevelGameLoop(Level level) {
        this.level = level;
    }

    @Override
    public void update(Input input, int delta) {
        level.getPlayerLogic().update(input, delta);

        for (EnemyAI enemy : level.getEnemiesLogic()) {
            enemy.update(input, delta);
        }

        for (FlyingLaser laser : level.getLasersLogic()) {
            laser.update(input, delta);
        }
    }
}

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
        level.getPlayer().update(input, delta);

        for (EnemyAI enemy : level.getEnemies()) {
            enemy.update(input, delta);
        }

        for (FlyingLaser laser : level.getLasers()) {
            laser.update(input, delta);
        }
    }
}

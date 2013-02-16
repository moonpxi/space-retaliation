package retaliation.game.logic;

import org.newdawn.slick.Input;
import retaliation.game.entities.Level;
import retaliation.game.geometry.Rectangle;
import retaliation.game.rules.EnforceLevelBoundaryRule;

import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

public class LevelGameLoop implements GameLogic {

    private final Level level;
    private final EnforceLevelBoundaryRule boundaryCheck;

    public LevelGameLoop(Level level) {
        this.level = level;
        this.boundaryCheck = new EnforceLevelBoundaryRule(new Rectangle(at(0, 0), size(800, 600)), this.level.getPlayer().getShip());
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

        boundaryCheck.update(input, delta);
    }
}

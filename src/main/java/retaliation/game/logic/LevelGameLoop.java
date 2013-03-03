package retaliation.game.logic;

import org.newdawn.slick.Input;
import retaliation.game.geometry.Rectangle;
import retaliation.game.rules.EnforceLevelBoundaryRule;

import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

public class LevelGameLoop implements GameLogic {

    private final LevelEntityLogic levelEntityLogic;
    private final EnforceLevelBoundaryRule boundaryCheck;

    public LevelGameLoop(LevelEntityLogic levelEntityLogic) {
        this.levelEntityLogic = levelEntityLogic;
        this.boundaryCheck = new EnforceLevelBoundaryRule(new Rectangle(at(0, 0), size(800, 600)), this.levelEntityLogic.getPlayer().getShip());
    }

    @Override
    public void update(Input input, int delta) {
        levelEntityLogic.update(input, delta);

        boundaryCheck.update(input, delta);
    }
}

package retaliation.game.logic;

import org.newdawn.slick.Input;
import retaliation.game.entities.Entities;
import retaliation.game.geometry.Rectangle;
import retaliation.game.rules.EnforceLevelBoundaryRule;

import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

public class LevelGameLoop implements GameLogic {

    private final Entities entities;
    private final LevelEntityLogic levelEntityLogic;
    private final EnforceLevelBoundaryRule boundaryCheck;

    public LevelGameLoop(Entities entities, LevelEntityLogic levelEntityLogic) {
        this.entities = entities;
        this.levelEntityLogic = levelEntityLogic;
        this.boundaryCheck = new EnforceLevelBoundaryRule(new Rectangle(at(0, 0), size(800, 600)), this.levelEntityLogic.getPlayer().getShip());
    }

    @Override
    public void update(Input input, int delta) {
        levelEntityLogic.update(input, delta);

        boundaryCheck.update(input, delta);
    }
}

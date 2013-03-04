package retaliation.game.logic;

import org.newdawn.slick.Input;
import retaliation.game.entities.Entities;
import retaliation.game.rules.LevelRules;

public class LevelGameLoop implements GameLogic {

    private final Entities entities;
    private final LevelEntityLogic levelEntityLogic;
    private final LevelRules levelRules;

    public LevelGameLoop(Entities entities, LevelEntityLogic levelEntityLogic, LevelRules levelRules) {
        this.entities = entities;
        this.levelEntityLogic = levelEntityLogic;
        this.levelRules = levelRules;
    }

    @Override
    public void update(Input input, int delta) {
        levelEntityLogic.update(input, delta);
        levelRules.apply(entities);
    }
}

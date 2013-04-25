package retaliation.game.logic;

import org.newdawn.slick.Input;
import retaliation.game.entities.Entities;
import retaliation.game.rules.LevelRules;

public class LevelGameLoop {

    private final Entities entities;
    private final EntitiesUpdateGameLogic entitiesUpdateGameLogic;
    private final LevelRules levelRules;

    public LevelGameLoop(Entities entities, EntitiesUpdateGameLogic entitiesUpdateGameLogic, LevelRules levelRules) {
        this.entities = entities;
        this.entitiesUpdateGameLogic = entitiesUpdateGameLogic;
        this.levelRules = levelRules;
    }

    public void update(Input input, int delta) {
        entitiesUpdateGameLogic.update(input, delta);
        levelRules.apply(entities);
    }
}

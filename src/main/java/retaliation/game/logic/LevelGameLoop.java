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
        Loop loop = new Loop(input, delta);

        loop.updateAll(levelEntityLogic.allEntitiesLogic());

        loop.update(boundaryCheck);
    }

    private class Loop {
        private final Input input;
        private final int delta;

        public Loop(Input input, int delta) {
            this.input = input;
            this.delta = delta;
        }

        public void update(GameLogic logic) {
            logic.update(input, delta);
        }

        public void updateAll(Iterable<? extends GameLogic> logics) {
            for (GameLogic logic : logics) {
                update(logic);
            }
        }
    }
}

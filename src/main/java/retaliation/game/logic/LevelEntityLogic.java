package retaliation.game.logic;

import org.newdawn.slick.Input;
import retaliation.game.entities.Entity;

import java.util.ArrayList;
import java.util.List;


public class LevelEntityLogic implements GameLogic {

    private final List<GameLogic> addedLogic = new ArrayList<GameLogic>();
    private final List<GameLogic> allEntitiesLogic = new ArrayList<GameLogic>();

    public void add(GameLogic logic) {
        addedLogic.add(logic);
    }

    public void removeLogicFor(Entity entity) {

    }

    @Override
    public void update(Input input, int delta) {
        allEntitiesLogic.addAll(addedLogic);
        addedLogic.clear();

        for (GameLogic logic : allEntitiesLogic) {
            logic.update(input, delta);
        }
    }

}


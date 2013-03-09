package retaliation.game.logic;

import com.google.common.base.Predicate;
import org.newdawn.slick.Input;
import retaliation.game.entities.Entity;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Iterables.removeIf;


public class LevelEntityLogic implements GameLogic {

    private final List<GameLogic> addedLogic = new ArrayList<GameLogic>();
    private final List<GameLogic> allEntitiesLogic = new ArrayList<GameLogic>();

    public void add(GameLogic logic) {
        addedLogic.add(logic);
    }

    public void removeLogicFor(final  Entity entity) {
        removeIf(allEntitiesLogic, new Predicate<GameLogic>() {
            @Override public boolean apply(GameLogic logic) { return logic.getEntity() == entity; }
        });
    }

    @Override
    public void update(Input input, int delta) {
        allEntitiesLogic.addAll(addedLogic);
        addedLogic.clear();

        for (GameLogic logic : allEntitiesLogic) {
            logic.update(input, delta);
        }
    }

    @Override
    public Entity getEntity() {
       throw new IllegalStateException("No entities for composite");
    }

}


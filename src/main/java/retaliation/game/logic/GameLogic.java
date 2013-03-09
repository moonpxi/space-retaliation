package retaliation.game.logic;

import org.newdawn.slick.Input;
import retaliation.game.entities.Entity;

public interface GameLogic {

    void update(Input input, int delta);

    Entity getEntity();
}

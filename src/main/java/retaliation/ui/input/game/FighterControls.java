package retaliation.ui.input.game;

import static java.util.Arrays.asList;
import static org.newdawn.slick.Input.KEY_DOWN;
import static org.newdawn.slick.Input.KEY_LEFT;
import static org.newdawn.slick.Input.KEY_RIGHT;
import static org.newdawn.slick.Input.KEY_SPACE;
import static org.newdawn.slick.Input.KEY_UP;

import java.util.List;

import retaliation.game.entities.Fighter;
import retaliation.ui.input.Controls;

public class FighterControls implements Controls {

    public static final List<Integer> KEYS = asList(KEY_UP, KEY_DOWN, KEY_LEFT, KEY_RIGHT, KEY_SPACE);
    private final Fighter fighter;

    public FighterControls(Fighter fighter) {
        this.fighter = fighter;
    }
    
    @Override
    public void notifyKeyDown(int keyCode) {
        switch (keyCode) {
        case KEY_UP:
            fighter.moveUp();
            break;
        case KEY_DOWN:
            fighter.moveDown();
            break;
        case KEY_LEFT:
            fighter.moveLeft();
            break;
        case KEY_RIGHT:
            fighter.moveRight();
            break;            
        case KEY_SPACE:
            fighter.shoot();
            break;
        default:
            break;
        }
    }
}

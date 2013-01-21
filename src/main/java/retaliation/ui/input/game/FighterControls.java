package retaliation.ui.input.game;

import static java.util.Arrays.asList;
import static org.newdawn.slick.Input.KEY_DOWN;
import static org.newdawn.slick.Input.KEY_LEFT;
import static org.newdawn.slick.Input.KEY_RIGHT;
import static org.newdawn.slick.Input.KEY_UP;

import java.util.List;

import retaliation.game.entities.Fighter;
import retaliation.ui.input.Controls;

public class FighterControls implements Controls {

    private final Fighter fighter;

    public FighterControls(Fighter fighter) {
        this.fighter = fighter;
    }

    @Override
    public List<Integer> keysToListen() { return asList(KEY_UP, KEY_DOWN, KEY_LEFT, KEY_RIGHT); }
    
    @Override
    public void keyDown(int keyCode) {
        if (keyCode == KEY_UP) {
            fighter.moveUp();
        }
        if (keyCode == KEY_DOWN) {
            fighter.moveDown();
        }
        if (keyCode == KEY_LEFT) {
            fighter.moveLeft();
        }
        if (keyCode == KEY_RIGHT) {
            fighter.moveRight();
        } 
    }
}

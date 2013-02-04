package retaliation.ui.input.game;

import static java.util.Arrays.asList;
import static org.newdawn.slick.Input.KEY_DOWN;
import static org.newdawn.slick.Input.KEY_LEFT;
import static org.newdawn.slick.Input.KEY_RIGHT;
import static org.newdawn.slick.Input.KEY_SPACE;
import static org.newdawn.slick.Input.KEY_UP;

import java.util.List;

import retaliation.game.entities.Spaceship;
import retaliation.ui.input.Controls;

public class FighterControls implements Controls {

    public static final List<Integer> KEYS = asList(KEY_UP, KEY_DOWN, KEY_LEFT, KEY_RIGHT, KEY_SPACE);
    public static final int SPEED = 4;
    private final Spaceship spaceship;

    public FighterControls(Spaceship spaceship) {
        this.spaceship = spaceship;
    }
    
    @Override
    public void notifyKeyDown(int keyCode) {
        switch (keyCode) {
        case KEY_UP:
            spaceship.move(0, -SPEED);
            break;
        case KEY_DOWN:
            spaceship.move(0, SPEED);
            break;
        case KEY_LEFT:
            spaceship.move(-SPEED, 0);
            break;
        case KEY_RIGHT:
            spaceship.move(SPEED, 0);
            break;            
        case KEY_SPACE:
            spaceship.shoot();
            break;
        default:
            break;
        }
    }
}

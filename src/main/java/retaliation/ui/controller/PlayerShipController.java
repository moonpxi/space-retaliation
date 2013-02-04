package retaliation.ui.controller;

import static org.newdawn.slick.Input.KEY_DOWN;
import static org.newdawn.slick.Input.KEY_LEFT;
import static org.newdawn.slick.Input.KEY_RIGHT;
import static org.newdawn.slick.Input.KEY_SPACE;
import static org.newdawn.slick.Input.KEY_UP;

import org.newdawn.slick.Input;

import retaliation.game.entities.Spaceship;

public class PlayerShipController implements SlickController {
    public static final int SPEED = 4;
    private final Spaceship player;

    public PlayerShipController(Spaceship player) {
        this.player = player;
    }

    @Override
    public void update(Input input, int delta) {
        if (input.isKeyDown(KEY_UP)) {
            player.move(0, -SPEED);
        }
        if (input.isKeyDown(KEY_DOWN)) {
            player.move(0, SPEED);
        }
        if (input.isKeyDown(KEY_LEFT)) {
            player.move(-SPEED, 0);
        }
        if (input.isKeyDown(KEY_RIGHT)) {
            player.move(SPEED, 0);
        }
        if (input.isKeyDown(KEY_SPACE)) {
            player.shoot();
        }
    }

}

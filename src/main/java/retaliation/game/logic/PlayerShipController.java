package retaliation.game.logic;

import org.newdawn.slick.Input;
import retaliation.game.entities.Spaceship;

import static org.newdawn.slick.Input.*;

public class PlayerShipController implements GameLogic {
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

    public Spaceship getShip() {
        return player;
    }
}

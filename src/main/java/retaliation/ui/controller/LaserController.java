package retaliation.ui.controller;

import org.newdawn.slick.Input;
import retaliation.game.entities.Moveable;

public class LaserController implements SlickController {
    private final Moveable laser;

    public LaserController(Moveable laser) {
        this.laser = laser;
    }

    @Override
    public void update(Input input, int delta) {
        laser.move(0, -1);
    }
}

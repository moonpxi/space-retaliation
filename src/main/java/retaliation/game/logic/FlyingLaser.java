package retaliation.game.logic;

import org.newdawn.slick.Input;
import retaliation.game.entities.Moveable;

public class FlyingLaser implements GameLogic {
    private final Moveable laser;

    public FlyingLaser(Moveable laser) {
        this.laser = laser;
    }

    @Override
    public void update(Input input, int delta) {
        laser.move(0, -1);
    }

    public Moveable getLaser() {
        return laser;
    }
}

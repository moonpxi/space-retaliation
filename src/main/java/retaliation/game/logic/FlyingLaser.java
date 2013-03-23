package retaliation.game.logic;

import org.newdawn.slick.Input;
import retaliation.game.entities.Entity;
import retaliation.game.entities.Laser;

public class FlyingLaser implements GameLogic {
    public static final int SPEED = 4;
    private final Laser laser;

    public FlyingLaser(Laser laser) {
        this.laser = laser;
    }

    @Override
    public void update(Input input, int delta) {
        laser.move(0, -SPEED);
    }

    @Override
    public Entity getEntity() {
        return laser;
    }

}

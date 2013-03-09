package retaliation.game.logic;

import org.newdawn.slick.Input;
import retaliation.game.entities.Entity;

public class FlyingLaser implements GameLogic {
    private final Entity laser;

    public FlyingLaser(Entity laser) {
        this.laser = laser;
    }

    @Override
    public void update(Input input, int delta) {
        laser.move(0, -1);
    }

    @Override
    public Entity getEntity() {
        return laser;
    }

}

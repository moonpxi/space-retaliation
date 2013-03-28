package retaliation.game.logic;

import retaliation.game.entities.Entity;
import retaliation.game.entities.Laser;
import retaliation.game.entities.Spaceship;
import retaliation.game.entities.listener.EntityListener;

import static retaliation.game.entities.EntityType.Enemy;

public class Scoring implements EntityListener {

    private int score;

    public Scoring() {
        reset();
    }

    public void reset() {
        score = 0;
    }

    @Override
    public void entityDestroyed(Entity entity) {
        if (entity.getType() == Enemy) {
           score++;
        }
    }

    @Override public void laserCreated(Laser laser) { }
    @Override public void spaceshipCreated(Spaceship ship) { }

    public int getScore() {
        return score;
    }
}

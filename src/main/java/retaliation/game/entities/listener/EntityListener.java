package retaliation.game.entities.listener;

import retaliation.game.entities.Entity;
import retaliation.game.entities.Laser;
import retaliation.game.entities.Spaceship;

public interface EntityListener {
    void laserCreated(Laser laser);
    void spaceshipCreated(Spaceship ship);
    void entityDestroyed(Entity entity);

    public EntityListener NULL_LISTENER = new EntityListener() {
        @Override public void laserCreated(Laser laser) { }
        @Override public void spaceshipCreated(Spaceship ship) { }
        @Override public void entityDestroyed(Entity entity) { }
    };

}

package retaliation.game.entities.listener;

import retaliation.game.entities.Entity;
import retaliation.game.entities.Spaceship;

public interface EntityListener {
    void entityCreated(Entity entity);
    void spaceshipCreated(Spaceship ship);

    public EntityListener NULL_LISTENER = new EntityListener() {
        @Override public void entityCreated(Entity entity) { }
        @Override public void spaceshipCreated(Spaceship ship) { }
    };
}

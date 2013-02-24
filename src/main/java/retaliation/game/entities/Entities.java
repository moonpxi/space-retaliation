package retaliation.game.entities;

import retaliation.game.entities.listener.EntityListener;

import java.util.ArrayList;
import java.util.List;

public class Entities {

    private final List<Entity> active = new ArrayList<Entity>();
    private EntityListener listener;

    public void registerListener(EntityListener listener) {
        this.listener = listener;
    }

    public void add(Entity entity) {
        active.add(entity);
        notifyListener(entity);
    }

    public Iterable<? extends Entity> activeEntities() {
        return active;
    }

    private void notifyListener(Entity entity) {
        if (listener != null) {
            if (entity instanceof Spaceship) {
                listener.spaceshipCreated((Spaceship) entity);
            } else {
                listener.entityCreated(entity);
            }
        }
    }

}

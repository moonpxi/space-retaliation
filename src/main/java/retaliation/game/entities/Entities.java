package retaliation.game.entities;

import retaliation.game.entities.listener.EntityListener;
import retaliation.game.entities.listener.SpaceshipShootingListener;
import retaliation.game.geometry.Position;

import java.util.ArrayList;
import java.util.List;

import static retaliation.game.entities.EntityType.Laser;
import static retaliation.game.geometry.Dimension.size;

public class Entities implements SpaceshipShootingListener {

    private final List<Entity> active = new ArrayList<Entity>();
    private EntityListener listener;

    public Entities(EntityListener listener) {
        this.listener = listener;
    }

    public void add(Entity entity) {
        active.add(entity);
        notifyListener(entity);
    }

    public void add(Spaceship ship) {
        ship.registerShootingListener(this);
        add((Entity) ship);
    }

    public Iterable<? extends Entity> activeEntities() {
        return active;
    }

    private void notifyListener(Entity entity) {
        if (entity instanceof Spaceship) {
            listener.spaceshipCreated((Spaceship) entity);
        } else {
            listener.entityCreated(entity);
        }
    }

    @Override
    public void fired(Position from) {
        // TODO: test it
        add(new Entity(Laser, from, size(1, 3)));
    }
}

package retaliation.game.entities;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import retaliation.game.entities.listener.EntityListener;
import retaliation.game.entities.listener.SpaceshipShootingListener;
import retaliation.game.geometry.Position;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Iterables.*;
import static java.util.Arrays.asList;
import static retaliation.game.entities.EntityType.*;
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
        add(new Entity(Laser, from, size(1, 3)));
    }

    public Spaceship getPlayerShip() {
        return (Spaceship) find(active, byType(Player));
    }

    public Iterable<Spaceship> allShips() {
        Iterable<Spaceship> enemies = transform(filterByType(Enemy), new Function<Entity, Spaceship>() {
            @Override public Spaceship apply(Entity entity) { return (Spaceship) entity; }
        });
        return concat(asList(getPlayerShip()), enemies);
    }

    public Iterable<Entity> filterByType(EntityType type) {
        return filter(active, byType(type));
    }

    private Predicate<Entity> byType(final EntityType type) {
        return new Predicate<Entity>() {
            @Override public boolean apply(Entity entity) { return entity.getType() == type; }
        };
    }
}

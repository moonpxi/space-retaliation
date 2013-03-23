package retaliation.game.entities;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import retaliation.game.entities.listener.EntityListener;
import retaliation.game.entities.listener.SpaceshipShootingListener;
import retaliation.game.geometry.Position;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Iterables.*;
import static retaliation.game.entities.Entity.State.Destroyed;
import static retaliation.game.entities.EntityType.*;
import static retaliation.game.entities.EntityType.Laser;

public class Entities implements SpaceshipShootingListener {

    private final List<Entity> allEntities = new ArrayList<Entity>();
    private EntityListener listener;

    public Entities(EntityListener listener) {
        this.listener = listener;
    }

    public void add(Entity entity) {
        allEntities.add(entity);
        notifyListener(entity);
    }

    public void add(Spaceship ship) {
        ship.registerShootingListener(this);
        add((Entity) ship);
    }

    @Override
    public void fired(Position from, Laser.Direction direction) {
        add(new Laser(from, direction));
    }

    public void clearDestroyed() {
        for (Entity destroyed : filter(allEntities, byState(Destroyed))) {
            listener.entityDestroyed(destroyed);
        }
        removeIf(allEntities, byState(Destroyed));
    }

    public Iterable<? extends Entity> activeEntities() {
        return allEntities;
    }

    public Spaceship playerShip() {
        return toSpaceship().apply(find(allEntities, byType(Player)));
    }

    public Iterable<Spaceship> allShips() {
        Iterable<Entity> enemies = filterByType(Enemy);
        Iterable<Entity> players = filterByType(Player);
        return transform(Iterables.concat(enemies, players), toSpaceship());
    }

    public Iterable<Laser> allLasers() {
        return transform(filterByType(Laser), toLaser());
    }

    public Iterable<Entity> filterByType(EntityType type) {
        return filter(allEntities, byType(type));
    }

    private void notifyListener(Entity entity) {
        if (entity instanceof Spaceship) {
            listener.spaceshipCreated((Spaceship) entity);
        } else {
            listener.laserCreated((Laser) entity);
        }
    }

    private Function<Entity, Spaceship> toSpaceship() {
        return new Function<Entity, Spaceship>() {
            @Override public Spaceship apply(Entity entity) { return (Spaceship) entity; }
        };
    }

    private Function<Entity, Laser> toLaser() {
        return new Function<Entity, Laser>() {
            @Override public Laser apply(Entity entity) { return (Laser) entity; }
        };
    }

    private Predicate<Entity> byType(final EntityType types) {
        return new Predicate<Entity>() {
            @Override public boolean apply(Entity entity) { return entity.getType() == types; }
        };
    }

    private Predicate<Entity> byState(final Entity.State state) {
        return new Predicate<Entity>() {
            @Override public boolean apply(Entity entity) { return entity.state() == state; }
        };
    }
}

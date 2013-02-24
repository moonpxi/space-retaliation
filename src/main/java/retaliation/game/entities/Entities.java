package retaliation.game.entities;

import java.util.ArrayList;
import java.util.List;

public class Entities {

    private final List<Entity> active = new ArrayList<Entity>();

    public void add(Entity entity) {
        active.add(entity);
    }

    public Iterable<? extends Entity> activeEntities() {
        return active;
    }
}

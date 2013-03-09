package retaliation.game.rules;

import retaliation.game.entities.Entities;

public class ClearDestroyedEntitiesRule implements Rule {

    @Override
    public void apply(Entities entities) {
        entities.clearDestroyed();
    }
}

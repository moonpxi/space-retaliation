package retaliation.game.entities.factory;

import retaliation.game.entities.Entities;
import retaliation.game.entities.listener.EntityListener;

import static retaliation.game.entities.factory.SpaceshipFactory.enemyShipAt;
import static retaliation.game.entities.factory.SpaceshipFactory.playerFighterAt;

public class EntitiesSetup {

    public static Entities createSampleLevelEntities(EntityListener listener) {
        Entities entities = new Entities();
        entities.registerListener(listener);

        entities.add(playerFighterAt(350, 520));
        entities.add(enemyShipAt(400, 100));
        entities.add(enemyShipAt(300, 200));
        entities.add(enemyShipAt(500, 300));

        return entities;
    }
}

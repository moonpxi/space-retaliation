package retaliation.game.entities.factory;

import retaliation.game.entities.Entities;
import retaliation.game.entities.Spaceship;
import retaliation.game.entities.listener.EntityListener;

import java.util.Random;

import static retaliation.game.entities.factory.SpaceshipFactory.enemyShipAt;
import static retaliation.game.entities.factory.SpaceshipFactory.playerFighterAt;

public class EntitiesSetup {

    public static Entities createSampleLevelEntities(EntityListener listener) {
        Entities entities = new Entities(listener);

        entities.add(playerFighterAt(350, 520));
        entities.add(randomEnemyAtLane(100));
        entities.add(randomEnemyAtLane(200));
        entities.add(randomEnemyAtLane(300));

        return entities;
    }

    private static Spaceship randomEnemyAtLane(float lane) {
        return enemyShipAt(new Random().nextInt(650), lane);
    }
}

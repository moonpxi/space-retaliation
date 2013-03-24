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
        entities.add(randomEnemyAtLane(1));
        entities.add(randomEnemyAtLane(2));
        entities.add(randomEnemyAtLane(3));

        return entities;
    }

    private static Spaceship randomEnemyAtLane(int lane) {
        return enemyShipAt(new Random().nextInt(650), lane * 100);
    }
}

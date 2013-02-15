package retaliation.game.entities.factory;

import retaliation.game.entities.Level;
import retaliation.game.entities.listener.EntityStateListener;

import static retaliation.game.entities.factory.SpaceshipFactory.enemyShipAt;
import static retaliation.game.entities.factory.SpaceshipFactory.playerFighterAt;

public class LevelFactory {

    public static Level sampleLevel(EntityStateListener listener) {
        Level level = new Level(listener);

        level.setPlayer(playerFighterAt(350, 520));

        level.addEnemyShip(enemyShipAt(400, 100));
        level.addEnemyShip(enemyShipAt(300, 200));
        level.addEnemyShip(enemyShipAt(500, 300));

        return level;
    }
}

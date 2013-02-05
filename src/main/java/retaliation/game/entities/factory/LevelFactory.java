package retaliation.game.entities.factory;

import static retaliation.game.entities.factory.SpaceshipFactory.enemyShipAt;
import static retaliation.game.entities.factory.SpaceshipFactory.playerFighterAt;

import java.util.ArrayList;
import java.util.List;

import retaliation.game.entities.Level;
import retaliation.game.entities.Spaceship;

public class LevelFactory {

    public static Level sampleLevel() {
        List<Spaceship> enemies = new ArrayList<Spaceship>();
        enemies.add(enemyShipAt(400, 100));
        enemies.add(enemyShipAt(300, 200));
        enemies.add(enemyShipAt(500, 300));
        
        return new Level(playerFighterAt(350, 520), enemies);
    }
}

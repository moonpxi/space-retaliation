package retaliation.game.entities.factory;

import retaliation.game.entities.Spaceship;

import static retaliation.game.entities.EntityType.Enemy;
import static retaliation.game.entities.EntityType.Player;
import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

public class SpaceshipFactory {
    
    public static Spaceship playerFighterAt(float x, float y) {
        return new Spaceship(Player, at(x, y), size(100, 20));
    }

    public static Spaceship enemyShipAt(float x, float y) {
        return new Spaceship(Enemy, at(x, y), size(40, 40));
    }
}

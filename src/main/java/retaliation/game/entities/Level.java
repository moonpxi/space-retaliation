package retaliation.game.entities;

import retaliation.game.entities.listener.EntityListener;
import retaliation.game.logic.EnemyAI;
import retaliation.game.logic.FlyingLaser;
import retaliation.game.logic.GameLogic;
import retaliation.game.logic.PlayerShipControls;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Iterables.concat;
import static java.util.Arrays.asList;
import static retaliation.game.entities.EntityType.Player;


public class Level implements EntityListener {

    private PlayerShipControls player;
    private final List<EnemyAI> enemies = new ArrayList<EnemyAI>();
    private final List<FlyingLaser> lasers = new ArrayList<FlyingLaser>();

    public Iterable<GameLogic> allEntitiesLogic() {
        return concat(asList(player), enemies, lasers);
    }

    public PlayerShipControls getPlayer() {
        return player;
    }

    @Override
    public void entityCreated(Entity entity) {
        lasers.add(new FlyingLaser(entity));
    }

    @Override
    public void spaceshipCreated(Spaceship ship) {
        if (ship.getType() == Player) {
            player = new PlayerShipControls(ship);
        } else {
            enemies.add(new EnemyAI(ship));
        }
    }
}

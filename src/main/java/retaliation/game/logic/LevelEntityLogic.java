package retaliation.game.logic;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Iterables.concat;
import static java.util.Arrays.asList;


public class LevelEntityLogic {

    private PlayerShipControls player;
    private final List<EnemyAI> enemies = new ArrayList<EnemyAI>();
    private final List<FlyingLaser> lasers = new ArrayList<FlyingLaser>();

    public Iterable<? extends GameLogic> allEntitiesLogic() {
        return concat(asList(player), enemies, lasers);
    }

    public void setPlayer(PlayerShipControls player) {
        this.player = player;
    }

    public PlayerShipControls getPlayer() {
        return player;
    }

    public void add(FlyingLaser laser) {
        lasers.add(laser);
    }

    public void add(EnemyAI enemy) {
        enemies.add(enemy);
    }

}

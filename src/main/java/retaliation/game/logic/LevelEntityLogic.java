package retaliation.game.logic;

import org.newdawn.slick.Input;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Iterables.concat;
import static java.util.Arrays.asList;


public class LevelEntityLogic implements GameLogic {

    private PlayerShipControls player;
    private final List<EnemyAI> enemies = new ArrayList<EnemyAI>();
    private final List<FlyingLaser> lasers = new ArrayList<FlyingLaser>();

    public void setPlayer(PlayerShipControls player) {
        this.player = player;
    }

    public void add(FlyingLaser laser) {
        lasers.add(laser);
    }

    public void add(EnemyAI enemy) {
        enemies.add(enemy);
    }

    @Override
    public void update(Input input, int delta) {
        for (GameLogic logic : concat(asList(player), enemies, lasers)) {
            logic.update(input, delta);
        }
    }

}


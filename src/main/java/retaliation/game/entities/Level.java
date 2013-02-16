package retaliation.game.entities;

import com.google.common.base.Function;
import org.newdawn.slick.Input;
import retaliation.game.entities.listener.MovementListener;
import retaliation.game.entities.listener.SpaceshipShootingListener;
import retaliation.game.geometry.Position;
import retaliation.game.geometry.Rectangle;
import retaliation.game.rules.EnforceLevelBoundaryRule;
import retaliation.ui.controller.EnemyController;
import retaliation.ui.controller.LaserController;
import retaliation.ui.controller.PlayerShipController;
import retaliation.ui.controller.SlickController;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Iterables.transform;
import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;


public class Level implements MovementListener, SpaceshipShootingListener, SlickController {

    private PlayerShipController player;
    private final List<EnemyController> enemies = new ArrayList<EnemyController>();
    private final List<LaserController> lasers = new ArrayList<LaserController>();

    private final EnforceLevelBoundaryRule boundaryRule;

    public Level() {
        boundaryRule = new EnforceLevelBoundaryRule(new Rectangle(at(0, 0), size(800, 600)));
    }

    public Spaceship getPlayer() {
        return player.getShip();
    }

    public Iterable<Spaceship> getEnemies() {
        return transform(enemies, new Function<EnemyController, Spaceship>() {
            @Override public Spaceship apply(EnemyController enemy) {
                return enemy.getShip();
            }
        });
    }

    public Iterable<Moveable> getLasers() {
        return transform(lasers, new Function<LaserController, Moveable>() {
            @Override
            public Moveable apply(LaserController laser) {
                return laser.getLaser();
            }
        });
    }

    public void setPlayer(Spaceship player) {
        this.player = new PlayerShipController(player);

        player.registerShootingListener(this);
        player.registerMovementListener(this);
    }

    public void addEnemyShip(Spaceship enemy) {
        enemies.add(new EnemyController(enemy));
    }

    @Override
    public void notifyMoved(Moveable ship) {
        boundaryRule.enforceBoundaryOn(ship);
    }

    @Override
    public void fired(Position from) {
        lasers.add(new LaserController(new Moveable(from, size(1, 3))));
    }

    @Override
    public void update(Input input, int delta) {
        player.update(input, delta);

        for (EnemyController enemy : enemies) {
            enemy.update(input, delta);
        }

        for (LaserController laser : lasers) {
            laser.update(input, delta);
        }
    }
}

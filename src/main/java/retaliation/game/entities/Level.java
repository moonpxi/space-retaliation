package retaliation.game.entities;

import com.google.common.base.Function;
import retaliation.game.entities.listener.MovementListener;
import retaliation.game.entities.listener.SpaceshipShootingListener;
import retaliation.game.geometry.Position;
import retaliation.game.geometry.Rectangle;
import retaliation.game.logic.EnemyAI;
import retaliation.game.logic.FlyingLaser;
import retaliation.game.logic.GameLogic;
import retaliation.game.logic.PlayerShipController;
import retaliation.game.rules.EnforceLevelBoundaryRule;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Iterables.concat;
import static com.google.common.collect.Iterables.transform;
import static java.util.Arrays.asList;
import static retaliation.game.entities.EntityType.Laser;
import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;


public class Level implements MovementListener, SpaceshipShootingListener {

    private PlayerShipController player;
    private final List<EnemyAI> enemies = new ArrayList<EnemyAI>();
    private final List<FlyingLaser> lasers = new ArrayList<FlyingLaser>();

    private final EnforceLevelBoundaryRule boundaryRule;

    public Level() {
        boundaryRule = new EnforceLevelBoundaryRule(new Rectangle(at(0, 0), size(800, 600)));
    }

    public void setPlayer(Spaceship player) {
        this.player = new PlayerShipController(player);

        player.registerShootingListener(this);
        player.registerMovementListener(this);
    }

    public GameLogic getPlayer() {
        return player;
    }

    public void addEnemyShip(Spaceship enemy) {
        enemies.add(new EnemyAI(enemy));
    }

    public Iterable<EnemyAI> getEnemies() {
        return enemies;
    }

    @Override
    public void fired(Position from) {
        lasers.add(new FlyingLaser(new Entity(Laser, from, size(1, 3))));
    }

    public Iterable<FlyingLaser> getLasers() {
        return lasers;
    }

    @Override
    public void notifyMoved(Entity ship) {
        boundaryRule.enforceBoundaryOn(ship);
    }

    public Iterable<? extends Entity> allEntities() {
        Iterable<Spaceship> enemyShips = transform(this.enemies, new Function<EnemyAI, Spaceship>() {
            @Override public Spaceship apply(EnemyAI enemy) { return enemy.getShip(); }
        });
        Iterable<Entity> laserBolts = transform(lasers, new Function<FlyingLaser, Entity>() {
            @Override public Entity apply(FlyingLaser laser) { return laser.getLaser(); }
        });

        return concat(asList(player.getShip()), enemyShips, laserBolts);
    }
}

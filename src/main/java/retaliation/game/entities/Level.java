package retaliation.game.entities;

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

import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;


public class Level implements MovementListener, SpaceshipShootingListener, SlickController {

    private Spaceship player;
    private final List<Spaceship> enemies = new ArrayList<Spaceship>();
    private final List<Moveable> lasers = new ArrayList<Moveable>();

    private final EnforceLevelBoundaryRule boundaryRule;

    public Level() {
        boundaryRule = new EnforceLevelBoundaryRule(new Rectangle(at(0, 0), size(800, 600)));
    }

    public Spaceship getPlayer() {
        return player;
    }

    public List<Spaceship> getEnemies() {
        return  enemies;
    }

    public List<Moveable> getLasers() {
        return lasers;
    }

    public void setPlayer(Spaceship player) {
        this.player = player;

        this.player.registerShootingListener(this); // TODO: add to constructor
        this.player.registerMovementListener(this);
    }

    public void addEnemyShip(Spaceship enemy) {
        enemies.add(enemy);
    }

    @Override
    public void notifyMoved(Moveable ship) {
        boundaryRule.enforceBoundaryOn(ship);
    }

    @Override
    public void fired(Position from) {
        lasers.add(new Moveable(from, size(1, 3)));
    }

    @Override
    public void update(Input input, int delta) {
        new PlayerShipController(player).update(input, delta);

        for (Spaceship enemy : enemies) {
            new EnemyController(enemy).update(input, delta);
        }

        for (Moveable laser : lasers) {
            new LaserController(laser).update(input, delta);
        }
    }
}

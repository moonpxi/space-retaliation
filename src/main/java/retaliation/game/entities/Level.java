package retaliation.game.entities;

import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

import java.util.ArrayList;
import java.util.List;

import retaliation.game.entities.listener.EntityStateListener;
import retaliation.game.entities.listener.MovementListener;
import retaliation.game.entities.listener.SpaceshipShootingListener;
import retaliation.game.geometry.Position;
import retaliation.game.geometry.Rectangle;
import retaliation.game.rules.EnforceLevelBoundaryRule;


public class Level implements MovementListener, SpaceshipShootingListener {

    private final Spaceship player;
    private final List<Spaceship> enemies = new ArrayList<Spaceship>();
    private final List<Moveable> lasers = new ArrayList<Moveable>();
    private final EnforceLevelBoundaryRule boundaryRule;
    private EntityStateListener stateListener;

    public Level(EntityStateListener listener, Spaceship player) {
        stateListener = listener;
        this.player = player;

        boundaryRule = new EnforceLevelBoundaryRule(new Rectangle(at(0, 0), size(800, 600)));
        this.player.registerShootingListener(this); // TODO: add to constructor
        this.player.registerMovementListener(this);
    }

    public Spaceship getPlayer() {
        return player;
    }

    public void addEnemyShip(Spaceship enemy) {
        enemies.add(enemy);
        stateListener.enemyCreated(enemy);
    }

    @Override
    public void notifyMoved(Moveable ship) {
        boundaryRule.enforceBoundaryOn(ship);
    }

    @Override
    public void fired(Position from) {
        Moveable laser = new Moveable(from, size(1, 3));
        lasers.add(laser);
        stateListener.laserCreated(laser);
    }

}

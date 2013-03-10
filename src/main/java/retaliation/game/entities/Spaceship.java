package retaliation.game.entities;

import retaliation.game.entities.listener.SpaceshipShootingListener;
import retaliation.game.geometry.Dimension;
import retaliation.game.geometry.Position;

import static java.lang.System.currentTimeMillis;
import static retaliation.game.entities.Entity.State.Destroyed;

public class Spaceship extends Entity {

    private final static int COOLDOWN_PERIOD = 700;
    private SpaceshipShootingListener shootingListener;
    private long lastShot = 0;

    public Spaceship(EntityType type, Position position, Dimension dimension) {
        super(type, position, dimension);
    }

    public void shoot() {
        if (canShoot()) {
            Position from = Position.at(position().x() + (dimension().width() / 2),
                                        position().y() - 1);
        
            shootingListener.fired(from);
            lastShot = currentTimeMillis();
        }
    }

    public void takeHit() {
        changeTo(Destroyed);
    }

    public void registerShootingListener(SpaceshipShootingListener listener) {
        shootingListener = listener;
    }

    private boolean canShoot() {
        return (currentTimeMillis() - lastShot) > COOLDOWN_PERIOD;
    }
}

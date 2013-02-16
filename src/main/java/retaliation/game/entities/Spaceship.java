package retaliation.game.entities;

import retaliation.game.entities.listener.SpaceshipShootingListener;
import retaliation.game.geometry.Dimension;
import retaliation.game.geometry.Position;

public class Spaceship extends Entity {
    
    private SpaceshipShootingListener shootingListener;

    public Spaceship(EntityType type, Position position, Dimension dimension) {
        super(type, position, dimension);
    }

    public void shoot() {
        Position from = Position.at(position().x() + (dimension().width() / 2),
                                    position().y() - 1);
        
        shootingListener.fired(from);
    }

    public void registerShootingListener(SpaceshipShootingListener listener) {
        shootingListener = listener;
    }
}

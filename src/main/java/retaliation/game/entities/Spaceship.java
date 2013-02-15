package retaliation.game.entities;

import retaliation.game.entities.listener.SpaceshipShootingListener;
import retaliation.game.geometry.Dimension;
import retaliation.game.geometry.Position;

public class Spaceship extends Moveable {
    
    private SpaceshipShootingListener shootingListener;

    public Spaceship(Position position, Dimension dimension) {
        super(position, dimension);
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

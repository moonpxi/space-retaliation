package retaliation.game.entities;

import retaliation.game.entities.listener.SpaceshipShootingListener;
import retaliation.game.geometry.Dimension;
import retaliation.game.geometry.Position;

import static retaliation.game.entities.Spaceship.State.Alive;

public class Spaceship extends Entity {

    enum State {
        Alive, Damaged, Destroyed
    }
    
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

    public State state() {
        return Alive;
    }
}

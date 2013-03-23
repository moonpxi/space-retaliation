package retaliation.game.entities.listener;

import retaliation.game.entities.Laser;
import retaliation.game.geometry.Position;

public interface SpaceshipShootingListener {

    public void fired(Position from, Laser.Direction direction);
}

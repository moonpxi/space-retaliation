package retaliation.game.entities.listener;

import retaliation.game.entities.Moveable;
import retaliation.game.entities.Spaceship;

public interface EntityStateListener {
    
    void laserCreated(Moveable laser);

    void enemyCreated(Spaceship enemy);
}

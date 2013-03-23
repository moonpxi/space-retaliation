package retaliation.game.logic.factory;

import retaliation.game.entities.Entity;
import retaliation.game.entities.Laser;
import retaliation.game.entities.Spaceship;
import retaliation.game.entities.listener.EntityListener;
import retaliation.game.logic.EnemyAI;
import retaliation.game.logic.FlyingLaser;
import retaliation.game.logic.LevelEntityLogic;
import retaliation.game.logic.PlayerShipControls;

import static retaliation.game.entities.EntityType.Player;

public class EntityGameLogicFactory implements EntityListener {

    private final LevelEntityLogic levelLogic;

    public EntityGameLogicFactory(LevelEntityLogic levelLogic) {
        this.levelLogic = levelLogic;
    }

    @Override
    public void laserCreated(Laser laser) {
        levelLogic.add(new FlyingLaser(laser));
    }

    @Override
    public void entityDestroyed(Entity entity) {
        levelLogic.removeLogicFor(entity);
    }

    @Override
    public void spaceshipCreated(Spaceship ship) {
        if (ship.getType() == Player) {
            levelLogic.add(new PlayerShipControls(ship));
        } else {
            levelLogic.add(new EnemyAI(ship));
        }
    }
}

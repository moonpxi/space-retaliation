package retaliation.game.rules;

import retaliation.game.entities.Entities;
import retaliation.game.entities.Entity;
import retaliation.game.entities.Laser;
import retaliation.game.entities.Spaceship;
import retaliation.game.entities.listener.EntityListener;

import static retaliation.game.entities.EntityType.Enemy;
import static retaliation.game.entities.factory.EntitiesSetup.randomEnemyAtLane;

public class RespawnEnemyRule implements EntityListener {

    private final Entities entities;

    public RespawnEnemyRule(Entities entities) {
        this.entities = entities;
    }

    @Override
    public void entityDestroyed(Entity entity) {
        if (entity.getType() == Enemy) {
            entities.add(randomEnemyAtLane(entity.position().y()));
        }
    }

    @Override public void laserCreated(Laser laser) { }

    @Override public void spaceshipCreated(Spaceship ship) { }

}

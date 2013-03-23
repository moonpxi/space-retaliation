package retaliation.game.logic.factory;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;
import org.junit.Test;
import retaliation.game.entities.Entity;
import retaliation.game.entities.Laser;
import retaliation.game.entities.Spaceship;
import retaliation.game.logic.EnemyAI;
import retaliation.game.logic.FlyingLaser;
import retaliation.game.logic.LevelEntityLogic;
import retaliation.game.logic.PlayerShipControls;

import static retaliation.game.entities.EntityType.Enemy;
import static retaliation.game.entities.EntityType.Player;
import static retaliation.game.entities.Laser.Direction.Upwards;
import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

public class EntityGameLogicFactoryTest {

    private final Mockery context = new Mockery() {{ setImposteriser(ClassImposteriser.INSTANCE); }};
    private final LevelEntityLogic levelLogic = context.mock(LevelEntityLogic.class);
    private EntityGameLogicFactory factory;

    @Before public void
    createFactory() {
       factory = new EntityGameLogicFactory(levelLogic);
    }

    @Test public void
    addsLaserLogicForEntityWithLaserType() {
        context.checking(new Expectations() {{
            oneOf(levelLogic).add(with(any(FlyingLaser.class)));
        }});

        factory.laserCreated(new Laser(at(10, 10), Upwards));

        context.assertIsSatisfied();
    }

    @Test public void
    addsPlayerLogicForSpaceshipWithPlayerType() {
        context.checking(new Expectations() {{
            oneOf(levelLogic).add(with(any(PlayerShipControls.class)));
        }});

        factory.spaceshipCreated(new Spaceship(Player, at(10, 10), size(100, 100)));

        context.assertIsSatisfied();
    }

    @Test public void
    addsEnemyLogicForSpaceshipWithEnemyType() {
        context.checking(new Expectations() {{
            oneOf(levelLogic).add(with(any(EnemyAI.class)));
        }});

        factory.spaceshipCreated(new Spaceship(Enemy, at(10, 10), size(100, 100)));

        context.assertIsSatisfied();
    }

    @Test public void
    removeLogicFromDestroyedEntity() {
        final Entity entity = new Laser(at(10, 10), Upwards);

        context.checking(new Expectations() {{
            oneOf(levelLogic).removeLogicFor(entity);
        }});

        factory.entityDestroyed(entity);

        context.assertIsSatisfied();
    }
}

package retaliation.game.logic;

import com.google.common.base.Function;
import org.hamcrest.Matcher;
import org.junit.Test;
import retaliation.game.entities.Entity;
import retaliation.game.entities.Spaceship;

import static com.google.common.collect.Iterables.transform;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;
import static retaliation.game.entities.EntityType.*;
import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

public class LevelEntityLogicTest {

    @SuppressWarnings("unchecked")
    @Test public void
    createsGameLogicForEachCreatedEntity() {
        LevelEntityLogic logic = new LevelEntityLogic();

        logic.entityCreated(new Entity(Laser, at(10, 10), size(100, 100)));
        logic.spaceshipCreated(new Spaceship(Enemy, at(20, 20), size(200, 200)));
        logic.spaceshipCreated(new Spaceship(Player, at(30, 30), size(300, 300)));


        Iterable<Class> logicClasses = transform(logic.allEntitiesLogic(), new Function<GameLogic, Class>() {
            @Override public Class apply(GameLogic logic) { return logic.getClass(); }
        });

        assertThat(logicClasses, (Matcher) contains(PlayerShipControls.class, EnemyAI.class, FlyingLaser.class));
    }
}

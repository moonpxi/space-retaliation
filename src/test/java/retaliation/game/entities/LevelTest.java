package retaliation.game.entities;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.junit.Test;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;
import static retaliation.game.entities.EntityType.*;
import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

public class LevelTest {
    private final Level level = new Level(new Spaceship(Player, at(20, 40), size(100, 100)));

    @SuppressWarnings("unchecked")
    @Test public void
    returnsAllEntities() {
        level.fired(at(25, 35));
        level.addEnemyShip(new Spaceship(Enemy, at(30, 40), size(100, 20)));

        assertThat(level.allEntities(), contains(isEntity(Player, 20, 40),
                                                 isEntity(Enemy, 30, 40),
                                                 isEntity(Laser, 25, 35)));
    }

    private Matcher<Entity> isEntity(final EntityType type, final float x, final float y) {
        return new TypeSafeDiagnosingMatcher<Entity>() {

            @Override
            public void describeTo(Description description) {
                description.appendValue("Expected " + type + " at " + x + ", " + y);
            }

            @Override
            protected boolean matchesSafely(Entity actual, Description description) {
                description.appendValue("Entity was a " + actual.getType() + " at " + actual.position().x() + ", " + actual.position().y());
                return actual.getType() == type && actual.position().equals(at(x, y));
            }
        };
    }
}

package retaliation.game.entities;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.junit.Test;

import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

// TODO: redefine tests
public class LevelTest {
    private final Level level = new Level(new Spaceship(EntityType.Player, at(20, 40), size(100, 100)));

    @Test public void
    toBeDefined() {

    }

    private Matcher<Entity> moveableAt(final float x, final float y) {
        return new TypeSafeDiagnosingMatcher<Entity>() {

            @Override
            public void describeTo(Description description) {
                description.appendValue("Expected laser at " + x + ", " + y);
            }

            @Override
            protected boolean matchesSafely(Entity actual, Description description) {
                description.appendValue("Entity was at " + actual.position().x() + ", " + actual.position().y());
                return actual.position().equals(at(x, y));
            }
        };
    }
}

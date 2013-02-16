package retaliation.game.entities;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.junit.Test;

import static retaliation.game.geometry.Position.at;

// TODO: redefine tests
public class LevelTest {
    private final Level level = new Level();

    @Test public void
    toBeDefined() {

    }

    private Matcher<Moveable> moveableAt(final float x, final float y) {
        return new TypeSafeDiagnosingMatcher<Moveable>() {

            @Override
            public void describeTo(Description description) {
                description.appendValue("Expected laser at " + x + ", " + y);
            }

            @Override
            protected boolean matchesSafely(Moveable actual, Description description) {
                description.appendValue("Moveable was at " + actual.position().x() + ", " + actual.position().y());
                return actual.position().equals(at(x, y));
            }
        };
    }
}

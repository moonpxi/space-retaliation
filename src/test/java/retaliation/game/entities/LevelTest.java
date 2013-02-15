package retaliation.game.entities;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;
import retaliation.game.entities.listener.EntityStateListener;

import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

public class LevelTest {
    private final Mockery context = new Mockery();
    private final EntityStateListener stateListener = context.mock(EntityStateListener.class);
    private final Level level = new Level(stateListener, new Spaceship(null, null));

    @Test
    public void notifiesListenerWhenCreatingALaserAfterAFiredEvent() {
        context.checking(new Expectations() {{
            oneOf(stateListener).laserCreated(with(moveableAt(10, 30)));
        }});
        
        level.fired(at(10, 30));
        
        context.assertIsSatisfied();
    }

    @Test
    public void notifiesListenerWhenNewEnemyIsAdded() {
        context.checking(new Expectations() {{
            oneOf(stateListener).enemyCreated(with(shipAt(20, 50)));
        }});

        level.addEnemyShip(new Spaceship(at(20, 50), size(100, 30)));

        context.assertIsSatisfied();
    }

    private Matcher<Spaceship> shipAt(final float x, final float y) {
        return new TypeSafeDiagnosingMatcher<Spaceship>() {

            @Override
            public void describeTo(Description description) {
                description.appendValue("Expected ship at " + x + ", " + y);
            }

            @Override
            protected boolean matchesSafely(Spaceship actual, Description description) {
                description.appendValue("Ship was at " + actual.position().x() + ", " + actual.position().y());
                return actual.position().equals(at(x, y));
            }
        };
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

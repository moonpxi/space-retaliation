package retaliation.game.entities;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;
import retaliation.game.entities.listener.EntityStateListener;

import static retaliation.game.geometry.Position.at;

public class LevelTest {
    private final Mockery context = new Mockery();
    private final EntityStateListener stateListener = context.mock(EntityStateListener.class);

    @Test
    public void notifiesListenerWhenCreatingALaserAfterAFiredEvent() {
        Level level = new Level(stateListener, new Spaceship(null, null));

        context.checking(new Expectations() {{
            oneOf(stateListener).laserCreated(with(laserAt(10, 30)));
        }});
        
        level.fired(at(10, 30));
        
        context.assertIsSatisfied();
    }
    
    private Matcher<Moveable> laserAt(final float x, final float y) {
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

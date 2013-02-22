package retaliation.game.logic;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;
import org.junit.Test;
import org.newdawn.slick.Input;
import retaliation.game.entities.Spaceship;

import static org.newdawn.slick.Input.*;

public class PlayerShipControlsTest {
    private final Mockery context = new Mockery() {{
        setImposteriser(ClassImposteriser.INSTANCE);
    }};
    private final Input input = context.mock(Input.class);
    private final Spaceship ship = context.mock(Spaceship.class);
    private PlayerShipControls controls;

    @Before
    public void setupControls() {
        controls = new PlayerShipControls(ship);
    }

    @Test
    public void
    shootWhenSpaceIsPressed() {
        expectKey(KEY_SPACE);
        context.checking(new Expectations() {{
            oneOf(ship).shoot();
        }});

        controls.update(input, 0);

        context.assertIsSatisfied();
     }

    @Test
    public void
    moveUpWhenUpArrowIsPressed() {
        expectKey(KEY_UP);
        context.checking(new Expectations() {{
            oneOf(ship).move(0, -4);
        }});

        controls.update(input, 0);

        context.assertIsSatisfied();
    }

    @Test
    public void
    moveDownWhenDownArrowIsPressed() {
        expectKey(KEY_DOWN);
        context.checking(new Expectations() {{
            oneOf(ship).move(0, 4);
        }});

        controls.update(input, 0);

        context.assertIsSatisfied();
    }

    @Test
    public void
    moveLeftWhenLeftArrowIsPressed() {
        expectKey(KEY_LEFT);
        context.checking(new Expectations() {{
            oneOf(ship).move(-4, 0);
        }});

        controls.update(input, 0);

        context.assertIsSatisfied();
    }

    @Test
    public void
    moveRightWhenRightArrowIsPressed() {
        expectKey(KEY_RIGHT);
        context.checking(new Expectations() {{
            oneOf(ship).move(4, 0);
        }});

        controls.update(input, 0);

        context.assertIsSatisfied();
    }

    @Test
    public void
    moveInDiagonal() {
        context.checking(new Expectations() {{
            oneOf(input).isKeyDown(KEY_UP); will(returnValue(true));
            oneOf(input).isKeyDown(KEY_RIGHT); will(returnValue(true));
            allowing(input);

            oneOf(ship).move(0, -4);
            oneOf(ship).move(4, 0);
        }});

        controls.update(input, 0);

        context.assertIsSatisfied();
    }

    private void expectKey(final int keyCode) {
        context.checking(new Expectations() {{
            oneOf(input).isKeyDown(keyCode); will(returnValue(true));
            allowing(input);
        }});
    }
}

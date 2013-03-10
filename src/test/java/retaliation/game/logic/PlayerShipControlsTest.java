package retaliation.game.logic;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;
import org.newdawn.slick.Input;
import retaliation.game.entities.Spaceship;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.newdawn.slick.Input.*;
import static retaliation.game.entities.EntityType.Player;
import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

public class PlayerShipControlsTest {
    private final Mockery context = new Mockery() {{
        setImposteriser(ClassImposteriser.INSTANCE);
    }};
    private final Input input = context.mock(Input.class);
    private final PlayerShipControls controls = new PlayerShipControls(new Spaceship(Player, at(0, 0), size(100, 100)));

    @Test
    public void
    shootWhenSpaceIsPressed() {
        final Spaceship mockShip = context.mock(Spaceship.class);
        PlayerShipControls controlsWithMockShip = new PlayerShipControls(mockShip);

        context.checking(new Expectations() {{
            oneOf(input).isKeyDown(KEY_SPACE); will(returnValue(true));
            allowing(input);
            oneOf(mockShip).shoot();
        }});

        controlsWithMockShip.update(input, 0);

        context.assertIsSatisfied();
     }

    @Test
    public void
    moveUpWhenUpArrowIsPressed() {
        expectKey(KEY_UP);

        assertThat(controls.getEntity().position(), equalTo(at(0, -4)));
    }

    @Test
    public void
    moveDownWhenDownArrowIsPressed() {
        expectKey(KEY_DOWN);

        assertThat(controls.getEntity().position(), equalTo(at(0, 4)));
    }

    @Test
    public void
    moveLeftWhenLeftArrowIsPressed() {
        expectKey(KEY_LEFT);

        assertThat(controls.getEntity().position(), equalTo(at(-4, 0)));
    }

    @Test
    public void
    moveRightWhenRightArrowIsPressed() {
        expectKey(KEY_RIGHT);

        assertThat(controls.getEntity().position(), equalTo(at(4, 0)));
    }

    @Test
    public void
    moveInDiagonal() {
        context.checking(new Expectations() {{
            oneOf(input).isKeyDown(KEY_UP); will(returnValue(true));
            oneOf(input).isKeyDown(KEY_RIGHT); will(returnValue(true));
            allowing(input);
        }});

        controls.update(input, 0);

        assertThat(controls.getEntity().position(), equalTo(at(4, -4)));
    }

    private void expectKey(final int keyCode) {
        context.checking(new Expectations() {{
            oneOf(input).isKeyDown(keyCode); will(returnValue(true));
            allowing(input);
        }});

        controls.update(input, 0);
    }
}

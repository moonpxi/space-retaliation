package retaliation.game.logic;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;
import org.newdawn.slick.Input;

public class LevelEntityLogicTest {

    private final Mockery context = new Mockery() {{ setImposteriser(ClassImposteriser.INSTANCE); }};
    private final Input input = context.mock(Input.class);
    private final PlayerShipControls player = context.mock(PlayerShipControls.class);
    private final EnemyAI enemy = context.mock(EnemyAI.class);
    private final FlyingLaser laser = context.mock(FlyingLaser.class);

    @Test public void
    updatesAllTheComposedGameLogic() {
        LevelEntityLogic levelLogic = new LevelEntityLogic();
        levelLogic.add(player);
        levelLogic.add(laser);
        levelLogic.add(enemy);

        context.checking(new Expectations() {{
            oneOf(player).update(input, 42);
            oneOf(enemy).update(input, 42);
            oneOf(laser).update(input, 42);
        }});

        levelLogic.update(input, 42);

        context.assertIsSatisfied();
    }

}

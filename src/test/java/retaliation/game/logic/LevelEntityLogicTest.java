package retaliation.game.logic;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;
import org.junit.Test;
import org.newdawn.slick.Input;
import retaliation.game.entities.Entity;

public class LevelEntityLogicTest {

    private final Mockery context = new Mockery() {{ setImposteriser(ClassImposteriser.INSTANCE); }};
    private final Input input = context.mock(Input.class);
    private final GameLogic logic = context.mock(GameLogic.class, "Logic 1");
    private final GameLogic anotherLogic = context.mock(GameLogic.class, "Logic 2");
    private final Entity entity = context.mock(Entity.class, "Entity 1");
    private final Entity anotherEntity = context.mock(Entity.class, "Entity 2");
    private LevelEntityLogic levelLogic;

    @Before
    public void setupLogic() {
        levelLogic = new LevelEntityLogic();
        levelLogic.add(logic);
        levelLogic.add(anotherLogic);
    }

    @Test public void
    updatesAllTheComposedGameLogic() {
        context.checking(new Expectations() {{
            oneOf(logic).update(input, 42);
            oneOf(anotherLogic).update(input, 42);
        }});

        levelLogic.update(input, 42);

        context.assertIsSatisfied();
    }

    @Test public void
    removeLogicRelatedToDestroyedEntity() {
        context.checking(new Expectations() {{
            oneOf(logic).getEntity(); will(returnValue(entity));
            oneOf(anotherLogic).getEntity(); will(returnValue(anotherEntity));

            exactly(1).of(logic).update(input, 42);
            exactly(2).of(anotherLogic).update(input, 42);
        }});

        levelLogic.update(input, 42);
        levelLogic.removeLogicFor(entity);
        levelLogic.update(input, 42);

        context.assertIsSatisfied();
    }

}

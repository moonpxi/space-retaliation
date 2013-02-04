package retaliation.game.entities;

import java.util.Arrays;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;

public class LevelTest {
    private final Mockery context = new Mockery() {{
        setImposteriser(ClassImposteriser.INSTANCE);
    }};
    private final AIEntity enemy1 = context.mock(AIEntity.class, "E1");
    private final AIEntity enemy2 = context.mock(AIEntity.class, "E2");

    @Test
    public void updateAllEnemies() {
        Level level = new Level(new Spaceship(null), Arrays.asList(enemy1, enemy2));
        
        context.checking(new Expectations() {{
            oneOf(enemy1).update(41);
            oneOf(enemy2).update(41);
        }});
        
        level.updateEnemyEntities(41);
        
        context.assertIsSatisfied();
    }

}

package retaliation.game.rules;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;
import retaliation.game.entities.Entities;

public class LevelRulesTest {

    private final Mockery context = new Mockery();
    private final Rule rule1 = context.mock(Rule.class, "R1");
    private final Rule rule2 = context.mock(Rule.class, "R2");
    private final Entities entities = new Entities(null);

    @Test public void
    applyComposedRules() {
        context.checking(new Expectations() {{
            oneOf(rule1).apply(entities);
            oneOf(rule2).apply(entities);
        }});

        new LevelRules(rule1, rule2).apply(entities);

        context.assertIsSatisfied();
    }
}

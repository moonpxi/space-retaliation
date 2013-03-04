package retaliation.game.rules;

import retaliation.game.entities.Entities;

public class LevelRules implements Rule {

    private final Rule[] rules;

    public LevelRules(Rule... rules) {
        this.rules = rules;
    }

    @Override
    public void apply(Entities entities) {
        for (Rule rule : rules) {
            rule.apply(entities);
        }
    }
}

package retaliation;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import retaliation.game.entities.Entities;
import retaliation.game.entities.factory.EntitiesSetup;
import retaliation.game.geometry.Rectangle;
import retaliation.game.logic.EntitiesUpdateGameLogic;
import retaliation.game.logic.LevelGameLoop;
import retaliation.game.logic.Scoring;
import retaliation.game.logic.factory.EntityGameLogicFactory;
import retaliation.game.rules.*;
import retaliation.ui.renderer.EntitiesRenderer;
import retaliation.ui.renderer.SlickRenderer;

import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

public class GameScreen implements SlickScreen {

    private final SlickRenderer renderer;
    private final LevelGameLoop levelLogic;
    private final Game game;
    private final Scoring scoring;

    public GameScreen(Game game, Scoring scoring) {
        this.game = game;
        this.scoring = scoring;

        Rectangle boundary = new Rectangle(at(0, 0), size(800, 600));
        EntitiesUpdateGameLogic entitiesUpdateGameLogic = new EntitiesUpdateGameLogic();
        EntityGameLogicFactory entityGameLogicFactory = new EntityGameLogicFactory(entitiesUpdateGameLogic, boundary);
        Entities entities = EntitiesSetup.createSampleLevelEntities(entityGameLogicFactory, scoring, new GameOverRule(game));

        RespawnEnemyRule respawnEnemyRule = new RespawnEnemyRule(entities);
        entities.addListener(respawnEnemyRule);

        LevelRules rules = new LevelRules(new EnforceLevelBoundaryRule(boundary),
                new LasersDamageShipsRule(),
                new DestroyOutOfBoundaryLasersRule(boundary),
                new ClearDestroyedEntitiesRule());

        levelLogic = new LevelGameLoop(entities, entitiesUpdateGameLogic, rules);
        renderer = new EntitiesRenderer(entities);
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
        levelLogic.update(gc.getInput(), delta);
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        renderer.render(g);

        g.drawString("Score: " + scoring.getScore(), 400, 10);
    }

}

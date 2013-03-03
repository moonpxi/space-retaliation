package retaliation;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import retaliation.game.entities.Entities;
import retaliation.game.entities.factory.EntitiesSetup;
import retaliation.game.logic.LevelEntityLogic;
import retaliation.game.logic.LevelGameLoop;
import retaliation.game.logic.factory.EntityGameLogicFactory;
import retaliation.ui.renderer.LevelRenderer;
import retaliation.ui.renderer.SlickRenderer;

public class Game extends BasicGame {
    
    private final SlickRenderer renderer;
    private final LevelGameLoop levelLogic;

    public Game() {
       super("Space Retaliation");

        LevelEntityLogic levelEntityLogic = new LevelEntityLogic();
        EntityGameLogicFactory entityGameLogicFactory = new EntityGameLogicFactory(levelEntityLogic);
        Entities entities = EntitiesSetup.createSampleLevelEntities(entityGameLogicFactory);
        levelLogic = new LevelGameLoop(levelEntityLogic);
        renderer = new LevelRenderer(entities);
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
        levelLogic.update(gc.getInput(), delta);
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        renderer.render(g);
    }

}

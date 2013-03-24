package retaliation;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import retaliation.game.entities.Entities;
import retaliation.game.entities.factory.EntitiesSetup;
import retaliation.game.geometry.Rectangle;
import retaliation.game.logic.LevelEntityLogic;
import retaliation.game.logic.LevelGameLoop;
import retaliation.game.logic.factory.EntityGameLogicFactory;
import retaliation.game.rules.*;
import retaliation.ui.renderer.EntitiesRenderer;
import retaliation.ui.renderer.SlickRenderer;

import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

public class Game extends BasicGame {
    
    private final SlickRenderer renderer;
    private final LevelGameLoop levelLogic;

    public Game() {
       super("Space Retaliation");

        Rectangle boundary = new Rectangle(at(0, 0), size(800, 600));
        LevelEntityLogic levelEntityLogic = new LevelEntityLogic();
        EntityGameLogicFactory entityGameLogicFactory = new EntityGameLogicFactory(levelEntityLogic, boundary);
        Entities entities = EntitiesSetup.createSampleLevelEntities(entityGameLogicFactory);
        LevelRules rules = new LevelRules(new EnforceLevelBoundaryRule(boundary),
                                          new LasersDamageShipsRule(),
                                          new DestroyOutOfBoundaryLasersRule(boundary),
                                          new ClearDestroyedEntitiesRule());

        levelLogic = new LevelGameLoop(entities, levelEntityLogic, rules);
        renderer = new EntitiesRenderer(entities);
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

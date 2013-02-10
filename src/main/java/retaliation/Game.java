package retaliation;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import retaliation.game.entities.Level;
import retaliation.game.entities.Spaceship;
import retaliation.game.entities.factory.LevelFactory;
import retaliation.ui.controller.EnemyController;
import retaliation.ui.controller.PlayerShipController;
import retaliation.ui.controller.SlickController;
import retaliation.ui.renderer.SlickRenderable;
import retaliation.ui.renderer.SpaceshipRenderable;

public class Game extends BasicGame {
    
    private final List<SlickController> controllers = new ArrayList<SlickController>();
    private final List<SlickRenderable> renderables = new ArrayList<SlickRenderable>();
    private final Level level;

    public Game() {
       super("Space Retaliation");
       
       level = LevelFactory.sampleLevel();     
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        controllers.add(new PlayerShipController(level.getPlayer()));
        renderables.add(new SpaceshipRenderable(level.getPlayer(), Color.green));
        
        for (Spaceship enemy : level.getEnemies()) {
            controllers.add(new EnemyController(enemy));
            renderables.add(new SpaceshipRenderable(enemy, Color.white));
        }
    }
    
    @Override
    public void update(GameContainer gc, int delta) throws SlickException {        
        for (SlickController controller : this.controllers) {
            controller.update(gc.getInput(), delta);
        }
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        for (SlickRenderable renderable : this.renderables) {
            renderable.render(g);
        }
    }

}

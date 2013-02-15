package retaliation;

import org.newdawn.slick.*;
import retaliation.game.entities.Level;
import retaliation.game.entities.Moveable;
import retaliation.game.entities.Spaceship;
import retaliation.game.entities.factory.LevelFactory;
import retaliation.game.entities.listener.EntityStateListener;
import retaliation.ui.controller.EnemyController;
import retaliation.ui.controller.LaserController;
import retaliation.ui.controller.PlayerShipController;
import retaliation.ui.controller.SlickController;
import retaliation.ui.renderer.MoveableRectRenderable;
import retaliation.ui.renderer.SlickRenderable;

import java.util.ArrayList;
import java.util.List;

public class Game extends BasicGame implements EntityStateListener {
    
    private final List<SlickController> controllers = new ArrayList<SlickController>();
    private final List<SlickController> nextUpdate = new ArrayList<SlickController>();
    private final List<SlickRenderable> renderables = new ArrayList<SlickRenderable>();
    private final Level level;

    public Game() {
       super("Space Retaliation");
       
       level = LevelFactory.sampleLevel(this);
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        register(new PlayerShipController(level.getPlayer()), 
                 new MoveableRectRenderable(level.getPlayer(), Color.green));
        
        for (Spaceship enemy : level.getEnemies()) {
            register(new EnemyController(enemy),
                     new MoveableRectRenderable(enemy, Color.white));
        }
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException { 
        controllers.addAll(nextUpdate);
        nextUpdate.clear();
        
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
    
    private void register(SlickController controller, SlickRenderable renderable) {
        controllers.add(controller);
        renderables.add(renderable);
    }

    @Override
    public void laserCreated(final Moveable laser) {
        nextUpdate.add(new LaserController(laser));
        renderables.add(new MoveableRectRenderable(laser, Color.green));
    }

}

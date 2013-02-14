package retaliation;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import retaliation.game.entities.Laser;
import retaliation.game.entities.Level;
import retaliation.game.entities.Spaceship;
import retaliation.game.entities.factory.LevelFactory;
import retaliation.game.entities.listener.EntityStateListener;
import retaliation.ui.controller.EnemyController;
import retaliation.ui.controller.PlayerShipController;
import retaliation.ui.controller.SlickController;
import retaliation.ui.renderer.SlickRenderable;
import retaliation.ui.renderer.SpaceshipRenderable;

public class Game extends BasicGame implements EntityStateListener {
    
    private final List<SlickController> controllers = new ArrayList<SlickController>();
    private final List<SlickController> nextUpdate = new ArrayList<SlickController>();
    private final List<SlickRenderable> renderables = new ArrayList<SlickRenderable>();
    private final Level level;

    public Game() {
       super("Space Retaliation");
       
       level = LevelFactory.sampleLevel();   
       level.registerStateListener(this); // TODO: Add to constructor
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        register(new PlayerShipController(level.getPlayer()), 
                 new SpaceshipRenderable(level.getPlayer(), Color.green));
        
        for (Spaceship enemy : level.getEnemies()) {
            register(new EnemyController(enemy),
                     new SpaceshipRenderable(enemy, Color.white));
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
    public void laserCreated(final Laser laser) {
        // TODO: fix this
        nextUpdate.add(new SlickController() {
            @Override
            public void update(Input input, int delta) {
                laser.move(0, -1);
            }
        });
        renderables.add(new SlickRenderable() {
            @Override
            public void render(Graphics g) {
                g.setColor(Color.green);
                g.fillRect(laser.position().x(), laser.position().y(), 
                           laser.dimension().width(), laser.dimension().height());
            }
        });
    }

}

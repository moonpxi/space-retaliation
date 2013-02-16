package retaliation;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import retaliation.game.entities.Level;
import retaliation.game.entities.Moveable;
import retaliation.game.entities.Spaceship;
import retaliation.game.entities.factory.LevelFactory;
import retaliation.game.entities.listener.EntityStateListener;
import retaliation.ui.controller.EnemyController;
import retaliation.ui.controller.LaserController;
import retaliation.ui.controller.PlayerShipController;
import retaliation.ui.controller.SlickController;
import retaliation.ui.renderer.LevelRenderer;
import retaliation.ui.renderer.SlickRenderer;

import java.util.ArrayList;
import java.util.List;

public class Game extends BasicGame implements EntityStateListener {
    
    private final List<SlickController> controllers = new ArrayList<SlickController>();
    private final List<SlickController> nextUpdate = new ArrayList<SlickController>();
    private final SlickRenderer renderer;
    private final Level level;

    public Game() {
       super("Space Retaliation");

        level = LevelFactory.sampleLevel(this);
        renderer = new LevelRenderer(level);
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
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
        renderer.render(g);
    }

    @Override
    public void laserCreated(final Moveable laser) {
        nextUpdate.add(new LaserController(laser));
    }

    @Override
    public void enemyCreated(Spaceship enemy) {
        nextUpdate.add(new EnemyController(enemy));
    }

    @Override
    public void playerCreated(Spaceship player) {
        nextUpdate.add(new PlayerShipController(player));
    }

}

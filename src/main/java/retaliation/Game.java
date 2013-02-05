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
import retaliation.game.geometry.Rectangle;
import retaliation.ui.controller.EnemyController;
import retaliation.ui.controller.PlayerShipController;
import retaliation.ui.controller.SlickController;
import retaliation.ui.renderer.slick.RectShapeRenderer;

public class Game extends BasicGame {
    
    private final List<SlickController> controllers = new ArrayList<SlickController>();
    private final Level level;

    public Game() {
       super("Space Retaliation");
       
       level = LevelFactory.sampleLevel();     
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        this.controllers.add(new PlayerShipController(level.getPlayer()));
        
        for (Spaceship enemy : level.getEnemies()) {
            controllers.add(new EnemyController(enemy));
        }
    }
    
    // TODO: write a test for this
    @Override
    public void update(GameContainer gc, int delta) throws SlickException {        
        for (SlickController controller : this.controllers) {
            controller.update(gc.getInput(), delta);
        }
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        RectShapeRenderer renderer = new RectShapeRenderer(g);
        
        Spaceship player = level.getPlayer();
        renderer.render(new Rectangle(player.position(), player.dimension()), Color.green);
        for (Spaceship enemy : level.getEnemies()) {
            renderer.render(new Rectangle(enemy.position(), enemy.dimension()), Color.white);
        }
    }

}

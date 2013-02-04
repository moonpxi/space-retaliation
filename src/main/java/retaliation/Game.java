package retaliation;

import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import retaliation.game.ai.EnemyControls;
import retaliation.game.entities.Level;
import retaliation.game.entities.Spaceship;
import retaliation.game.geometry.Rectangle;
import retaliation.ui.input.InputController;
import retaliation.ui.input.game.ManualControls;
import retaliation.ui.input.slick.SlickInputController;
import retaliation.ui.renderer.slick.RectShapeRenderer;

public class Game extends BasicGame {
    
    private InputController controller;
    private final List<EnemyControls> enemyControls = new ArrayList<EnemyControls>();
    private final Level level;

    public Game() {
       super("Space Retaliation");
       
       level = constructLevel();
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        controller = new SlickInputController(gc.getInput());
        controller.listenToKeysFor(new ManualControls(level.getPlayer()), ManualControls.KEYS);
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {        
        controller.processInputAndNotifyControls();
        
        // TODO: write a test for this
        for (EnemyControls enemyControl : this.enemyControls) {
            enemyControl.update(delta);
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

    private Level constructLevel() {
        List<Spaceship> enemies = new ArrayList<Spaceship>();
        enemies.add(new Spaceship(at(400, 100), size(40, 40)));
        enemies.add(new Spaceship(at(300, 200), size(40, 40)));
        enemies.add(new Spaceship(at(500, 300), size(40, 40)));
        
        for (Spaceship enemy : enemies) {
            enemyControls.add(new EnemyControls(enemy));
        }
        
        return new Level(new Spaceship(at(350, 520), size(100, 20)), enemies);
    }
}

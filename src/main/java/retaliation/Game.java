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

import retaliation.game.entities.AIEntity;
import retaliation.game.entities.Defender;
import retaliation.game.entities.Level;
import retaliation.game.entities.Spaceship;
import retaliation.game.geometry.Rectangle;
import retaliation.ui.input.InputController;
import retaliation.ui.input.game.FighterControls;
import retaliation.ui.input.slick.SlickInputController;
import retaliation.ui.renderer.slick.RectShapeRenderer;

public class Game extends BasicGame {
    
    private InputController controller;
    private final Level level;

    public Game() {
       super("Space Retaliation");
       
       level = constructLevel();
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        controller = new SlickInputController(gc.getInput());
        controller.listenToKeysFor(new FighterControls(level.getPlayer()), FighterControls.KEYS);
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {        
        controller.processInputAndNotifyControls();
        
        level.updateEnemyEntities(delta);
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        RectShapeRenderer renderer = new RectShapeRenderer(g);
        
        renderer.render(level.getPlayer().getShape(), Color.green);
        for (AIEntity enemy : level.getEnemies()) {
            renderer.render(enemy.getShape(), Color.white);
        }
    }

    private Level constructLevel() {
        List<AIEntity> enemies = new ArrayList<AIEntity>();
        enemies.add(new Defender(400, 100));
        enemies.add(new Defender(300, 200));
        enemies.add(new Defender(500, 300));
        
        return new Level(new Spaceship(new Rectangle(at(350, 520), size(100, 20))), enemies);
    }
}

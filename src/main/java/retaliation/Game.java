package retaliation;

import static java.util.Arrays.asList;
import static org.newdawn.slick.Input.KEY_DOWN;
import static org.newdawn.slick.Input.KEY_LEFT;
import static org.newdawn.slick.Input.KEY_RIGHT;
import static org.newdawn.slick.Input.KEY_UP;

import java.util.List;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import retaliation.game.entities.Fighter;
import retaliation.ui.input.Controls;
import retaliation.ui.input.InputController;
import retaliation.ui.input.slick.SlickInputController;
import retaliation.ui.renderer.slick.SlickQuadRenderer;

public class Game extends BasicGame {
    
    private final Fighter fighter;

    public Game() {
       super("Space Retaliation");
       
       fighter = new Fighter(350, 520);
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
    
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
        InputController controller = new SlickInputController(gc.getInput());
        controller.listenToInputFor(new Controls() {            
            @Override
            public List<Integer> keysToListen() { return asList(KEY_UP, KEY_DOWN, KEY_LEFT, KEY_RIGHT); }
            
            @Override
            public void keyDown(int keyCode) {
                if (keyCode == KEY_UP) {
                    fighter.moveUp();
                }
                if (keyCode == KEY_DOWN) {
                    fighter.moveDown();
                }
                if (keyCode == KEY_LEFT) {
                    fighter.moveLeft();
                }
                if (keyCode == KEY_RIGHT) {
                    fighter.moveRight();
                } 
            }
        });
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        new SlickQuadRenderer(g).render(fighter.getShape(), Color.green);
    }

}

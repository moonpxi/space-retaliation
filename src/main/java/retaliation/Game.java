package retaliation;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import retaliation.game.entities.Fighter;
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
        if (gc.getInput().isKeyDown(Input.KEY_UP)) {
            fighter.moveUp();
        }
        if (gc.getInput().isKeyDown(Input.KEY_DOWN)) {
            fighter.moveDown();
        }
        if (gc.getInput().isKeyDown(Input.KEY_LEFT)) {
            fighter.moveLeft();
        }
        if (gc.getInput().isKeyDown(Input.KEY_RIGHT)) {
            fighter.moveRight();
        }
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        new SlickQuadRenderer(g).render(fighter.getShape(), Color.green);
    }

}

package retaliation;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Game extends BasicGame {
    
    public Game() {
       super("Space Retaliation");
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
    
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
    
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        g.drawString("Nothing to see here", 100, 100);
    }

}
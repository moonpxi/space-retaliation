package retaliation;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public interface SlickScreen {
    void update(GameContainer gc, int delta) throws SlickException;
    void render(GameContainer gc, Graphics g) throws SlickException;
}

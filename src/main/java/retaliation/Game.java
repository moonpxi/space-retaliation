package retaliation;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Game extends BasicGame {

    private SlickScreen currentScreen;

    public Game() {
       super("Space Retaliation");

        currentScreen = new GameScreen();
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
        currentScreen.update(gc, delta);
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        currentScreen.render(gc, g);
    }

}

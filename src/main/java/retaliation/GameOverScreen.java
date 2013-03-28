package retaliation;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import static org.newdawn.slick.Input.KEY_ESCAPE;
import static org.newdawn.slick.Input.KEY_SPACE;
import static retaliation.Game.Screens.Game;

public class GameOverScreen implements SlickScreen {

    private final Game game;

    public GameOverScreen(Game game) {
        this.game = game;
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
        if (gc.getInput().isKeyDown(KEY_SPACE)) {
            game.switchTo(Game);
        } else if (gc.getInput().isKeyDown(KEY_ESCAPE)) {
            System.exit(0);
        }
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        g.setColor(Color.green);

        g.drawString("You died!", 300, 100);
        g.drawString("Enemies destroyed: 0", 300, 120);

        g.drawString("Press <space> to play again", 280, 270);
        g.drawString("Press <esc> to exit", 280, 290);
    }
}

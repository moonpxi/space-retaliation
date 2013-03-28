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
        float margin = 240;
        g.setColor(Color.green);

        g.drawString("[Game Over]", margin, 100);
        g.drawString("Enemies destroyed: 0", margin, 180);

        g.drawString("Press <space> to play again", margin, 270);
        g.drawString("Press <esc> to exit", margin, 290);
    }
}

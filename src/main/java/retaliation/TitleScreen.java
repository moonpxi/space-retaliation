package retaliation;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import static org.newdawn.slick.Input.KEY_SPACE;
import static retaliation.Game.Screens.Game;

public class TitleScreen implements SlickScreen {

    private final Game game;

    public TitleScreen(Game game) {
        this.game = game;
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
        if (gc.getInput().isKeyDown(KEY_SPACE)) {
            game.switchTo(Game);
        }
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        g.setColor(Color.green);

        g.drawString("Space Retaliation", 300, 100);
        g.drawString("[experimental]", 320, 120);

        g.drawString("Controls:", 280, 250);
        g.drawString("- Movement: <left> and <right> keys", 280, 270);
        g.drawString("- Shooting: <space> key", 280, 290);

        g.drawString("Press <space> to continue", 280, 340);
    }
}

package retaliation;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import retaliation.game.logic.Scoring;

public class Game extends BasicGame {

    private final Scoring scoring;

    public enum Screens { Game, GameOver }

    private SlickScreen currentScreen;

    public Game() {
       super("Space Retaliation");

        currentScreen = new TitleScreen(this);
        scoring = new Scoring();
    }

    public void switchTo(Screens screen) {
        // Crappy state machine
        if (screen == Screens.Game) {
            scoring.reset();
            currentScreen = new GameScreen(this, scoring);
        } else if (screen == Screens.GameOver) {
            currentScreen = new GameOverScreen(this, scoring);
        }
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

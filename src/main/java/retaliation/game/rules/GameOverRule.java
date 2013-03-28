package retaliation.game.rules;

import retaliation.Game;
import retaliation.game.entities.Entity;
import retaliation.game.entities.Laser;
import retaliation.game.entities.Spaceship;
import retaliation.game.entities.listener.EntityListener;

import static retaliation.Game.Screens.GameOver;
import static retaliation.game.entities.EntityType.Player;

public class GameOverRule implements EntityListener {

    private final Game game;

    public GameOverRule(Game game) {
        this.game = game;
    }

    @Override
    public void entityDestroyed(Entity entity) {
        if (entity.getType() == Player) {
            game.switchTo(GameOver);
        }
    }

    @Override public void laserCreated(Laser laser) { }
    @Override public void spaceshipCreated(Spaceship ship) { }
}

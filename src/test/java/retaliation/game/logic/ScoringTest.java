package retaliation.game.logic;

import org.junit.Test;
import retaliation.game.entities.Laser;
import retaliation.game.entities.Spaceship;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static retaliation.game.entities.EntityType.Enemy;
import static retaliation.game.entities.EntityType.Player;
import static retaliation.game.entities.Laser.Direction.Downwards;
import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

public class ScoringTest {

    @Test public void
    scoreStartsAtZero() {
        assertThat(new Scoring().getScore(), is(0));
    }

    @Test public void
    doNotIncreaseScoreIfPlayerOrLaserIsDestroyed() {
        Scoring scoring = new Scoring();

        scoring.entityDestroyed(new Spaceship(Player, at(0, 0), size(20, 20)));
        scoring.entityDestroyed(new Laser(at(0, 0), Downwards));

        assertThat(scoring.getScore(), is(0));
    }

    @Test public void
    increaseScoreWhenEnemiesAreDestroyed() {
        Scoring scoring = new Scoring();

        scoring.entityDestroyed(new Spaceship(Enemy, at(0, 0), size(20, 20)));
        scoring.entityDestroyed(new Spaceship(Enemy, at(0, 0), size(20, 20)));
        scoring.entityDestroyed(new Spaceship(Enemy, at(0, 0), size(20, 20)));

        assertThat(scoring.getScore(), is(3));
    }
}

package retaliation.game.entities;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class FighterTest {

    @Test
    public void returnsPositionAndDimension() {
        Fighter fighter = new Fighter(30, 50);
        
        assertThat(fighter.getX(), is(30));
        assertThat(fighter.getY(), is(50));
    }

}

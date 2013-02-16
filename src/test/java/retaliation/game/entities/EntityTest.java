package retaliation.game.entities;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static retaliation.game.entities.EntityType.Player;
import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

public class EntityTest {
    @Test
    public void movesRelativeToAdjustmentAndNotifiesMovementListeners() {
        final Entity entity = new Entity(Player, at(5, 8), size(10, 10));

        entity.move(15, 42);

        assertThat(entity.position().x(), equalTo(20f));
        assertThat(entity.position().y(), equalTo(50f));
    }
}

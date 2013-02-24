package retaliation.game.entities;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.contains;
import static retaliation.game.entities.EntityType.*;
import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

public class EntitiesTest {

    @Test public void
    returnsListOfAllActiveEntities() {
        Entity laser = new Entity(Laser, at(10, 10), size(100, 20));
        Spaceship player = new Spaceship(Player, at(20, 20), size(200, 30));
        Spaceship enemy = new Spaceship(Enemy, at(30, 30), size(300, 40));

        Entities entities = new Entities();
        entities.add(laser);
        entities.add(player);
        entities.add(enemy);

        Assert.assertThat(entities.activeEntities(), contains(laser, player, enemy));
    }


}

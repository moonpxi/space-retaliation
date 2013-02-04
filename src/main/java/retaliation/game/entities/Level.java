package retaliation.game.entities;

import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

import java.util.List;

import retaliation.game.constraints.RestrictEntityToBoundary;
import retaliation.game.geometry.Rectangle;


public class Level {

    private final Spaceship player;
    private final List<Spaceship> enemies;

    public Level(Spaceship player, List<Spaceship> enemies) {
        this.player = player;
        this.enemies = enemies;        
        
        new RestrictEntityToBoundary(player, new Rectangle(at(0, 0), size(800, 600)));
    }

    public Spaceship getPlayer() {
        return player;
    }

    public List<Spaceship> getEnemies() {
        return enemies;
    }
}

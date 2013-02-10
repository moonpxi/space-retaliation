package retaliation.game.entities;

import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

import java.util.List;

import retaliation.game.entities.listener.SpaceshipMovementListener;
import retaliation.game.geometry.Rectangle;
import retaliation.game.rules.EnforceLevelBoundaryRule;


public class Level implements SpaceshipMovementListener {

    private final Spaceship player;
    private final List<Spaceship> enemies;
    private final EnforceLevelBoundaryRule boundaryRule;

    public Level(Spaceship player, List<Spaceship> enemies) {
        this.player = player;
        this.enemies = enemies;        
        
        boundaryRule = new EnforceLevelBoundaryRule(new Rectangle(at(0, 0), size(800, 600)));
        this.player.registerMovementListener(this);
    }

    public Spaceship getPlayer() {
        return player;
    }

    public List<Spaceship> getEnemies() {
        return enemies;
    }

    @Override
    public void notifyMoved(Spaceship ship) {
        boundaryRule.enforceBoundaryOn(ship);
    }
}

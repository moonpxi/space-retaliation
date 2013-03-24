package retaliation.game.logic;

import org.newdawn.slick.Input;
import retaliation.game.entities.Entity;
import retaliation.game.entities.Spaceship;
import retaliation.game.geometry.Rectangle;

public class EnemyAI implements GameLogic {
    
    private final float leftSide;
    private final float rightSide;
    private float speed;
    private final Spaceship enemy;

    public EnemyAI(Spaceship enemy, Rectangle levelBoundary) {
        this.enemy = enemy;
        leftSide = levelBoundary.getX() + 5;
        rightSide = levelBoundary.getRightmostX() - enemy.dimension().width() - 5;
        speed = -5;
    }

    @Override
    public void update(Input input, int delta) {
        float position = enemy.position().x();
        
        if (position < leftSide || position > rightSide) {
            speed *= -1;
        }
        
        enemy.move(speed, 0);
        enemy.shoot();
    }

    @Override
    public Entity getEntity() {
        return enemy;
    }
}

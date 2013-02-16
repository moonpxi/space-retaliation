package retaliation.game.logic;

import org.newdawn.slick.Input;
import retaliation.game.entities.Spaceship;

public class EnemyAI implements GameLogic {
    
    private final float leftSide;
    private final float rightSide;
    private float speed;
    private final Spaceship enemy;

    public EnemyAI(Spaceship enemy) {
        this.enemy = enemy;
        leftSide = enemy.position().x() - 200;
        rightSide = enemy.position().y() + 300;
        speed = -5;
    }

    @Override
    public void update(Input input, int delta) {
        float position = enemy.position().x();
        
        if (position < leftSide || position > rightSide) {
            speed *= -1;
        }
        
        enemy.move(speed, 0);
    }

    public Spaceship getShip() {
        return enemy;
    }
}

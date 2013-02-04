package retaliation.game.ai;

import retaliation.game.entities.Spaceship;

public class EnemyControls {
    
    private final float leftSide;
    private final float rightSide;
    private float speed;
    private final Spaceship enemy;

    public EnemyControls(Spaceship enemy) {
        this.enemy = enemy;
        leftSide = enemy.position().x() - 200;
        rightSide = enemy.position().y() + 300;
        speed = -5;
    }

    // TODO: write a test for this
    public void update(int delta) {
        float position = enemy.position().x();
        
        if (position < leftSide || position > rightSide) {
            speed *= -1;
        }
        
        enemy.move(speed, 0);
    }


}

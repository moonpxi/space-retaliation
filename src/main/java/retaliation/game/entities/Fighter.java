package retaliation.game.entities;

import retaliation.game.shapes.Shape;

public class Fighter extends Entity {
    private final static int SPEED = 4;

    public Fighter(int x, int y) {
        super(new Shape(x, y, 100, 20));
    }

    public void moveUp() {
        move(0, -SPEED);
    }

    public void moveDown() {
        move(0, SPEED);        
    }

    public void moveLeft() {
        move(-SPEED, 0);        
    }
    
    public void moveRight() {
        move(SPEED, 0);        
    }
}

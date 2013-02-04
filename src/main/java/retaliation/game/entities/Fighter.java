package retaliation.game.entities;

import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;
import retaliation.game.geometry.Rectangle;

public class Fighter extends Spaceship {
    private final static int SPEED = 4;

    public Fighter(int x, int y) {
        super(new Rectangle(at(x, y), size(100, 20)));
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

    public void shoot() {
        System.out.println("Shooting");
    }
}

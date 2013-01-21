package retaliation.game.entities;

import retaliation.game.shapes.Quad;

public class Fighter {
    private final static int SPEED = 4;

    private Quad shape;

    public Fighter(int x, int y) {
        shape = new Quad(x, y, 100, 20);
    }

    public Quad getShape() {
        return shape;
    }

    public void moveUp() {
        shape = shape.move(0, -SPEED);
    }

    public void moveDown() {
        shape = shape.move(0, SPEED);        
    }

    public void moveLeft() {
        shape = shape.move(-SPEED, 0);        
    }
    
    public void moveRight() {
        shape = shape.move(SPEED, 0);        
    }
}

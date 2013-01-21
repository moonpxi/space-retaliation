package retaliation.game.entities;

import retaliation.game.shapes.Quad;

public class Fighter {

    private Quad shape;

    public Fighter(int x, int y) {
        shape = new Quad(x, y, 100, 20);
    }

    public Quad getShape() {
        return shape;
    }

    public void moveUp() {
        shape = shape.move(0, -1);
    }

    public void moveDown() {
        shape = shape.move(0, 1);        
    }

    public void moveLeft() {
        shape = shape.move(-1, 0);        
    }
    
    public void moveRight() {
        shape = shape.move(1, 0);        
    }
}

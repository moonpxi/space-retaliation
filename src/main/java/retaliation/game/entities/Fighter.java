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

}

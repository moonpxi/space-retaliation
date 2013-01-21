package retaliation.game.entities;

import retaliation.game.shapes.Quad;

public class Fighter {

    private final Quad shape;

    public Fighter(int x, int y) {
        shape = new Quad(x, y, 100, 20);
    }

    public Quad getShape() {
        return shape;
    }

}

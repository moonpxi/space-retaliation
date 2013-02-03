package retaliation.game.entities;

import retaliation.game.shapes.Shape;

public class Defender extends AIEntity {

    public Defender(int x, int y) {
        super(new Shape(x, y, 40, 40));
    }

    @Override
    public void update(int delta) {

    }

}

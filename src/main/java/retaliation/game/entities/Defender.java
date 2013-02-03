package retaliation.game.entities;

import retaliation.game.shapes.Shape;

public class Defender extends AIEntity {

    private final int leftSide;
    private final int rightSide;
    private int speed;

    public Defender(int x, int y) {
        super(new Shape(x, y, 40, 40));
        leftSide = x - 200;
        rightSide = x + 300;
        speed = -5;
    }

    @Override
    public void update(int delta) {
        int position = getShape().getX();
        
        if (position < leftSide || position > rightSide) {
            speed *= -1;
        }
        
        move(speed, 0);
    }

}

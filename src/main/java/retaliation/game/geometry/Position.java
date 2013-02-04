package retaliation.game.geometry;

public class Position {

    private final float x;
    private final float y;

    public Position(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    public static Position at(float x, float y) {
        return new Position(x, y);
    }

    public float x() {
        return x;
    }

    public float y() {
        return y;
    }
}

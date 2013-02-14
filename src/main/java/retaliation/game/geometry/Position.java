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

    @Override
    public int hashCode() {
        return 961 + 31 * Float.floatToIntBits(x) + Float.floatToIntBits(y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        Position other = (Position) obj;
        return x == other.x && y == other.y;
    }
    
    
}

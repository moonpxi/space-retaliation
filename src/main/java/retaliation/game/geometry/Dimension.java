package retaliation.game.geometry;

public class Dimension {
    
    private final float width;
    private final float height;

    public Dimension(float width, float height) {
        this.width = width;
        this.height = height;
    }
    
    public static Dimension size(float width, float height) {
        return new Dimension(width, height);
    }

    public float width() {
        return width;
    }

    public float height() {
        return height;
    }

}

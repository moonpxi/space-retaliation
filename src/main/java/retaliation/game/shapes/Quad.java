package retaliation.game.shapes;

public class Quad {

    private final int x;
    private final int y;
    private final int width;
    private final int height;
 
    public Quad(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Quad move(int xAdjustment, int yAdjustment) {
        return new Quad(x + xAdjustment, y + yAdjustment, width, height);
    }
}
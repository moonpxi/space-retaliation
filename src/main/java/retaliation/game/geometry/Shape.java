package retaliation.game.geometry;


public class Shape {

    private final int x;
    private final int y;
    private final int width;
    private final int height;
 
    public Shape(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public Shape move(int xAdjustment, int yAdjustment) {
        return new Shape(x + xAdjustment, y + yAdjustment, width, height);
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
    
    public int getRightmostX() {
        return x + width;
    }

    public int getHeight() {
        return height;
    }

    public int getTopmostY() {
        return y + height;
    }

}

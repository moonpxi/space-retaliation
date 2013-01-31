package retaliation.game.shapes;

import java.util.ArrayList;

public class Shape {

    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final ArrayList<ShapeMovementListener> movementListeners;
 
    public Shape(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        movementListeners = new ArrayList<ShapeMovementListener>();
    }
    
    public void registerMovementListener(ShapeMovementListener movementListener) {
        this.movementListeners.add(movementListener);
    }
    
    public Shape move(int xAdjustment, int yAdjustment) {
        Shape newPosition = new Shape(x + xAdjustment, y + yAdjustment, width, height);
        notifyMovement(newPosition);
        return newPosition;
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

    private void notifyMovement(Shape shape) {
        for (ShapeMovementListener listener : movementListeners) {
            listener.shapeMoved(shape);
        }
    }

}

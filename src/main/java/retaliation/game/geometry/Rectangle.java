package retaliation.game.geometry;

import static retaliation.game.geometry.Position.at;


public class Rectangle {

    private final Position position;
    private final Dimension dimension;
 
    public Rectangle(Position position, Dimension dimension) {
        this.position = position;
        this.dimension = dimension;
    }
    
    public Rectangle move(float xAdjustment, float yAdjustment) {
        return new Rectangle(at(getX() + xAdjustment, getY() + yAdjustment), dimension);
    }
    
    public float getX() {
        return position.x();
    }

    public float getY() {
        return position.y();
    }

    public float getWidth() {
        return dimension.width();
    }
    
    public float getRightmostX() {
        return getX() + getWidth();
    }

    public float getHeight() {
        return dimension.height();
    }

    public float getTopmostY() {
        return getY() + getHeight();
    }

    public boolean isIntersectedWith(Rectangle anotherRectangle) {
        return (this.getX() < anotherRectangle.getRightmostX() &&
                this.getRightmostX() > anotherRectangle.getX() &&
                this.getY() < anotherRectangle.getTopmostY() &&
                this.getTopmostY() > anotherRectangle.getY());
    }
}

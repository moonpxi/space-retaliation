package retaliation.ui.renderer.slick;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import retaliation.game.shapes.Shape;
import retaliation.ui.renderer.ShapeRenderer;

public class RectShapeRenderer implements ShapeRenderer {

    private Graphics graphics;

    public RectShapeRenderer(Graphics graphics) {
        this.graphics = graphics;
    }

    @Override
    public void render(Shape shape, Color color) {
        graphics.setColor(color);
        graphics.fillRect(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
    }

}
package retaliation.ui.renderer.slick;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import retaliation.game.shapes.Quad;
import retaliation.ui.renderer.QuadRenderer;

public class SlickQuadRenderer implements QuadRenderer {

    private Graphics graphics;

    public SlickQuadRenderer(Graphics graphics) {
        this.graphics = graphics;
    }

    @Override
    public void render(Quad quad, Color color) {
        graphics.setColor(color);
        graphics.fillRect(quad.getX(), quad.getY(), quad.getWidth(), quad.getHeight());
    }

}
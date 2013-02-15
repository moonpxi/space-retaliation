package retaliation.ui.renderer;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import retaliation.game.entities.Moveable;

public class MoveableRectRenderable implements SlickRenderable {

    private final Moveable moveable;
    private final Color color;

    public MoveableRectRenderable(Moveable moveable, Color color) {
        this.moveable = moveable;
        this.color = color;
    }
    
    @Override
    public void render(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillRect(moveable.position().x(), moveable.position().y(),
                          moveable.dimension().width(), moveable.dimension().height());
    }

}

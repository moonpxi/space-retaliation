package retaliation.ui.renderer;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import retaliation.game.entities.Level;
import retaliation.game.entities.Moveable;
import retaliation.game.entities.Spaceship;

public class LevelRenderer implements SlickRenderer {

    private final Level level;

    public LevelRenderer(Level level) {
        this.level = level;
    }

    @Override
    public void render(Graphics graphics) {
        renderMoveable(graphics, level.getPlayer(), Color.green);

        for (Spaceship enemy : level.getEnemies()) {
            renderMoveable(graphics, enemy, Color.white);
        }

        for (Moveable laser : level.getLasers()) {
            renderMoveable(graphics, laser, Color.green);
        }
    }

    private void renderMoveable(Graphics graphics, Moveable moveable, Color color) {
        graphics.setColor(color);
        graphics.fillRect(moveable.position().x(), moveable.position().y(),
                moveable.dimension().width(), moveable.dimension().height());
    }
}

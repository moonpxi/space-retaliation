package retaliation.ui.renderer;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import retaliation.game.entities.Entities;
import retaliation.game.entities.Entity;
import retaliation.game.entities.EntityType;

public class LevelRenderer implements SlickRenderer {

    private final Entities entities;

    public LevelRenderer(Entities entities) {
        this.entities = entities;
    }

    @Override
    public void render(Graphics graphics) {
        int count = 0;

        for (Entity entity : entities.activeEntities()) {
            count++;

            Color color = Color.green;
            if (entity.getType() == EntityType.Enemy) {
                color = Color.white;
            }
            renderMoveable(graphics, entity, color);
        }

        graphics.drawString("Live entities: " + count, 400, 10);
    }

    private void renderMoveable(Graphics graphics, Entity entity, Color color) {
        graphics.setColor(color);
        graphics.fillRect(entity.position().x(), entity.position().y(),
                entity.dimension().width(), entity.dimension().height());
    }
}

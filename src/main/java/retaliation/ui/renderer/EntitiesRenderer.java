package retaliation.ui.renderer;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import retaliation.game.entities.Entities;
import retaliation.game.entities.Entity;
import retaliation.game.entities.Laser;

import static retaliation.game.entities.Laser.Direction.Upwards;

public class EntitiesRenderer implements SlickRenderer {

    private final Entities entities;

    public EntitiesRenderer(Entities entities) {
        this.entities = entities;
    }

    @Override
    public void render(Graphics graphics) {
        int count = 0;

        for (Entity entity : entities.activeEntities()) {
            count++;

            Color color = colorFor(entity);
            renderMoveable(graphics, entity, color);
        }
    }

    private Color colorFor(Entity entity) {
        switch (entity.getType()) {
            case Enemy:
                return Color.white;
            case Player:
                return Color.green;
            case Laser:
                return ((Laser) entity).direction() == Upwards ? Color.green : Color.white;
            default:
                return Color.white;
        }
    }

    private void renderMoveable(Graphics graphics, Entity entity, Color color) {
        graphics.setColor(color);
        graphics.fillRect(entity.position().x(), entity.position().y(),
                          entity.dimension().width(), entity.dimension().height());
    }
}

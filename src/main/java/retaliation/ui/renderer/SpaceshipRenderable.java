package retaliation.ui.renderer;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import retaliation.game.entities.Spaceship;

public class SpaceshipRenderable implements SlickRenderable {

    private final Spaceship spaceship;
    private final Color color;

    public SpaceshipRenderable(Spaceship spaceship, Color color) {
        this.spaceship = spaceship;
        this.color = color;
    }
    
    // TODO: test this
    @Override
    public void render(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillRect(spaceship.position().x(), spaceship.position().y(), 
                          spaceship.dimension().width(), spaceship.dimension().height());
    }

}

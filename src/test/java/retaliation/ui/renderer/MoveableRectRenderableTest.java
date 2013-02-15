package retaliation.ui.renderer;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import retaliation.game.entities.Moveable;

import static retaliation.game.geometry.Dimension.size;
import static retaliation.game.geometry.Position.at;

public class MoveableRectRenderableTest {
    private final Mockery context = new Mockery() {{
        setImposteriser(ClassImposteriser.INSTANCE);
    }};
    private final Graphics graphics = context.mock(Graphics.class);

    @Test
    public void rendersSpaceshipAsARect() {
        context.checking(new Expectations() {{
            oneOf(graphics).setColor(Color.blue);
            oneOf(graphics).fillRect(10, 20, 200, 300);
        }});
        
        new MoveableRectRenderable(new Moveable(at(10, 20), size(200, 300)), Color.blue). render(graphics);
        
        context.assertIsSatisfied();
    }

}

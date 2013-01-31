package retaliation.ui.renderer.slick;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import retaliation.game.shapes.Shape;

public class RectShapeRendererTest {
    Mockery context = new Mockery() {{
      setImposteriser(ClassImposteriser.INSTANCE);
    }};
    private final Graphics graphics = context.mock(Graphics.class);
    
    @Test
    public void drawsARectangleFromQuad() {        
        final Shape someShape = new Shape(10, 20, 30, 40);
        final Color someColor = Color.black;                
        
        context.checking(new Expectations() {{
            oneOf(graphics).setColor(someColor);
            oneOf(graphics).fillRect(10, 20, 30, 40);
        }});
        
        new RectShapeRenderer(graphics).render(someShape, someColor);
        
        context.assertIsSatisfied();
    }

}

package retaliation.ui.renderer.slick;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import retaliation.game.shapes.Quad;

public class SlickQuadRendererTest {
    Mockery context = new Mockery() {{
      setImposteriser(ClassImposteriser.INSTANCE);
    }};
    
    @Test
    public void drawsARectangleFromQuad() {
        final Graphics graphics = context.mock(Graphics.class);
        Quad someQuad = new Quad(10, 20, 30, 40);
        final Color someColor = Color.black;
        
        SlickQuadRenderer renderer = new SlickQuadRenderer(graphics);
        
        context.checking(new Expectations() {{
            oneOf(graphics).setColor(someColor);
            oneOf(graphics).fillRect(10, 20, 30, 40);
        }});
        
        renderer.render(someQuad, someColor);
        
        context.assertIsSatisfied();
    }

}

package retaliation.ui.input.slick;

import static java.util.Arrays.asList;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;
import org.newdawn.slick.Input;

import retaliation.ui.input.Controls;

public class SlickInputControllerTest {
    Mockery context = new Mockery() {{
        setImposteriser(ClassImposteriser.INSTANCE);
    }};
    private final Input input = context.mock(Input.class);
    private final Controls controls = context.mock(Controls.class);

    @Test
    public void notifyControlsWhenRelevantInputKeyIsDown() {
        context.checking(new Expectations() {{
            oneOf(controls).keysToListen(); will(returnValue(asList(41, 42, 43)));
            
            oneOf(input).isKeyDown(41); will(returnValue(true));
            oneOf(input).isKeyDown(42); will(returnValue(false));
            oneOf(input).isKeyDown(43); will(returnValue(true));
            
            oneOf(controls).keyDown(41);
            oneOf(controls).keyDown(43);
        }});
        
        new SlickInputController(input).listenToInputFor(controls);
        
        context.assertIsSatisfied();
    }

}

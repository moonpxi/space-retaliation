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
            oneOf(input).isKeyDown(41); will(returnValue(true));
            oneOf(input).isKeyDown(42); will(returnValue(false));
            oneOf(input).isKeyDown(43); will(returnValue(true));
            
            oneOf(controls).notifyKeyDown(41);
            oneOf(controls).notifyKeyDown(43);
        }});
        
        
        SlickInputController controller = new SlickInputController(input);
        controller.listenToKeysFor(controls, asList(41, 42, 43));
        controller.processInputAndNotifyControls();
        
        context.assertIsSatisfied();
    }

}

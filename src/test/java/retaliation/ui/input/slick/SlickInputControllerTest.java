package retaliation.ui.input.slick;

import static java.util.Arrays.asList;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;
import org.newdawn.slick.Input;

import retaliation.ui.input.Controls;

public class SlickInputControllerTest {
    private final Mockery context = new Mockery() {{
        setImposteriser(ClassImposteriser.INSTANCE);
    }};
    private final Input input = context.mock(Input.class);
    private final Controls controls = context.mock(Controls.class, "Controls");
    private final Controls otherControls = context.mock(Controls.class, "Other Controls");

    @Test
    public void notifySingleControlsWhenRelevantInputKeyIsDown() {
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
    
    @Test
    public void notifyMultipleControls() {
        context.checking(new Expectations() {{
            oneOf(input).isKeyDown(40); will(returnValue(true));
            oneOf(input).isKeyDown(50); will(returnValue(true));
            
            oneOf(controls).notifyKeyDown(40);
            oneOf(otherControls).notifyKeyDown(50);
        }});
        
        
        SlickInputController controller = new SlickInputController(input);
        controller.listenToKeysFor(controls, asList(40));
        controller.listenToKeysFor(otherControls, asList(50));
        controller.processInputAndNotifyControls();
        
        context.assertIsSatisfied();
    }

}

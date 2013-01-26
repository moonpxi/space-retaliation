package retaliation.ui.input.slick;

import java.util.List;

import org.newdawn.slick.Input;

import retaliation.ui.input.Controls;
import retaliation.ui.input.InputController;

public class SlickInputController implements InputController {

    private final Input slickInput;
    private Controls controls;
    private List<Integer> keyCodes;

    public SlickInputController(Input slickInput) {
        this.slickInput = slickInput;
    }

    @Override
    public void listenToKeysFor(Controls controls, List<Integer> keyCodes) {
        this.controls = controls;
        this.keyCodes = keyCodes;
    }

    @Override
    public void processInputAndNotifyControls() {
        for (int keyCode : keyCodes) {
            if (slickInput.isKeyDown(keyCode)) {
                controls.notifyKeyDown(keyCode);
            }
        }  
    }

}

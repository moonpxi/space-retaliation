package retaliation.ui.input.slick;

import org.newdawn.slick.Input;

import retaliation.ui.input.Controls;
import retaliation.ui.input.InputController;

public class SlickInputController implements InputController {

    private final Input slickInput;

    public SlickInputController(Input slickInput) {
        this.slickInput = slickInput;
    }

    @Override
    public void listenToInputFor(Controls controls) {
        for (int keyCode : controls.keysToListen()) {
            if (slickInput.isKeyDown(keyCode)) {
                controls.keyDown(keyCode);
            }
        }
    }

}

package retaliation.ui.input.slick;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Input;

import retaliation.ui.input.Controls;
import retaliation.ui.input.InputController;

public class SlickInputController implements InputController {

    private final Input slickInput;
    private final List<Entry> controlEntries = new ArrayList<Entry>();

    public SlickInputController(Input slickInput) {
        this.slickInput = slickInput;
    }

    @Override
    public void listenToKeysFor(Controls controls, List<Integer> keyCodes) {
        controlEntries.add(new Entry(keyCodes, controls));
    }

    @Override
    public void processInputAndNotifyControls() {
        for (Entry entry : controlEntries) {
            for (int keyCode : entry.keyCodes) {
                if (slickInput.isKeyDown(keyCode)) {
                    entry.controls.notifyKeyDown(keyCode);
                }
            }
        }
    }
    
    private class Entry {
        public final List<Integer> keyCodes;
        public final Controls controls;

        public Entry(List<Integer> keyCodes, Controls controls) {
            this.keyCodes = keyCodes;
            this.controls = controls;
            
        }
    }

}

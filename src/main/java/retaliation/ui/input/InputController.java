package retaliation.ui.input;

import java.util.List;

public interface InputController {
    
    public void listenToKeysFor(Controls controls, List<Integer> keyCodes);

    public void processInputAndNotifyControls();
}

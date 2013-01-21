package retaliation.ui.input;

import java.util.List;

public interface Controls {

    public List<Integer> keysToListen(); 
    
    public void keyDown(int keyCode);
}

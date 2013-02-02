package retaliation;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {
	 
  public static void main(String[] args) throws SlickException {
     AppGameContainer app = new AppGameContainer(new Game());         
     app.setDisplayMode(800, 600, false);
     app.setTitle("Space Retaliation");
     app.setTargetFrameRate(100);
     app.setSmoothDeltas(true);
     app.setVSync(true);
     app.start();	
  }
}

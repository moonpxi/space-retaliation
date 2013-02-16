package retaliation.game.rules;

import org.newdawn.slick.Input;
import retaliation.game.entities.Entity;
import retaliation.game.entities.Spaceship;
import retaliation.game.geometry.Rectangle;
import retaliation.game.logic.GameLogic;

public class EnforceLevelBoundaryRule implements GameLogic {

    private final Rectangle boundary;
    private final Spaceship ship;

    public EnforceLevelBoundaryRule(Rectangle boundary, Spaceship ship) {
        this.boundary = boundary;
        this.ship = ship;
    }
    
    public void enforceBoundaryOn(Entity ship) {
        Rectangle newPosition = new Rectangle(ship.position(), ship.dimension());
        
        float xAdjustment = calculateAdjustment(newPosition.getX(), newPosition.getRightmostX(),
                                              boundary.getX(), boundary.getRightmostX()),
              yAdjustment = calculateAdjustment(newPosition.getY(), newPosition.getTopmostY(),
                                              boundary.getY(), boundary.getTopmostY());
                
        if (xAdjustment != 0 || yAdjustment != 0) {
            ship.move(xAdjustment, yAdjustment);
        } 
    }

    private float calculateAdjustment(float lowerPosition, float upperPosition, float lowerBoundary, float upperBoundary) {
        if (lowerPosition < lowerBoundary) {
            return lowerBoundary - lowerPosition;
        } else if (upperPosition > upperBoundary) {
            return upperBoundary - upperPosition;
        }
        return 0;
    }

    @Override
    public void update(Input input, int delta) {
        enforceBoundaryOn(ship);
    }
}

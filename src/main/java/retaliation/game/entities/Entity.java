package retaliation.game.entities;

import retaliation.game.geometry.Dimension;
import retaliation.game.geometry.Position;
import retaliation.game.geometry.Rectangle;

import static retaliation.game.entities.Entity.State.Alive;

public class Entity {

    public enum State {
        Alive, Destroyed
    }

    private final EntityType type;
    private State state;
    private Position position;
    private final Dimension dimension;

    public Entity(EntityType type, Position position, Dimension dimension) {
        this.type = type;
        this.position = position;
        this.dimension = dimension;
        changeTo(Alive);
    }

    public EntityType getType() {
        return type;
    }

    public State state() {
        return state;
    }

    public void changeTo(State newState) {
        state = newState;
    }

    public void move(float xMovement, float yMovement) {
        position = Position.at(position.x() + xMovement, position.y() + yMovement);
    }
    
    public Position position() {
        return position;
    }

    public Dimension dimension() {
        return dimension;
    }

    public Rectangle rectangle() {
        return new Rectangle(position(), dimension());
    }

    public boolean collideWith(Entity anotherEntity) {
        return this.rectangle().isIntersectedWith(anotherEntity.rectangle());
    }
}

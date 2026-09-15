package com.rafalf.game.entities;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class Entity {
    protected float maxHp;
    protected float currentHp;
    protected float dmg;
    protected float speed;

    protected Vector2 position;  // X e Y
    protected Vector2 velocity;
    protected Rectangle hitbox;

    // TextureRegion rappresenta il fotogramma corrente da disegnare a schermo
    protected TextureRegion currentFrame;
    // Dimensioni dello sprite
    protected float width;
    protected float height;

    public enum State { IDLE, WALKING, ATTACKING, DEAD }
    protected State currentState; //STATO DELL'ENTITÀ

    public Entity(float startX, float startY, float width, float height) {
        this.position = new Vector2(startX, startY);
        this.velocity = new Vector2(0, 0);
        this.width = width;
        this.height = height;
        // La hitbox viene creata usando le coordinate e le dimensioni
        this.hitbox = new Rectangle(startX, startY, width, height);
        this.currentState = State.IDLE;
    }
    public abstract void update(float delta); //update automatico del frame dopo inattività

    public void takeDamage(float damageTaken) {
        if (currentState == State.DEAD) return;
        currentHp -= damageTaken;
        if (currentHp <= 0) {
            currentHp = 0;
            die();
        }
    }

    protected void die() {
        currentState = State.DEAD;
    }
    //Muove l hitbox in base al movimento
    protected void updateHitbox() {
        hitbox.setPosition(position.x, position.y);
    }

    public Vector2 getPosition() { return position; }
    public Rectangle getHitbox() { return hitbox; }
    public State getCurrentState() { return currentState; }
    public float getCurrentHp() { return currentHp; }
    public TextureRegion getCurrentFrame() { return currentFrame; }
}

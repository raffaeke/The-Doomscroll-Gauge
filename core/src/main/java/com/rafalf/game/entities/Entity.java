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

}

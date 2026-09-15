package com.rafalf.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public class MainCharacter extends Entity {
    private float maxStamina;
    private float currentStamina;
    private float maxMadness;
    private float currentMadness;

    private int money;

    // EQUIPAGGIAMENTO / INVENTARIO
    // private Weapon equippedWeapon;
    // private Inventory inventory;

    public MainCharacter(Vector2 startPosition) {
        super(startPosition.x, startPosition.y, 0, 0);
        this.maxHp = 0;
        this.currentHp = maxHp;
        this.dmg = 0;
        this.speed = 0; // pixel al secondo
        this.currentState = State.IDLE;

        this.maxStamina = 0;
        this.currentStamina = maxStamina;
        this.maxMadness = 0;
        this.currentMadness = maxMadness;

        this.money = 0;
    }

    public void update(float delta) {
        if (currentState == State.DEAD) return;
        handleInput();
        // Movimento (velocità * tempo * direzione)
        position.x += velocity.x * speed * delta;
        position.y += velocity.y * speed * delta;
        updateHitbox();
    }

    public void handleInput() {
        velocity.set(0, 0);
        if (Gdx.input.isKeyPressed(Input.Keys.W)) velocity.y = 1;
        if (Gdx.input.isKeyPressed(Input.Keys.S)) velocity.y = -1;
        if (Gdx.input.isKeyPressed(Input.Keys.A)) velocity.x = -1;
        if (Gdx.input.isKeyPressed(Input.Keys.D)) velocity.x = 1;

        if (velocity.x != 0 || velocity.y != 0) {
            velocity.nor(); // Evita che andando in diagonale si vada più veloci
            if (currentState != State.ATTACKING) {
                currentState = State.WALKING;
            }
        } else {
            if (currentState != State.ATTACKING) {
                currentState = State.IDLE;
            }
        }

        // Tasto di attacco
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            performAttack();
        }
    }
    private void performAttack() {}
}

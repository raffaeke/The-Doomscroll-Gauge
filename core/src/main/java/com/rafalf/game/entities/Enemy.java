package com.rafalf.game.entities;

import com.badlogic.gdx.math.Vector2;

public abstract class Enemy extends Entity {
    // --- LOGICA AI ---
    protected float seeRange;
    protected float attackRange;
    protected Entity target;

    // --- RICOMPENSE ---
    protected int experienceGiven;
    // private Weapon randomWeapon;

    public Enemy(Vector2 startPosition, Entity target) {
        this.position = startPosition;
        this.target = target;
    }
    public float getDistanceToTarget() {
        return this.position.dst(target.position);
    }

    public abstract void updateAI(float delta);
    public abstract void performAttack();
}

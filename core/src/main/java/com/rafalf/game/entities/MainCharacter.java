package com.rafalf.game.entities;

import com.badlogic.gdx.math.Vector2;

public class MainCharacter extends Entity {
    private float maxStamina;
    private float currentStamina;
    private float maxMadness;
    private float currentMadness;

    private int level;
    private int money;
    private int experiencePoints;

    //  EQUIPAGGIAMENTO / INVENTARIO
    // private Weapon equippedWeapon;
    // private Inventory inventory;

    public MainCharacter(Vector2 startPosition) {
        this.position = startPosition;
        this.maxHp = 0;
        this.currentHp = maxHp;
        this.dmg = 0;
        this.speed = 0; // pixel al secondo
        this.currentState = null;

        // Inizializza la hitbox in base alle dimensioni del personaggio
    }

    // Logica per leggere l'input (tastiera/mouse)
    public void handleInput() { }
}

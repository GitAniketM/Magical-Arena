package com.example.magicalArena.model;

import java.util.Random;

public class Player {
    private int health;
    private int strength;
    private int attack;
    private Random random;
    private String name;

    public String getName() {
        return name;
    }

    public Player(String name, int health, int strength, int attack) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.attack = attack;
        this.random = new Random();
    }

    // Getters
    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getAttack() {
        return attack;
    }

    // Method for player to attack opponent
    public int attack() {
        return random.nextInt(6) + 1; // Roll a 6-sided die
    }

    // Method for player to defend against attack
    public int defend() {
        return random.nextInt(6) + 1; // Roll a 6-sided die
    }

    // Method to calculate damage received after defending
    public void receiveDamage(int damage) {
        int defense = defend();
        int actualDamage = Math.max(0, damage - (defense * strength));
        health -= actualDamage;
        if (health < 0) {
            health = 0;
        }
    }

    // Method to check if player is alive
    public boolean isAlive() {
        return health > 0;
    }
}

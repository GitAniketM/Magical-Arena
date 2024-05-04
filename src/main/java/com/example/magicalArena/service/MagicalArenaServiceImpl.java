package com.example.magicalArena.service;

import com.example.magicalArena.model.Player;

import java.util.Random;

public class MagicalArenaServiceImpl {
    private Player playerA;
    private Player playerB;

    public MagicalArenaServiceImpl(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }

    public void simulateMatch() {
        Player attacker = playerA.getHealth() < playerB.getHealth() ? playerA : playerB;
        Player defender = attacker == playerA ? playerB : playerA;

        while (playerA.isAlive() && playerB.isAlive()) {
            int attackRoll = attacker.attack();
            int defenseRoll = defender.defend();

            int attackDamage = attackRoll * attacker.getAttack();
            int defenseDamage = defenseRoll * defender.getStrength();

            defender.receiveDamage(Math.max(0, attackDamage - defenseDamage));

            // Swap roles for next round
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }

        if (playerA.isAlive()) {
            System.out.println(playerA.getName()+" wins !");
        } else {
            System.out.println(playerB.getName()+" wins !");
        }
    }
}


package com.example.magicalArena.service;

import com.example.magicalArena.model.Player;

public class MagicalArenaServiceImpl {
    private Player playerA;
    private Player playerB;

    public MagicalArenaServiceImpl(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }

    public void simulateMatch() {
        System.out.println("======= Starting a match in the Magical Arena =======");

        Player attacker = playerA.getHealth() < playerB.getHealth() ? playerA : playerB;
        Player defender = attacker == playerA ? playerB : playerA;

        while (playerA.isAlive() && playerB.isAlive()) {
            int attackRoll = attacker.attack();
            int defenseRoll = defender.defend();

            int attackDamage = attackRoll * attacker.getAttack();
            int defenseDamage = defenseRoll * defender.getStrength();

            int damageDealt = Math.max(0, attackDamage - defenseDamage);

            defender.receiveDamage(damageDealt);

            // Swap roles for next round
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }
        if (playerA.isAlive()) {
            System.out.println(playerA.getName() + " wins!");
        } else {
            System.out.println(playerB.getName() + " wins!");
        }
        System.out.println("======= Match Ended =======");
    }
}


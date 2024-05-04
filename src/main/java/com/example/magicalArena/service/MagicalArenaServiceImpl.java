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
        System.out.println("Player A (Health: " + playerA.getHealth() + ", Strength: " + playerA.getStrength() + ", Attack: " + playerA.getAttack() + ")");
        System.out.println("Player B (Health: " + playerB.getHealth() + ", Strength: " + playerB.getStrength() + ", Attack: " + playerB.getAttack() + ")");
        System.out.println("-------------------------------------------------------");

        Player attacker = playerA.getHealth() < playerB.getHealth() ? playerA : playerB;
        Player defender = attacker == playerA ? playerB : playerA;

        while (playerA.isAlive() && playerB.isAlive()) {
            System.out.println("-------------------------------------------------------");
            System.out.println(attacker.getName() + " attacks!");
            System.out.println("Rolling dice...");
            int attackRoll = attacker.attack();
            System.out.println(attacker.getName() + " rolls " + attackRoll + " for attack!");

            System.out.println(defender.getName() + " defends!");
            System.out.println("Rolling dice...");
            int defenseRoll = defender.defend();
            System.out.println(defender.getName() + " rolls " + defenseRoll + " for defense!");

            int attackDamage = attackRoll * attacker.getAttack();
            int defenseDamage = defenseRoll * defender.getStrength();

            int damageDealt = Math.max(0, attackDamage - defenseDamage);
            System.out.println("Attack damage: " + attackDamage);
            System.out.println("Defense strength: " + defenseDamage);
            System.out.println(defender.getName() + " receives " + damageDealt + " damage!");

            defender.receiveDamage(damageDealt);

            // Swap roles for next round
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }

        System.out.println("-------------------------------------------------------");
        if (playerA.isAlive()) {
            System.out.println(playerA.getName() + " wins!");
        } else {
            System.out.println(playerB.getName() + " wins!");
        }
        System.out.println("======= Match Ended =======");
    }
}


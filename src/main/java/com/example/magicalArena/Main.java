package com.example.magicalArena;

import com.example.magicalArena.model.Player;
import com.example.magicalArena.service.MagicalArenaServiceImpl;

public class Main {
    public static void main(String[] args){
        Player playerA = new Player("Aniket",50, 5, 10);
        Player playerB = new Player("Rahul",100, 10, 5);

        MagicalArenaServiceImpl arena = new MagicalArenaServiceImpl(playerA, playerB);
        arena.simulateMatch();
    }
}

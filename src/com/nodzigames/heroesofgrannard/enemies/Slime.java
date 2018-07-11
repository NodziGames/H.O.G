package com.nodzigames.heroesofgrannard.enemies;

import com.nodzigames.heroesofgrannard.maths.Maths;

public class Slime extends Enemy {

    public Slime() {

        setName("Slime");

        setDefense(10);
        setStrength(50);
        setVitality(200);
        setHp(getVitality());

        //Drops
        setGold(Maths.random_range_int(50, 75));
        setXp(Maths.random_range_int(15, 25));

        //Set Up Shouts
        shouts.add("Slurp!");
        shouts.add("Swoosh!");
        shouts.add("Wobble!");
        shouts.add("Squish!");
        shouts.add("Splat!");

    }
}

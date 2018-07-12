package com.nodzigames.heroesofgrannard.enemies;

import com.nodzigames.heroesofgrannard.maths.Maths;

public class Birb extends Enemy {

    public Birb() {

        setName("Birb");

        setDefense(0);
        setStrength(100);
        setVitality(250);
        setHp(getVitality());

        //Drops
        setGold(Maths.random_range_int(50, 75));
        setXp(Maths.random_range_int(15, 25));

        //Set Up Shouts
        shouts.add("Swiggity");
        shouts.add("Swooty");
        shouts.add("Do u want sum f*k?");
        shouts.add("Becky");
        shouts.add("Ben is a hoe");
    }
}

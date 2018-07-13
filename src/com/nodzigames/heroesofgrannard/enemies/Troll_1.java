package com.nodzigames.heroesofgrannard.enemies;

import com.nodzigames.heroesofgrannard.maths.Maths;

public class Troll_1 extends Enemy {

    public Troll_1() {
        setName("Naked Troll");

        setDefense(50);
        setStrength(120);
        setVitality(500);
        setHp(getVitality());

        //Drops
        setGold(Maths.random_range_int(150, 200));
        setXp(Maths.random_range_int(50, 80));

        //Set Up Shouts
        shouts.add("Raaaaaah");
        shouts.add("Me very big");
        shouts.add("Who invite you to me party?");
        shouts.add("I kill you");
        shouts.add("Run tiny person");
    }
}

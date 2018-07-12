package com.nodzigames.heroesofgrannard.enemies;

import com.nodzigames.heroesofgrannard.maths.Maths;

public class Skeleton_1 extends Enemy{

    public Skeleton_1() {

        setName("Skeleton");

        setDefense(20);
        setStrength(150);
        setVitality(280);
        setHp(getVitality());

        //Drops
        setGold(Maths.random_range_int(85, 135));
        setXp(Maths.random_range_int(35, 50));

        //Set Up Shouts
        shouts.add("*Clack*");
        shouts.add("*Thwack*");
        shouts.add("*Click*");
        shouts.add("*Clonk*");
        shouts.add("*Crack*");
    }
}

package com.nodzigames.heroesofgrannard.enemies;

import com.nodzigames.heroesofgrannard.maths.Maths;

public class Badabook_1 extends Enemy{
    public Badabook_1() {

        setName("Badabook");

        setDefense(30);
        setStrength(130);
        setVitality(320);
        setHp(getVitality());

        //Drops
        setGold(Maths.random_range_int(75, 125));
        setXp(Maths.random_range_int(25, 40));

        //Set Up Shouts
        shouts.add("REEEEEEEEEEEEEE");
        shouts.add("WHY CAN'T YOU JUST BE NORMAL?");
        shouts.add("*SCREECHING*");
        shouts.add("MA! MAMMA");
        shouts.add("MOMMY");
    }
}

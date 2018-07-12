package com.nodzigames.heroesofgrannard.classes;

import com.nodzigames.heroesofgrannard.items.Rock_0;
import com.nodzigames.heroesofgrannard.items.Speedo_0;

public class Grunt extends Player{

    //Constructor
    public Grunt(String name, int age) {
        setName(name);
        setAge(age);

        weapon = new Rock_0();
        armor = new Speedo_0();

        //Class Specific stats (Has to total 400, and every 5 vitality counts as 1 point)
        setStrength(125);
        setDefense(125);
        setIntelligence(50);
        setVitality(700);
        setHp(getVitality());

        //Set Up Shouts
        shouts.add("Me Go Smash");
        shouts.add("Ooof");
        shouts.add("Raaaaah");
        shouts.add("Me Angry Now");
        shouts.add("Come Back Here Wussy");
        shouts.add("Haha Look At Silly Person Hurt");
        shouts.add("Ruuuuuuuuun Mwahahaha");
        shouts.add("Come and Play With Me");
    }
}

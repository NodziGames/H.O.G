package com.nodzigames.heroesofgrannard.classes;

import com.nodzigames.heroesofgrannard.items.BareFists_1;
import com.nodzigames.heroesofgrannard.items.Yeezies_1;

public class Samurai extends Player {
    //Constructor
    public Samurai(String name, int age) {
        setName(name);
        setAge(age);

        weapon = new BareFists_1();
        armor = new Yeezies_1();

        //Class Specific stats (Has to total 400, and every 5 vitality counts as 1 point)
        setStrength(130);
        setDefense(80);
        setIntelligence(110);
        setVitality(400);
        setHp(getVitality());

        //Set Up Shouts
        shouts.add("TEMMEEEE");
        shouts.add("SHINDE");
        shouts.add("OWARITA");
        shouts.add("YAMETE");
        shouts.add("OMAE WA MOU SHINDEIRU");
        shouts.add("NANI?");
        shouts.add("DAMEDE");
        shouts.add("USODARO?");
    }
}

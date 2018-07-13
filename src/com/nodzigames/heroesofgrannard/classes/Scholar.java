package com.nodzigames.heroesofgrannard.classes;

import com.nodzigames.heroesofgrannard.items.Book_0;
import com.nodzigames.heroesofgrannard.items.ScholarsRobe_0;

public class Scholar extends Player {

    public Scholar(String name, int age) {
        setName(name);
        setAge(age);

        weapon = new Book_0();
        armor = new ScholarsRobe_0();

        //Class Specific stats (Has to total 400, and every 5 vitality counts as 2 point)
        setStrength(85);
        setDefense(85);
        setIntelligence(135);
        setVitality(500);
        setHp(getVitality());

        //Set Up Shouts
        shouts.add("The Power of Science");
        shouts.add("Knowledge Above Strength");
        shouts.add("*Hmmmph*");
        shouts.add("If Only You Were Smarter");
        shouts.add("Outplayed");
        shouts.add("Impressive");
        shouts.add("Not Too Shabby");
        shouts.add("I Have Studies To Attend To");
    }
}

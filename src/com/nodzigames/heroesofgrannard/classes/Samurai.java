package com.nodzigames.heroesofgrannard.classes;

import com.nodzigames.heroesofgrannard.items.Kamishimo_1;
import com.nodzigames.heroesofgrannard.items.KendoStick_1;

public class Samurai extends Player {
    //Constructor
    public Samurai(String name, int age) {
        setName(name);
        setAge(age);

        weapon = new KendoStick_1();
        armor = new Kamishimo_1();

        //Class Specific stats (Has to total 400, and every 5 vitality counts as 1 point)
        setStrength(130);
        setDefense(80);
        setIntelligence(110);
        setVitality(400);
        setHp(getVitality());

        //Set Up Shouts
        shouts.add("KAKATTE KOI YO");
        shouts.add("SHINDE KUDUSAI");
        shouts.add("KURAE");
        shouts.add("SASERU KA");
        shouts.add("OMAE WA MOU SHINDEIRU");
        shouts.add("YURUSENAI");
        shouts.add("CHIKUSHO");
        shouts.add("YOSSHA");
    }
}

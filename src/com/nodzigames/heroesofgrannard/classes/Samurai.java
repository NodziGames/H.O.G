package com.nodzigames.heroesofgrannard.classes;

import com.nodzigames.heroesofgrannard.items.Kamishimo_0;
import com.nodzigames.heroesofgrannard.items.KendoStick_0;

public class Samurai extends Player {
    //Constructor
    public Samurai(String name, int age) {
        setName(name);
        setAge(age);

        weapon = new KendoStick_0();
        armor = new Kamishimo_0();

        //Class Specific stats (Has to total 400, and every 5 vitality counts as 2 point)
        setStrength(125);
        setDefense(85);
        setIntelligence(110);
        setVitality(450);
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

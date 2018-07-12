package com.nodzigames.heroesofgrannard.classes;


import com.nodzigames.heroesofgrannard.items.BareFists_0;
import com.nodzigames.heroesofgrannard.items.Yeezies_0;

public class Human extends Player{

    //Constructor
    public Human(String name, int age) {
        setName(name);
        setAge(age);

        weapon = new BareFists_0();
        armor = new Yeezies_0();

        //Class Specific stats (Has to total 400, and every 5 vitality counts as 1 point)
        setStrength(100);
        setDefense(100);
        setIntelligence(100);
        setVitality(500);
        setHp(getVitality());

        //Set Up Shouts
        shouts.add("HIIIYAA");
        shouts.add("HUFF");
        shouts.add("*GRUNT*");
        shouts.add("HEEEEEEEE");
        shouts.add("TAKE THAT");
        shouts.add("HA");
        shouts.add("BEGONE THOT");
        shouts.add("WHO'S YOUR DADDY?");
    }
}

package com.nodzigames.heroesofgrannard.classes;

public class Samurai extends Player {
    //Constructor
    public Samurai(String name, int age) {
        setName(name);
        setAge(age);

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

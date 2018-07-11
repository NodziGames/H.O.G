package com.nodzigames.heroesofgrannard.enemies;

import com.nodzigames.heroesofgrannard.maths.Maths;
import com.nodzigames.heroesofgrannard.renderer.Renderer;

import java.util.ArrayList;
import java.util.List;

public class Enemy {

    private String name;

    //Stats
    private int strength;
    private int defense;
    private long vitality;
    private long hp;

    //Drops
    private long gold;
    private long xp;

    //Shouts
    List<String> shouts;

    public Enemy() {

        shouts = new ArrayList<>();

    }

    //Takes damage and returns remaining health
    public long takeDamage(long damage) {

        long damageToTake = Math.max(1, damage - defense);

        hp -= damageToTake;

        return hp;
    }


    public void shout() {

        int pick = Maths.random_range_int(0, shouts.size() - 1);

        Renderer.shout(shouts.get(pick));
    }














    //Boilerplate Code! -----------------------------------

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public long getVitality() {
        return vitality;
    }

    public void setVitality(long vitality) {
        this.vitality = vitality;
    }

    public long getHp() {
        return hp;
    }

    public void setHp(long hp) {
        this.hp = hp;
    }

    public long getGold() {
        return gold;
    }

    public void setGold(long gold) {
        this.gold = gold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getXp() {
        return xp;
    }

    public void setXp(long xp) {
        this.xp = xp;
    }

    //TODO: Add a toString override for enemy!
}

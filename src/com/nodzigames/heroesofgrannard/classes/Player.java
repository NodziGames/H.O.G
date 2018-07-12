package com.nodzigames.heroesofgrannard.classes;


//All classes will inherit from the player class, overriding some of the functionality.

import com.nodzigames.heroesofgrannard.items.Armor;
import com.nodzigames.heroesofgrannard.items.Weapon;
import com.nodzigames.heroesofgrannard.maths.Maths;
import com.nodzigames.heroesofgrannard.renderer.Renderer;
import com.nodzigames.heroesofgrannard.stepper.Stepper;

import java.util.ArrayList;
import java.util.List;

public class Player {

    //Character details
    private String name;
    private int age;

    //Stats
    private int strength;
    private int defense;
    private int intelligence;

    private long hp;
    private long vitality; //Max Hp
    private long xp;
    private long xpreq;
    private int level;
    private long gold;

    public Weapon weapon;
    public Armor armor;

    //Arrays
    public List<String> shouts;


    //Constructor
    public Player() {
        xp = 0;
        level = 1;
        xpreq = 50;
        gold = 0;

        shouts = new ArrayList<>();
    }


    //General Functions

    //Test to see if player levelled yet
    public boolean levelUpCheck() {

        boolean lvld = false;

        while (xp >= xpreq) {
            xp -= xpreq;
            level++;
            xpreq += 50;
            levelUp();
            lvld = true;
        }

        return lvld;

    }


    //EVENTS =======================================================

    public void levelUp() {
        Renderer.cls();
        int strengthChange = Math.round(strength / 10);
        int defenseChange = Math.round(defense / 10);
        int intelligenceChange = Math.round(intelligence / 10);
        int vitalityChange = Math.round(vitality / 10);

        //Be verbal about it!
        System.out.println(
                "LEVEL UP! ================" + "\n" +
                        "\n" +
                        "You are now level " + level + "\n" +
                        "\n" +
                        "STAT CHANGES============" + "\n" +
                        "\n" +
                        "STR: " + strength + " -> " + (strength + strengthChange) + " \n" +
                        "DEF: " + defense + " -> " + (defense + defenseChange) + " \n" +
                        "INT: " + intelligence + " -> " + (intelligence + intelligenceChange) + " \n" +
                        "VIT: " + vitality + " -> " + (vitality + vitalityChange) + "\n"
        );

        //Actually add the stats
        strength += strengthChange;
        defense += defenseChange;
        intelligence += intelligenceChange;
        vitality += vitalityChange;
        //Also give you HP based on your HP gain
        hp += vitalityChange;
        Stepper.waiter();
    }


    public void addGold(long gold) {
        this.gold += gold;
        Renderer.printEvent("You obtained " + gold + " gold!");
    }


    public long takeDamage(long damage) {

        long damageToTake = Math.max(1, damage - defense);

        hp -= damageToTake;

        return hp;
    }

    public void shout() {

        int pick = Maths.random_range_int(0, shouts.size() - 1);

        Renderer.shout(shouts.get(pick));
    }



    //Boilerplate code! ------------------------------------------------------------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

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

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public long getXp() {
        return xp;
    }

    public void setXp(long xp) {
        this.xp = xp;
    }

    public void addXp(long xp) {
        this.xp += xp;
        Renderer.printEvent("You gained " + xp + " XP!");
    }

    public long getXpreq() {
        return xpreq;
    }

    public void setXpreq(long xpreq) {
        this.xpreq = xpreq;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public long getHp() {
        return this.hp;
    }

    public void setHp(long hp) {
        this.hp = hp;
    }

    public long getVitality() {
        return this.vitality;
    }

    public void setVitality(long vitality) {
        this.vitality = vitality;
    }

    public long getGold() {
        return this.gold;
    }

    public void setGold(long gold) {
        this.gold = gold;
    }

    @Override
    public String toString() {
        return "=== Character Details ===\n" +
                "Name: " + name + "\n" +
                "Age: " + age + "\n" +
                "Class: " + getClass().getSimpleName() + "\n" +
                "\n" +
                "==== Character Stats ====\n" +
                "Strength: " + strength + " + (" + weapon.getStrength() + ")" + "\n" +
                "Defense: " + defense + " + (" + armor.getDefense() + ") " + "\n" +
                "Intelligence: " + intelligence + " + (" + (weapon.getIntelligence() + armor.getIntelligence()) + ") " + "\n" +
                "\n" +
                "HP: " + hp + " / " + vitality + "\n" +
                "Gold: " + gold + "\n" +
                "XP: " + xp + " / " + xpreq + "\n" +
                "Level: " + level + "\n" +
                "\n" +
                "======= Equipment =======\n" +
                "Weapon: " + weapon.toString() + "\n" +
                "Armor: " + armor.toString();
    }
}

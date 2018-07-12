package com.nodzigames.heroesofgrannard.items;

public class Weapon {

    private long strength;
    private long intelligence;
    private String description;
    private String name;

    public Weapon() {

    }







    public long getStrength() {
        return strength;
    }

    public void setStrength(long strength) {
        this.strength = strength;
    }

    public long getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(long intelligence) {
        this.intelligence = intelligence;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return ("< " + name + " > STR(" + strength + ") INT(" + intelligence + ")\nDescription: " + description + "\n");
    }
}

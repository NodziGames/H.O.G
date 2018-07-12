package com.nodzigames.heroesofgrannard.items;

public class Armor {

    private long defense;
    private long intelligence;
    private String description;
    private String name;

    public Armor() {

    }






    public long getDefense() {
        return defense;
    }

    public void setDefense(long defense) {
        this.defense = defense;
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
        return ("< " + name + " > DEF(" + defense + ") INT(" + intelligence + ")\nDescription: " + description + "\n");
    }
}

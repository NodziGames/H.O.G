package com.nodzigames.heroesofgrannard.scenarios;

import com.nodzigames.heroesofgrannard.enemies.Enemy;
import com.nodzigames.heroesofgrannard.renderer.Renderer;

import java.util.ArrayList;
import java.util.List;

import static com.nodzigames.heroesofgrannard.consts.ActionConsts.*;

public class Scenario {

    //Generic Scenario Class. Details to be filled in on classes that inherit from this.
    private String description;
    private String name;
    public List<String> actions;

    public List<Enemy> enemies;
    //public List<Loot> loot;

    public Scenario() {

        actions = new ArrayList<String>();

        enemies = new ArrayList<Enemy>();

    }

    public void describe() {
        Renderer.print("------------- " + name + "-------------" + "\n\n" + description);
    }

    public void listEnemies() {

        Renderer.print("Enemies: " + enemies.size());

        for (int i = 0; i < enemies.size(); i++) {
            System.out.print("< " + enemies.get(i).getName() + " > ");
        }
        System.out.print("\n\n");
    }

    public void listActions(long moves) {
        Renderer.print("=== Possible Actions ===\n");
        for (String action : actions) {
            switch (action) {
                case A_FIGHT:
                    System.out.print("(F) ");
                    break ;
                case A_EXPLORE:
                    System.out.print("(E) ");
                    break ;
                case A_STATS:
                    System.out.print("(T) ");
                    break ;
                case A_SLEEP:
                    System.out.print("(S) ");
                    break ;
                case A_LOOT:
                    System.out.print("(L) ");
                    break ;
            }
            if (action.equals(A_EXPLORE))
                Renderer.print("< " + action + " >" + " Moves Left: " + moves + " / 10");
            else
                Renderer.print("< " + action + " >");
        }
    }

























    //Boilerplate code! ----------------

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
}

package com.nodzigames.heroesofgrannard.scenarios;

import com.nodzigames.heroesofgrannard.enemies.Birb_1;

import static com.nodzigames.heroesofgrannard.consts.ActionConsts.*;

public class Scene_1_6 extends Scenario {

    public Scene_1_6() {

        setDescription("You find an old abandoned shed. At first it looks empty, nothing more than a cozy looking haystack, but then a giant flock of Birbs appear out of nowhere!");
        setName("Abandoned Shed");

        //Add Enemies
        enemies.add(new Birb_1());
        enemies.add(new Birb_1());
        enemies.add(new Birb_1());
        enemies.add(new Birb_1());


        //Add Loot



        //Add Actions That You Can Take

        actions.add(A_FIGHT);
        actions.add(A_SLEEP);
        actions.add(A_STATS);
        actions.add(A_EXPLORE);
    }
}

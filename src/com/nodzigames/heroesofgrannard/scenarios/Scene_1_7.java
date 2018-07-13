package com.nodzigames.heroesofgrannard.scenarios;

import com.nodzigames.heroesofgrannard.enemies.Skeleton_1;

import static com.nodzigames.heroesofgrannard.consts.ActionConsts.*;

public class Scene_1_7 extends Scenario {

    public Scene_1_7() {

        setDescription("You enter a small cave behind a waterfall. The sound of the water rushing echoes throughout the cave. You spot a treasure chest that's mostly unguarded.");
        setName("Treasure Cave");

        //Add Enemies
        enemies.add(new Skeleton_1());


        //Add Loot



        //Add Actions That You Can Take

        actions.add(A_FIGHT);
        actions.add(A_STATS);
        actions.add(A_LOOT);
        actions.add(A_EXPLORE);
    }

}

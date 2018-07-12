package com.nodzigames.heroesofgrannard.scenarios;

import com.nodzigames.heroesofgrannard.enemies.Skeleton_1;
import com.nodzigames.heroesofgrannard.enemies.Birb_1;

import static com.nodzigames.heroesofgrannard.consts.ActionConsts.A_EXPLORE;
import static com.nodzigames.heroesofgrannard.consts.ActionConsts.A_FIGHT;
import static com.nodzigames.heroesofgrannard.consts.ActionConsts.A_STATS;

public class Scene_1_4 extends Scenario{

    public Scene_1_4() {
        setDescription("You arrive at what appears to be a desert. There's no vegetation, and the wind is dry. You hear the clacking of bones as the skeletons of the former deceased begin to animate.");
        setName("Barren Lands");

        //Add Enemies
        enemies.add(new Skeleton_1());
        enemies.add(new Birb_1());
        enemies.add(new Skeleton_1());


        //Add Loot



        //Add Actions That You Can Take

        actions.add(A_FIGHT);
        actions.add(A_STATS);
        actions.add(A_EXPLORE);
    }
}

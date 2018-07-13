package com.nodzigames.heroesofgrannard.scenarios;

import com.nodzigames.heroesofgrannard.enemies.Badabook_1;
import com.nodzigames.heroesofgrannard.enemies.Birb_1;
import com.nodzigames.heroesofgrannard.enemies.Slime_1;

import static com.nodzigames.heroesofgrannard.consts.ActionConsts.*;

public class Scene_1_8 extends Scenario {

    public Scene_1_8() {

        setDescription("You spot a bridge that's been out of order for years. Beneath it is a group of enemies taking shelter from the scorching heat. Perhaps it's time to interrupt the gathering?");
        setName("Broken Bridge");

        //Add Enemies
        enemies.add(new Slime_1());
        enemies.add(new Birb_1());
        enemies.add(new Badabook_1());
        enemies.add(new Birb_1());


        //Add Loot



        //Add Actions That You Can Take

        actions.add(A_FIGHT);
        actions.add(A_STATS);
        actions.add(A_EXPLORE);
    }
}

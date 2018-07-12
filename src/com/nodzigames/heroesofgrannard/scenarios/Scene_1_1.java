package com.nodzigames.heroesofgrannard.scenarios;

import com.nodzigames.heroesofgrannard.enemies.Slime_1;

import static com.nodzigames.heroesofgrannard.consts.ActionConsts.*;

public class Scene_1_1 extends Scenario {

    public Scene_1_1() {
        setDescription("You see a large field open field ahead of you. It's sparsely covered with trees. The birds sing softly as the breeze carries their humming through the plains. There's not much going on, but you're very tempted to take a nap on the soft, green, grass.");
        setName("Old Plains");

        //Add Enemies
        enemies.add(new Slime_1());


        //Add Loot



        //Add Actions That You Can Take

        actions.add(A_FIGHT);
        actions.add(A_SLEEP);
        actions.add(A_STATS);
        actions.add(A_EXPLORE);

    }
}

package com.nodzigames.heroesofgrannard.scenarios;

import com.nodzigames.heroesofgrannard.enemies.Slime;

import static com.nodzigames.heroesofgrannard.consts.ActionConsts.*;

public class Scene1 extends Scenario {

    public Scene1() {
        setDescription("You see a large field open field ahead of you. It's sparsely covered with trees. The birds sing softly as the breeze carries their humming through the plains. There's not much going on, but you're very tempted to take a nap on the soft, green, grass.");
        setName("Old Plains");

        //Add Enemies
        enemies.add(new Slime());
        enemies.add(new Slime());
        enemies.add(new Slime());
        enemies.add(new Slime());


        //Add Loot



        //Add Actions That You Can Take

        actions.add(A_EXPLORE);
        actions.add(A_SLEEP);
        actions.add(A_STATS);
        if (enemies.size() > 0)
            actions.add(A_FIGHT);
    }
}

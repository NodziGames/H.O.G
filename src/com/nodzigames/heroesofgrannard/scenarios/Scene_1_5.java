package com.nodzigames.heroesofgrannard.scenarios;

import com.nodzigames.heroesofgrannard.enemies.Badabook_1;
import com.nodzigames.heroesofgrannard.enemies.Birb_1;
import com.nodzigames.heroesofgrannard.enemies.Skeleton_1;
import com.nodzigames.heroesofgrannard.enemies.Slime_1;

import static com.nodzigames.heroesofgrannard.consts.ActionConsts.*;

public class Scene_1_5 extends Scenario {

    public Scene_1_5() {

        setDescription("You spot an old hut in the distance. As you approach it, you can hear a thumping sound coming from the inside, getting louder and louder the closer you get. You open the door and loud Russian Bass blasts your ears away. There's a party going on, and you sure as hell wanna be the party pooper!");
        setName("Disco Room");

        //Add Enemies
        enemies.add(new Badabook_1());
        enemies.add(new Slime_1());
        enemies.add(new Skeleton_1());
        enemies.add(new Birb_1());
        enemies.add(new Badabook_1());


        //Add Loot



        //Add Actions That You Can Take

        actions.add(A_FIGHT);
        actions.add(A_STATS);
        actions.add(A_LOOT);
        actions.add(A_EXPLORE);
    }
}

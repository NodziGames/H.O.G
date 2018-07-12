package com.nodzigames.heroesofgrannard.scenarios;

import com.nodzigames.heroesofgrannard.enemies.Badabook;

import static com.nodzigames.heroesofgrannard.consts.ActionConsts.A_EXPLORE;
import static com.nodzigames.heroesofgrannard.consts.ActionConsts.A_FIGHT;
import static com.nodzigames.heroesofgrannard.consts.ActionConsts.A_STATS;

public class Scene3 extends Scenario {

    public Scene3() {

        setDescription("You enter into a daycare center, hoping for a place to rest. All you can see is toys flying through the air, children pulling each other's hair and screaming at the top of their lungs. You spot a few odd looking children, but it turns out they're Badabooks disguised as children!");
        setName("Day Care Center");

        //Add Enemies
        enemies.add(new Badabook());
        enemies.add(new Badabook());


        //Add Loot



        //Add Actions That You Can Take

        actions.add(A_FIGHT);
        actions.add(A_STATS);
        actions.add(A_EXPLORE);
    }
}

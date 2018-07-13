package com.nodzigames.heroesofgrannard.scenarios;

import static com.nodzigames.heroesofgrannard.consts.ActionConsts.*;

public class Scene_1_9 extends Scenario {

    public Scene_1_9() {
        setDescription("You climb a treacherous hill all the way to the top. There's not much to find here except for an 'uninhabited' outpost. The fireplace is still smoldering, but you decide to pretend like you don't see it.");
        setName("Unoccupied Outpost");

        //Add Enemies



        //Add Loot



        //Add Actions That You Can Take

        actions.add(A_STATS);
        actions.add(A_SLEEP);
        actions.add(A_EXPLORE);
    }
}

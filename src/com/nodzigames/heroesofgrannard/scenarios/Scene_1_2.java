package com.nodzigames.heroesofgrannard.scenarios;

import com.nodzigames.heroesofgrannard.enemies.Birb_1;
import com.nodzigames.heroesofgrannard.enemies.Slime_1;

import static com.nodzigames.heroesofgrannard.consts.ActionConsts.*;

public class Scene_1_2 extends Scenario {

    public Scene_1_2() {
        setDescription("You stumble over a hill, and on the other side you're met with the sight of a large lake. The water is crystal clear, and a cool breeze emanates from the waters. 'I could really go for a swim', you think to yourself.");
        setName("Great Lake");

        //Add Enemies
        enemies.add(new Slime_1());
        enemies.add(new Birb_1());


        //Add Loot



        //Add Actions That You Can Take

        actions.add(A_FIGHT);
        actions.add(A_STATS);
        actions.add(A_EXPLORE);
    }
}

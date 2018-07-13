package com.nodzigames.heroesofgrannard.scenarios;

import com.nodzigames.heroesofgrannard.enemies.Troll_1;

import static com.nodzigames.heroesofgrannard.consts.ActionConsts.*;

public class Scene_1_10 extends Scenario {

    public Scene_1_10() {
        setDescription("You find a large valley with a ginormous house. The doorway is twice your height, and you like to think of yourself as reasonably tall. You slowly open the door, and then here a thundering voice speak behind you. It's a Troll, and he's not very happy to see you invade his privacy!");
        setName("Troll's Habitat");

        //Add Enemies
        enemies.add(new Troll_1());


        //Add Loot



        //Add Actions That You Can Take

        actions.add(A_FIGHT);
        actions.add(A_STATS);
        actions.add(A_LOOT);
        actions.add(A_EXPLORE);
    }
}

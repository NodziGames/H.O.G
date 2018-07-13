package com.nodzigames.heroesofgrannard.stepper;
import com.nodzigames.heroesofgrannard.classes.Grunt;
import com.nodzigames.heroesofgrannard.enemies.Enemy;
import com.nodzigames.heroesofgrannard.items.Armor;
import com.nodzigames.heroesofgrannard.items.FlimsyKatana_1;
import com.nodzigames.heroesofgrannard.items.Weapon;
import com.nodzigames.heroesofgrannard.items.Yukata_1;
import com.nodzigames.heroesofgrannard.maths.Maths;
import com.nodzigames.heroesofgrannard.npcs.GenericNpc;
import com.nodzigames.heroesofgrannard.classes.Human;
import com.nodzigames.heroesofgrannard.classes.Player;
import com.nodzigames.heroesofgrannard.classes.Samurai;
import com.nodzigames.heroesofgrannard.renderer.Renderer;
import com.nodzigames.heroesofgrannard.scenarios.Scenario;
import com.nodzigames.heroesofgrannard.scenarios.*;
import com.nodzigames.heroesofgrannard.validation.Parser;

import java.util.Scanner;

import static com.nodzigames.heroesofgrannard.consts.ActionConsts.*;

public class Stepper {

    public String state;
    public static Scanner scanner;
    public Player player;
    public Scenario scene;
    public long moves;

    //After every X Moves, Go Back To Town, Then Up Portal Level
    public int portalLevel;


    //Initialize NPCs
    public GenericNpc hagrid = new GenericNpc("Hagrid");

    public Stepper() {
        state = "menu";
        scanner = new Scanner(System.in);
        portalLevel = 1;
        moves = 10;
    }

    public void step() {

        switch (state) {
            case "menu":
                menu_step();
                break ;
            case "character_creation":
                character_creation_step();
                break ;
            case "main_loop":
                main_loop_step();
                break ;
        }

    }











    //Repeated Functionality
    public static void waiter() {
        String wait = scanner.nextLine();
    }

    public String getInput(String prompt) {
        System.out.print("\n" + prompt + " => ");
        return scanner.nextLine().trim();
    }

    public void changeScene() {

        int pick = Maths.random_range_int(1,5);

        if (portalLevel == 1) {
            switch (pick) {
                case 1:
                    scene = new Scene_1_1();
                    break;
                case 2:
                    scene = new Scene_1_2();
                    break;
                case 3:
                    scene = new Scene_1_3();
                    break;
                case 4:
                    scene = new Scene_1_4();
                    break ;
                case 5:
                    scene = new Scene_1_5();
                    break ;
            }
        }

    }





    //SCENARIOS =========================================================================================================================





    //MENU ============================================================

    public void menu_step() {
        Renderer.menu_draw();
        waiter();
        state = "character_creation";
        Renderer.cls();
    }







    //CHARACTER CREATION =================================================

    public void character_creation_step() {
        Renderer.print("You slowly open your eyes. Everything around you seems hazy, your memory is blurred. 'A Hangover?', you ask yourself. You finally gather enough strength to raise your head. There's a kind looking old man in front of you. You ask him where you are.");
        waiter();
        Renderer.cls();

        hagrid.speak("Hello there traveller! Let me guess, you've woken up and you can't remember anything? Blah-dee-blah-blah, I've heard it many times before...");

        Renderer.print("With a single sentence, the thought of his gentle appearance disappears as quickly as your memory did. He asks for your name, and you reluctantly give it to him:");

        String name = getInput("Name");

        while (!Parser.nameParse(name)) {
            Renderer.cls();
            hagrid.speak("Who has a name like that? Your mother must've been high as a kite when she named you. It must be at least 3 characters, but no longer than 15 either. Try again:");
            name = getInput("Name");
        }

        Renderer.cls();

        hagrid.speak("Well then, hello " + name + "! Tell me, how old are you adventurer?");


        String age_input = getInput("Age");


        while (!Parser.ageParse(age_input)) {
            Renderer.cls();
            hagrid.speak("Sorry, I'm not buying that. Adventurers must be at least 10 years of age, but I don't believe you're above 100 either... Try again:");
            age_input = getInput("Age");
        }

        int age = Integer.parseInt(age_input);

        Renderer.cls();

        hagrid.speak("Good! I can almost take my lunch break... Please select a race. This will affect your stats so choose carefully!\n");

        //Show the player the options
        Renderer.print("Human: Just A Regular Joe With Well Balanced Stats");
        Renderer.print("Samurai: Slightly More Fragile, But Strikes Harder When Shouting Loud Obnoxious Japanese Phrases");
        Renderer.print("Grunt: Strong, Durable, But Not The Brightest Of The Bunch");
        Renderer.print("\n");

        String class_input = getInput("Class");

        while (!Parser.classParse(class_input))
        {
            Renderer.cls();
            hagrid.speak("No no no, that is not a valid race. Please select one from the list below!\n");
            //Show the player the options
            Renderer.print("Human: Just A Regular Joe With Well Balanced Stats");
            Renderer.print("Samurai:  Slightly More Fragile, But Strikes Harder When Shouting Loud Obnoxious Japanese Phrases");
            Renderer.print("Grunt: Strong, Durable, But Not The Brightest Of The Bunch");

            class_input = getInput("Class");
        }

        Renderer.cls();

        Renderer.print("Finally! Please give me a second while I create your character sheet for you...\n");

        //Make a new character
        if (class_input.equalsIgnoreCase("human")) {
            player = new Human(name, age);
        }
        else if (class_input.equalsIgnoreCase("samurai")) {
            player = new Samurai(name, age);
        }
        else if (class_input.equalsIgnoreCase("grunt")) {
            player = new Grunt(name, age);
        }

        waiter();

        Renderer.cls();

        hagrid.speak("And we're done! Here you go: \n");
        Renderer.print(player.toString() + "\n");

        hagrid.speak("When you're done vainly marvelling at your creation, press return to start your adventure!");

        waiter();

        Renderer.cls();

        hagrid.speak("Oh yeah, one more thing before you go... Take this gold to help you get started... I still don't like you, don't get the wrong impression.");

        player.addGold(1000);

        waiter();

        Renderer.cls();

        Renderer.print("You put the money in your pocket, and walk away. You hope to never see Hagrid again...");

        waiter();

        state = "main_loop";

        changeScene();
    }






    //MAIN LOOP ===========================================================

    public void main_loop_step() {

        while (player.getHp() > 0 && moves >= 0) {

            Renderer.cls();

            Renderer.summarizeStats(player);

            scene.describe();

            Renderer.print("\n");

            scene.listEnemies();

            scene.listActions(moves);

            String action = getInput("Action");

            action = Parser.parseAction(scene.actions, action);

            //Manage all the actions here!
            if (action.equals(A_NONE)) {
                Renderer.wrongAction();
            } else if (action.equals(A_EXPLORE)) {
                Renderer.print("\n\nYou leave " + scene.getName() + " and proceed towards the next location...");
                changeScene();
                moves -= 1;
            } else if (action.equals(A_SLEEP)) {
                Renderer.cls();
                Renderer.print("You decide to take a short nap that turns into hours of sleeping. You wake up feeling refreshed!\n");
                player.setHp(player.getVitality());
                Renderer.printEvent("HP Fully Restored!");
                scene.actions.remove(A_SLEEP);
            } else if (action.equals(A_STATS)) {
                Renderer.cls();
                Renderer.print(player.toString());
            } else if (action.equals(A_FIGHT)) {
                Renderer.cls();
                fight(scene.enemies.get(0));
            } else if (action.equals(A_LOOT)) {
                Renderer.cls();
                if (scene.enemies.size() == 0) {
                    loot();
                    scene.actions.remove(A_LOOT);
                }
                else {
                    Renderer.print("You desperately reach for the loot pile, but there are enemies blocking your way!");
                }
            }

            //Level up already has a waiter() inside of it, so don't call waiter if player levelled up!

            if (!player.levelUpCheck()) {
                waiter();
            }
        }

        town();




    }


    public void fight(Enemy enemy) {

        scene.enemies.remove(0);

        Renderer.encounter(enemy);
        Renderer.print("");

        waiter();

        while (enemy.getHp() > 0 && player.getHp() > 0) {

            //Main combat loop here

            //Player attack
            long dmg = player.getStrength() + player.weapon.getStrength();
            Renderer.print("You attack the " + enemy.getName() + " for " + dmg + " potential damage!");
            player.shout();
            Renderer.print("\nThe " + enemy.getName() + " blocks " + enemy.getDefense() + " damage");
            Renderer.print("The " + enemy.getName() + " takes a total of " + Math.max(1, dmg - enemy.getDefense()) + " damage!");
            enemy.takeDamage(dmg);
            Renderer.print("\n" + enemy.getName() + " HP: " + (enemy.getHp() + Math.max(1, dmg - enemy.getDefense())) + " -> " + enemy.getHp());
            Renderer.print("\n\n");

            waiter();

            if (enemy.getHp() <= 0) {
                //Enemy die etc
                Renderer.cls();
                Renderer.print("Victory is yours! The " + enemy.getName() + " crumbles before you...\n");
                player.addGold(enemy.getGold());
                player.addXp(enemy.getXp());
            }
            else {
                //Attack the player back
                long dmg2 = enemy.getStrength() + Maths.random_range_int(-enemy.getStrength() / 10, enemy.getStrength() / 10);
                Renderer.print("The " + enemy.getName() + " attacks you for " + dmg2 + " potential damage!");
                enemy.shout();
                Renderer.print("\nYou block for " + (player.getDefense() + player.armor.getDefense()) + " damage");
                Renderer.print("You take a total of " + Math.max(1, dmg2 - (player.getDefense() + player.armor.getDefense())) + " damage!");
                player.takeDamage(dmg2);
                Renderer.print("\nYour HP: " + (player.getHp() + Math.max(1, dmg2 - player.getDefense())) + " -> " + player.getHp());
                Renderer.print("\n\n");

                waiter();
            }
        }

        if (player.getHp() <= 0) {
            state = "menu";
            Renderer.cls();
            Renderer.gameOver(player);
        }

        if (scene.enemies.size() == 0) {
            scene.actions.remove(A_FIGHT);
        }
    }

    public void town() {
        Renderer.cls();
        Renderer.drawPortal();
        moves = 10;
        //Increase portalLevel here too!
        waiter();
    }

    public void loot() {
        Renderer.printEvent("You Rummage Through The Loot Pile\n");

        if (portalLevel == 1) {
            int pick = Maths.random_range_int(1, 2);

            switch(pick) {
                case 1:
                    equipWeapon(new FlimsyKatana_1());
                    break ;
                case 2:
                    equipArmor(new Yukata_1());
                    break ;
            }

        }
    }

    public void equipWeapon(Weapon weapon) {
        Renderer.print("You found a " + weapon.getName() + "!");
        Renderer.print("\nCurrent Weapon: " + player.weapon.toString());
        Renderer.print("\nNew Weapon: " + weapon.toString());

        String e_input = getInput("Equip? (Y/N)");

        while (!Parser.parseEquip(e_input)) {
            Renderer.print("That's not an option! Yes (Y) or No (N)?");
            e_input = getInput("Equip? (Y/N)");
        }

        if (e_input.toLowerCase().equals("y") || e_input.toLowerCase().equals("yes")) {
            player.weapon = weapon;
            Renderer.print("");
            Renderer.printEvent("You equip the " + weapon.getName() + "!");

        }
        else if (e_input.toLowerCase().equals("n") || e_input.toLowerCase().equals("no")) {
            Renderer.print("");
            Renderer.printEvent("You leave behind the " + weapon.getName() + "...");
        }
    }

    public void equipArmor(Armor armor) {
        Renderer.print("You found a " + armor.getName() + "!");
        Renderer.print("\nCurrent Armor: " + player.armor.toString());
        Renderer.print("\nNew Armor: " + armor.toString());

        String e_input = getInput("Equip? (Y/N)");

        while (!Parser.parseEquip(e_input)) {
            Renderer.print("That's not an option! Yes (Y) or No (N)?");
            e_input = getInput("Equip? (Y/N)");
        }

        if (e_input.toLowerCase().equals("y") || e_input.toLowerCase().equals("yes")) {
            player.armor = armor;
            Renderer.print("");
            Renderer.printEvent("You equip the " + armor.getName() + "!");

        }
        else if (e_input.toLowerCase().equals("n") || e_input.toLowerCase().equals("no")) {
            Renderer.print("");
            Renderer.printEvent("You leave behind the " + armor.getName() + "...");
        }
    }
}

package com.nodzigames.heroesofgrannard.stepper;
import com.nodzigames.heroesofgrannard.enemies.Enemy;
import com.nodzigames.heroesofgrannard.maths.Maths;
import com.nodzigames.heroesofgrannard.npcs.GenericNpc;
import com.nodzigames.heroesofgrannard.races.Human;
import com.nodzigames.heroesofgrannard.races.Player;
import com.nodzigames.heroesofgrannard.renderer.Renderer;
import com.nodzigames.heroesofgrannard.scenarios.Scenario;
import com.nodzigames.heroesofgrannard.scenarios.Scene1;
import com.nodzigames.heroesofgrannard.validation.Parser;

import java.util.Scanner;

import static com.nodzigames.heroesofgrannard.consts.ActionConsts.*;

public class Stepper {

    public String state;
    public static Scanner scanner;
    public Player player;
    public Scenario scene;


    //Initialize NPCs
    public GenericNpc hagrid = new GenericNpc("Hagrid");

    public Stepper() {
        state = "menu";
        scanner = new Scanner(System.in);
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
        Renderer.print("Human: Well Balanced All Around Fighter");
        Renderer.print("Mock1: Does things");
        Renderer.print("Mock2: Does things");
        Renderer.print("Mock3: Does things");
        Renderer.print("\n");

        String class_input = getInput("Race");

        while (!Parser.classParse(class_input))
        {
            Renderer.cls();
            hagrid.speak("No no no, that is not a valid race. Please select one from the list below!\n");
            //Show the player the options
            Renderer.print("Human: Well Balanced All Around Fighter");
            Renderer.print("Mock1: Does things");
            Renderer.print("Mock2: Does things");
            Renderer.print("Mock3: Does things");

            class_input = getInput("Race");
        }

        Renderer.cls();

        Renderer.print("Finally! Please give me a second while I create your character sheet for you...\n");

        //Make a new character
        if (class_input.equalsIgnoreCase("human")) {
            player = new Human(name, age);
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

        scene = new Scene1();
    }






    //MAIN LOOP ===========================================================

    public void main_loop_step() {

        while (true) {

            Renderer.cls();

            Renderer.summarizeStats(player);

            scene.describe();

            Renderer.print("\n");

            scene.listEnemies();

            scene.listActions();

            String action = getInput("Action");

            action = Parser.parseAction(scene.actions, action);

            //Manage all the actions here!
            if (action.equals(A_NONE)) {
                Renderer.wrongAction();
            }
            else if (action.equals(A_EXPLORE)) {
                Renderer.print("\nResult:\n\nYou leave " + scene.getName() + " and proceed towards the next location...");
            }
            else if (action.equals(A_SLEEP)) {
                Renderer.cls();
                Renderer.print("\nResult:\n\nYou decide to take a short nap that turns into hours of sleeping. You wake up feeling refreshed!\n");
                player.setHp(player.getVitality());
                Renderer.printEvent("HP Fully Restored!");
                scene.actions.remove(A_SLEEP);
            }
            else if (action.equals(A_STATS)) {
                Renderer.cls();
                Renderer.print(player.toString());
            }
            else if (action.equals(A_FIGHT)) {
                Renderer.cls();
                fight(scene.enemies.get(0));
            }

            //Level up already has a waiter() inside of it, so don't call waiter if player levelled up!

            if (!player.levelUpCheck()) {
                waiter();
            }

        }
    }


    public void fight(Enemy enemy) {

        scene.enemies.remove(0);

        Renderer.encounter(enemy);
        Renderer.print("");

        waiter();

        while (enemy.getHp() > 0 && player.getHp() > 0) {

            //Main combat loop here

            //Player attack
            long dmg = player.getStrength() + Maths.random_range_int(-20, 20);
            Renderer.print("You attack the " + enemy.getName() + " for " + dmg + " potential damage!");
            Renderer.print("The " + enemy.getName() + " blocks " + enemy.getDefense() + " damage");
            Renderer.print("The " + enemy.getName() + " takes a total of " + Math.max(1, dmg - enemy.getDefense()) + " damage!");
            player.shout();
            enemy.takeDamage(dmg);
            Renderer.print("\n" + enemy.getName() + " HP: " + (enemy.getHp() + Math.max(1, dmg - enemy.getDefense())) + " -> " + enemy.getHp());
            Renderer.print("\n");

            waiter();

            if (enemy.getHp() <= 0) {
                //Enemy die etc
                Renderer.cls();
                Renderer.print("You win!");
                player.addGold(enemy.getGold());
                player.addXp(enemy.getXp());
            }
            else {
                //Attack the player back
                long dmg2 = enemy.getStrength() + Maths.random_range_int(-20, 20);
                Renderer.print("The " + enemy.getName() + " attacks you for " + dmg2 + " potential damage!");
                Renderer.print("You block for " + player.getDefense() + " damage");
                Renderer.print("You take a total of " + Math.max(1, dmg2 - player.getDefense()) + " damage!");
                enemy.shout();
                player.takeDamage(dmg2);
                Renderer.print("\nYour HP: " + (player.getHp() + Math.max(1, dmg2 - player.getDefense())) + " -> " + player.getHp());
                Renderer.print("\n");

                waiter();
            }
        }

        if (scene.enemies.size() == 0) {
            scene.actions.remove(A_FIGHT);
        }
    }
}

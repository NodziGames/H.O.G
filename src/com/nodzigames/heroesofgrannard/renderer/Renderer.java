package com.nodzigames.heroesofgrannard.renderer;

import com.nodzigames.heroesofgrannard.enemies.Enemy;
import com.nodzigames.heroesofgrannard.maths.Maths;
import com.nodzigames.heroesofgrannard.classes.Player;

public class Renderer {

    public Renderer() {

    }


    public static void print(String str) {
        System.out.println(str);
    }

    public static void cls() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void printEvent(String str) {
        for (int i = 0; i < str.length() + 4; i++) {
            System.out.print('=');
        }
        Renderer.print("");
        System.out.print("| " + str + " |\n");
        for (int i = 0; i < str.length() + 4; i++) {
            System.out.print('=');
        }
        Renderer.print("");
    }

    public static void shout(String str) {
        Renderer.print("\n!!! " + str + " !!!");
    }

    public static void summarizeStats(Player player) {
        print("======================================================================");
        print("HP: " + player.getHp() + " / " + player.getVitality() + "");
        print("LEVEL: " + player.getLevel() + "  |  XP: " + player.getXp() + " / " + player.getXpreq());
        print("GOLD: " + player.getGold());
        print("======================================================================");
        print("");
    }

    public static void wrongAction() {
        int pick = Maths.random_range_int(0, 4);
        String dialogue = new String();

        switch (pick) {
            case 0:
                dialogue = "You don't know what this action is, because it's not on the list.";
                break ;
            case 1:
                dialogue = "You think to yourself that you like the determination you have, but it's pointless to try and perform a non-existant action";
                break ;
            case 2:
                dialogue = "You shake your head, knowing that it's not possible...";
                break ;
            case 3:
                dialogue = "No matter how many times you try, you simply can't perform this action";
                break ;
            case 4:
                dialogue = "That may have been cool to do, but it's not possible here";
                break ;
        }

        print("\n\n" + dialogue);
    }

    public static void encounter(Enemy enemy) {

        int pick = Maths.random_range_int(0, 4);

        switch (pick) {
            case 0:
                print("Suddenly, a random " + enemy.getName() + " appears!");
                break ;
            case 1:
                print("You run face first into a " + enemy.getName() + "... He looks angry!");
                break ;
            case 2:
                print("You try and intimidate a " + enemy.getName() + ". He ain't having any");
                break ;
            case 3:
                print("You encounter a " + enemy.getName() + ". Prepare to fight!");
                break ;
            case 4:
                print("You step on a " + enemy.getName() + "'s toe by accident. There's no way out!");
                break ;
        }
    }

    public static void gameOver(Player player) {
        print("************************************************************************");
        print("Unable to withstand any more blows, you faint and pass on to eternity...\n");
        print("                            ,--.\n" +
                "                           {    }\n" +
                "                           K,   }\n" +
                "                          /  ~Y`\n" +
                "                     ,   /   /\n" +
                "                    {_'-K.__/\n" +
                "                      `/-.__L._\n" +
                "                      /  ' /`\\_}\n" +
                "                     /  ' /\n" +
                "             ____   /  ' /\n" +
                "      ,-'~~~~    ~~/  ' /_\n" +
                "    ,'             ``~~~  ',\n" +
                "   (                        Y\n" +
                "  {                         I\n" +
                " {      -                    `,\n" +
                " |       ',                   )\n" +
                " |        |   ,..__      __. Y\n" +
                " |    .,_./  Y ' / ^Y   J   )|\n" +
                " \\           |' /   |   |   ||\n" +
                "  \\          L_/    . _ (_,.'(\n" +
                "   \\,   ,      ^^\"\"' / |      )\n" +
                "     \\_  \\          /,L]     /\n" +
                "       '-_~-,       ` `   ./`\n" +
                "          `'{_            )\n" +
                "              ^^\\..___,.--`");
        print("\n\n                R.I.P\n");
        print("************************************************************************");
        print("\nHere Lies " + player.getName() + ", an Honorable Level " + player.getLevel() + " " + player.getClass().getSimpleName() + ".");
        print("\nYou left behind a fortune of " + player.getGold() + " Gold, and asked that it be buried with you so that you can spend it in the afterlife.");
        print("\n\nGAME OVER...");
    }




    public static void menu_draw() {
        cls();

        print("-*-*-*-*-*-*-*- HEROES OF GRANNARD -*-*-*-*-*-*-*-");
        print("|                                                |");
        print("|                @NodziGames 2018                |");
        print("|                                                |");
        print("__________________________________________________");
        print("|                                                |");
        print("|                                                |");
        print("|              Press Return To Start...          |");
        print("\\________________________________________________/");
    }
}
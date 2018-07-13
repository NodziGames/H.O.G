package com.nodzigames.heroesofgrannard.validation;

import java.util.List;

import static com.nodzigames.heroesofgrannard.consts.ActionConsts.*;

public class Parser {

    public static boolean nameParse(String name) {
        //Insert Proper Parse-ing here
        if (name.length() < 3 || name.length() > 15)
            return false;
        return true;
    }

    public static boolean ageParse(String age) {
        //Parse Age here.
        int agenum;
        try {
            agenum = Integer.parseInt(age);
        } catch(Exception e) {
            return false;
        }
        if (agenum < 10 || agenum > 100)
            return false;
        else
            return true;
    }

    public static boolean classParse(String class_input) {

        class_input = class_input.toLowerCase();
        if (!class_input.equals("human") && !class_input.equals("samurai") && !(class_input.equals("grunt"))) {
            return false;
        }
        else
            return true;
    }

    public static String parseAction(List<String> actions, String action) {
        action = action.toLowerCase();

        //Parse Shorter Inputs
        if (action.equals("f"))
            action = A_FIGHT;

        if (action.equals("e"))
            action = A_EXPLORE;

        if (action.equals("t"))
            action = A_STATS;

        if (action.equals("s"))
            action = A_SLEEP;

        if (action.equals("l"))
            action = A_LOOT;

        if (actions.contains(action))
            return(action);
        else
            return(A_NONE);
    }

    public static boolean parseEquip(String input) {
        input = input.toLowerCase();

        if (input.equals("yes") || input.equals("y") || input.equals("no") || input.equals("n")) {
            return true;
        }
        else {
            return false;
        }
    }
}

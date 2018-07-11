package com.nodzigames.heroesofgrannard.validation;

import java.util.List;

import static com.nodzigames.heroesofgrannard.consts.ActionConsts.A_NONE;

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
        if (!class_input.contains("human") && !class_input.contains("samurai")) {
            return false;
        }
        else
            return true;
    }

    public static String parseAction(List<String> actions, String action) {
        action = action.toLowerCase();

        if (actions.contains(action))
            return(action);
        else
            return(A_NONE);
    }
}

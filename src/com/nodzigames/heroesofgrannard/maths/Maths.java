package com.nodzigames.heroesofgrannard.maths;

public class Maths {

    public static int random_range_int(int min, int max) {

        int result;

        result = (int) Math.round(Math.random() * (max - min));

        result += min;

        return result;
    }
}

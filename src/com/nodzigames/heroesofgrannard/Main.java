package com.nodzigames.heroesofgrannard;

import com.nodzigames.heroesofgrannard.maths.Maths;
import com.nodzigames.heroesofgrannard.renderer.Renderer;
import com.nodzigames.heroesofgrannard.stepper.Stepper;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        Renderer.cls();

        System.out.println("Welcome to Heroes of Grannard!\n");

        //Game Logic Controller
        Stepper stepper = new Stepper();

        while (true) {
            stepper.step(); //Call main step event. The renderer is called from here too!
        }
    }
}

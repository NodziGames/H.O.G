package com.nodzigames.heroesofgrannard.npcs;

import com.nodzigames.heroesofgrannard.renderer.Renderer;

public class GenericNpc {

    private String name;

    //Constructors

    public GenericNpc(String name) {
        this.name = name;
    }





    //Functionality
    public void speak(String str) {
        Renderer.print(name + ": " + str + "\n");
    }









    //Boilerplate Code
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

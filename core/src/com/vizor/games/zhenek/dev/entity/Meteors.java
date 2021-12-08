package com.vizor.games.zhenek.dev.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;
import java.util.List;

public class Meteors {
    private static List<Sprite> meteors = new ArrayList<>();

    private Meteors(){}


    public void addMeteor(Sprite meteor){}

    public static List<Sprite> getMeteors() {
        return meteors;
    }
}

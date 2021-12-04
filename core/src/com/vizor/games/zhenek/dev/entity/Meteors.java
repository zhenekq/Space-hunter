package com.vizor.games.zhenek.dev.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;
import java.util.List;

public class Meteors {
    private static List<Sprite> meteors = new ArrayList<>(20);

    private Meteors(){}

    static {
        for (int i = 1; i <= 20; i++) {
            meteors.add(new Sprite(new Texture("meteors/meteor" + i + ".png")));
        }
    }

    public static List<Sprite> getMeteors() {
        return meteors;
    }
}

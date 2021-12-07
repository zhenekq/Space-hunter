package com.vizor.games.zhenek.dev.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.vizor.games.zhenek.dev.util.GameTexturePath;

import java.util.ArrayList;
import java.util.List;

public class Bullets {
    private static List<Sprite> bullets = new ArrayList<>();

    private Bullets() {
    }


    public static List<Sprite> getBullets() {
        return bullets;
    }

}

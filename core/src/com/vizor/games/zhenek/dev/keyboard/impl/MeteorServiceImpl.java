package com.vizor.games.zhenek.dev.keyboard.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.vizor.games.zhenek.dev.keyboard.MeteorService;
import com.vizor.games.zhenek.dev.util.GameValues;

import java.util.Random;

public class MeteorServiceImpl implements MeteorService {

    @Override
    public void createMeteor(Sprite sprite) {
        Random random = new Random();
        float randomMeteorPositionX = GameValues.ZERO_VALUE + random.nextFloat() * (GameValues.ZERO_VALUE + Gdx.graphics.getWidth());
        float randomMeteorPositionY = GameValues.ZERO_VALUE + random.nextFloat() * (GameValues.ZERO_VALUE + Gdx.graphics.getHeight());
        sprite.setPosition(randomMeteorPositionX, randomMeteorPositionY);
    }

    @Override
    public void destroyMeteor(Sprite sprite, float x, float y) {

    }
}

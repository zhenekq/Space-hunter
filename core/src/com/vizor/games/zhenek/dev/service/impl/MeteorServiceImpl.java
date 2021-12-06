package com.vizor.games.zhenek.dev.service.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.vizor.games.zhenek.dev.SpaceHunter;
import com.vizor.games.zhenek.dev.service.MeteorService;
import com.vizor.games.zhenek.dev.util.GameUtils;
import com.vizor.games.zhenek.dev.util.GameValues;

import java.util.List;
import java.util.Random;

import static com.badlogic.gdx.math.MathUtils.random;

public class MeteorServiceImpl implements MeteorService {

    @Override
    public void createMeteor(List<Sprite> meteors, SpaceHunter game, int index) {
        game.batch.draw(meteors.get(index), random(0, Gdx.graphics.getWidth()), random(0, Gdx.graphics.getHeight()));
        meteors.get(index).setPosition(random(GameValues.ZERO_VALUE, Gdx.graphics.getWidth()), random(Gdx.graphics.getHeight() / 2, Gdx.graphics.getHeight()));
        meteors.get(index).setRotation(random(-90, 90));
    }

    @Override
    public int drawMeteors(List<Sprite> meteors, Sprite shipSprite, SpaceHunter game, int index) {
        for (int i = 0; i < index; i++) {
            Sprite meteor = meteors.get(i);
            GameUtils.calculatePosition(meteor, meteor.getX(), meteor.getY());
            meteor.translate(-1, -1);
            Rectangle shipRectangle = GameUtils.getNormalBoundingRectangle(shipSprite, GameValues.SHIP_RECTANGLE_BORDER);
            Rectangle meteorRectangle = GameUtils.getNormalBoundingRectangle(meteor, GameValues.SHIP_RECTANGLE_BORDER);
            if (shipRectangle.overlaps(meteorRectangle)) {
                index = 0;
                shipSprite.setPosition(GameValues.ZERO_VALUE, GameValues.ZERO_VALUE);
                GameUtils.playLoseMusic();
                break;
            }
            meteor.draw(game.batch);
        }
        return index;
    }

    @Override
    public void destroyMeteor(Sprite sprite, float x, float y) {

    }
}

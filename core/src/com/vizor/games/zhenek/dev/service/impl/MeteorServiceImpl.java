package com.vizor.games.zhenek.dev.service.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.vizor.games.zhenek.dev.SpaceHunter;
import com.vizor.games.zhenek.dev.screen.PlayScreen;
import com.vizor.games.zhenek.dev.service.MeteorService;
import com.vizor.games.zhenek.dev.util.GameUtils;
import com.vizor.games.zhenek.dev.util.GameValues;

import java.util.ArrayList;
import java.util.List;

import static com.badlogic.gdx.math.MathUtils.random;

public class MeteorServiceImpl implements MeteorService {

    @Override
    public void createMeteor(List<Sprite> meteors, SpaceHunter game, int index) {
        meteors.add(new Sprite(new Texture("meteors/meteor" + random(1, 20) + ".png")));
        game.batch.draw(meteors.get(index), random(0, Gdx.graphics.getWidth()), random(0, Gdx.graphics.getHeight()));
        meteors.get(index).setPosition(random(GameValues.ZERO_VALUE, Gdx.graphics.getWidth()), random(Gdx.graphics.getHeight() / 2, Gdx.graphics.getHeight()));
        meteors.get(index).setRotation(random(-90, 90));
    }

    @Override
    public int drawMeteors(List<Sprite> meteors, Sprite shipSprite, SpaceHunter game, int index, PlayScreen screen) {
        for (int i = 0; i < index; i++) {
            Sprite meteor = meteors.get(i);
            GameUtils.calculatePosition(meteor, meteor.getX(), meteor.getY());
            meteor.translate(-1, -1);
            Rectangle shipRectangle = GameUtils.getNormalBoundingRectangle(shipSprite, GameValues.SHIP_RECTANGLE_BORDER);
            Rectangle meteorRectangle = GameUtils.getNormalBoundingRectangle(meteor, GameValues.SHIP_RECTANGLE_BORDER);
            if (shipRectangle.overlaps(meteorRectangle)) {
                index = GameUtils.checkLoseGame(index, shipSprite);
                screen.reset();
                break;
            }
            meteor.draw(game.batch);
        }
        return index;
    }

    @Override
    public List<Integer> destroyMeteor(List<Sprite> bullets,List<Integer> removedMeteorsList, List<Sprite> meteors, List<float[]> positions, int index, int removedMeteors) {
        removedMeteorsList.set(0, index);
        for (int i = 0; i < bullets.size(); i++) {
            Sprite bullet = bullets.get(i);
            float[] position = positions.get(i);
            Rectangle bulletRectangle = GameUtils.getNormalBoundingRectangle(bullet, GameValues.BULLET_RECTANGLE_BORDER);
            for (int j = 0; j < meteors.size(); j++) {
                Sprite meteor = meteors.get(j);
                Rectangle meteorRectangle = GameUtils.getNormalBoundingRectangle(meteor, GameValues.SHIP_RECTANGLE_BORDER);
                if (bulletRectangle.overlaps(meteorRectangle)) {
                    bullets.remove(bullet);
                    meteors.remove(meteor);
                    positions.remove(position);
                    index--;
                    removedMeteors = removedMeteorsList.get(1);
                    removedMeteorsList.set(0, index);
                    removedMeteorsList.set(1,++removedMeteors);
                }
            }
        }
        return removedMeteorsList;
    }
}

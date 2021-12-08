package com.vizor.games.zhenek.dev.service.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.vizor.games.zhenek.dev.SpaceHunter;
import com.vizor.games.zhenek.dev.entity.SpaceShip;
import com.vizor.games.zhenek.dev.screen.PlayScreen;
import com.vizor.games.zhenek.dev.service.MeteorService;
import com.vizor.games.zhenek.dev.util.GameTexturePath;
import com.vizor.games.zhenek.dev.util.GameUtil;
import com.vizor.games.zhenek.dev.util.GameValue;

import java.util.List;

import static com.badlogic.gdx.math.MathUtils.random;

public class MeteorServiceImpl implements MeteorService {

    @Override
    public void createMeteor(List<Sprite> meteors, SpaceHunter game, int index) {
        meteors.add(new Sprite(new Texture("meteors/meteor" + random(1, 20) + ".png")));
        Sprite meteor = meteors.get(index);

        meteor.setPosition(random(GameValue.ZERO_VALUE, Gdx.graphics.getWidth()), random(Gdx.graphics.getHeight() / 2, Gdx.graphics.getHeight()));
    }

    @Override
    public int drawMeteors(List<Sprite> meteors, List<Float> meteorTranslates, Sprite shieldSprite, SpaceShip shipSprite, SpaceHunter game, int index, PlayScreen screen) {
        for (int i = 0; i < index; i++) {
            Sprite meteor = meteors.get(i);
            Float meteorTranslate = meteorTranslates.get(i);
            GameUtil.calculatePosition(meteor, meteor.getX(), meteor.getY());
            meteor.translate(meteorTranslate, -1);
            Sound sound = null;
            Rectangle shipRectangle = GameUtil.getNormalBoundingRectangle(shipSprite, GameValue.SHIP_RECTANGLE_BORDER);
            Rectangle meteorRectangle = GameUtil.getNormalBoundingRectangle(meteor, GameValue.SHIP_RECTANGLE_BORDER);
            if (shipRectangle.overlaps(meteorRectangle)) {
                sound = Gdx.audio.newSound(new FileHandle(GameTexturePath.LOSE_SHIELD_SOUND));
                int shield = shipSprite.getShieldAmount();
                shipSprite.setShieldAmount(--shield);
                index--;
                meteors.remove(meteor);
                meteorTranslates.remove(meteorTranslate);
                sound.play();
                if (shipSprite.getShieldAmount() == -1) {
                    sound.dispose();
                    index = GameUtil.checkLoseGame(index, shipSprite);
                    screen.reset();
                    break;
                }
            }
            meteor.draw(game.batch);
        }
        return index;
    }

    @Override
    public List<Integer> destroyMeteor(List<Sprite> bullets, List<Float> translateMeteors, List<Integer> removedMeteorsList, List<Sprite> meteors, List<float[]> positions, int index, int removedMeteors) {
        removedMeteorsList.set(0, index);
        Sound sound = null;
        for (int i = 0; i < bullets.size(); i++) {
            Sprite bullet = bullets.get(i);
            float[] position = positions.get(i);
            Rectangle bulletRectangle = GameUtil.getNormalBoundingRectangle(bullet, GameValue.BULLET_RECTANGLE_BORDER);
            for (int j = 0; j < meteors.size(); j++) {
                Sprite meteor = meteors.get(j);
                Rectangle meteorRectangle = GameUtil.getNormalBoundingRectangle(meteor, GameValue.SHIP_RECTANGLE_BORDER);
                if (bulletRectangle.overlaps(meteorRectangle)) {
                    sound = Gdx.audio.newSound(new FileHandle(GameTexturePath.DESTROY_METEOR_SOUND));
                    bullets.remove(bullet);
                    meteors.remove(meteor);
                    positions.remove(position);
                    translateMeteors.remove(i);
                    index--;
                    removedMeteors = removedMeteorsList.get(1);
                    removedMeteorsList.set(0, index);
                    removedMeteorsList.set(1, ++removedMeteors);
                    sound.play();
                }
            }
        }
        return removedMeteorsList;
    }
}

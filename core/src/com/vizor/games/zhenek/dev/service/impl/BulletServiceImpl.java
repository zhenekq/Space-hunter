package com.vizor.games.zhenek.dev.service.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.vizor.games.zhenek.dev.SpaceHunter;
import com.vizor.games.zhenek.dev.service.BulletService;
import com.vizor.games.zhenek.dev.util.GameTexturePath;

import java.util.List;

public class BulletServiceImpl implements BulletService {
    @Override
    public float[] createBullet(List<Sprite> bullets, Sprite shipSprite, SpaceHunter game) {
        final float[] mousePosition = new float[4];
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        Music music = null;
        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            mousePosition[0] = shipSprite.getX();
            mousePosition[1] = shipSprite.getY();
            mousePosition[2] = Gdx.input.getX();
            mousePosition[3] = screenHeight - Gdx.input.getY();
            Sprite bullet = new Sprite(new Texture(GameTexturePath.SHOUT_SHIP_SPRITE));
            bullet.setPosition(shipSprite.getX(), shipSprite.getY());
            bullet.setRotation(shipSprite.getRotation());
            bullets.add(bullet);
        }
        return mousePosition;
    }

    @Override
    public int shotBullet(List<Sprite> bullets, List<float[]> positions, Sprite shipSprite, SpaceHunter game, int destroyedMeteors) {
        for (int i = 0; i < bullets.size(); i++) {
            Sprite bullet = bullets.get(i);
            float[] position = positions.get(i);
            applyMovement(bullet, game, position, shipSprite);
            bullet.draw(game.batch);
            if(bullet.getX() > Gdx.graphics.getWidth() || bullet.getY() > Gdx.graphics.getHeight()){
                bullets.remove(bullet);
                positions.remove(position);
                destroyedMeteors++;
            }
        }
        return destroyedMeteors;
    }


    @Override
    public void applyMovement(Sprite bullet, SpaceHunter game,final float[] positions, Sprite shipSprite) {
        double theta = Math.atan2(-(positions[1] - positions[3]), -(positions[0] - positions[2]));
        float delta = 10;
        float valX = (float) ((delta) * Math.cos(theta));
        float valY = (float) ((delta) * Math.sin(theta));
        bullet.setPosition(bullet.getX() + valX, bullet.getY() + valY);
    }
}

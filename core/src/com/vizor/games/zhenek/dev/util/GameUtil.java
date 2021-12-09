package com.vizor.games.zhenek.dev.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.vizor.games.zhenek.dev.service.game.KeyPressed;
import com.vizor.games.zhenek.dev.util.value.GameTexturePath;
import com.vizor.games.zhenek.dev.util.value.GameValue;

import java.io.File;
import java.util.Random;

import static com.badlogic.gdx.Gdx.input;

public class GameUtil {

    private GameUtil() {
    }

    public static void checkButtons(KeyPressed keyPressed, Sprite sprite) {
        //WASD
        keyPressed.isPressedKeyX(sprite, Input.Keys.D, GameValue.RIGHT_SPEED);
        keyPressed.isPressedKeyX(sprite, Input.Keys.A, GameValue.LEFT_SPEED);
        keyPressed.isPressedKeyY(sprite, Input.Keys.W, GameValue.UP_SPEED);
        keyPressed.isPressedKeyY(sprite, Input.Keys.S, GameValue.DOWN_SPEED);

        //ARROWS
        keyPressed.isPressedKeyX(sprite, Input.Keys.RIGHT, GameValue.RIGHT_SPEED);
        keyPressed.isPressedKeyX(sprite, Input.Keys.LEFT, GameValue.LEFT_SPEED);
        keyPressed.isPressedKeyY(sprite, Input.Keys.UP, GameValue.UP_SPEED);
        keyPressed.isPressedKeyY(sprite, Input.Keys.DOWN, GameValue.DOWN_SPEED);

    }

    public static void calculatePosition(Sprite sprite, float x, float y) {
        float maxX = Gdx.graphics.getWidth() - sprite.getWidth();
        float maxY = Gdx.graphics.getHeight() - sprite.getHeight();

        if (sprite.getX() > maxX + GameValue.WALL_DELAY) {
            sprite.setPosition(GameValue.ZERO_VALUE - sprite.getWidth(), sprite.getY());
        } else if (sprite.getX() < GameValue.ZERO_VALUE - GameValue.WALL_DELAY) {
            sprite.setPosition(Gdx.graphics.getWidth(), sprite.getY());
        } else if (sprite.getY() > maxY + GameValue.WALL_DELAY) {
            sprite.setPosition(sprite.getX(), GameValue.ZERO_VALUE - sprite.getHeight());
        } else if (sprite.getY() < GameValue.ZERO_VALUE - GameValue.WALL_DELAY) {
            sprite.setPosition(sprite.getX(), Gdx.graphics.getHeight());
        }
    }

    public static void calculateRotate(Sprite sprite) {
        Vector2 spriteVector = new Vector2();
        spriteVector.x = sprite.getX();
        spriteVector.y = sprite.getY();
        Vector2 resultVector = new Vector2();
        resultVector.x = spriteVector.x - input.getX();
        resultVector.y = spriteVector.y - (Gdx.graphics.getHeight() - input.getY());
        float deg = (float) (180 / Math.PI * Math.atan2(resultVector.y, resultVector.x));
        sprite.setRotation(deg + 90);
    }

    public static void playLoseMusic() {
        File file = new File(GameTexturePath.LOSE_SOUND);
        Music music = Gdx.audio.newMusic(new FileHandle(file));
        music.play();
    }

    public static Rectangle getNormalBoundingRectangle(Sprite sprite, float multiplier) {
        Rectangle rectangle = sprite.getBoundingRectangle();
        rectangle.setWidth(sprite.getWidth() * multiplier);
        rectangle.setHeight(sprite.getHeight() * multiplier);
        return rectangle;
    }

    public static int checkLoseGame(int index, Sprite shipSprite) {
        shipSprite.setPosition(GameValue.ZERO_VALUE, GameValue.ZERO_VALUE);
        GameUtil.playLoseMusic();
        return index = 0;
    }

    public static float getRandomPositiveOrNegativeValue() {
        Random random = new Random();
        float randomFloatValue = (float) (-1 + Math.random() * (1 + 1f));
        return randomFloatValue;
    }


}

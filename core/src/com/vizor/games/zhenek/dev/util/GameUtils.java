package com.vizor.games.zhenek.dev.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector2;
import com.vizor.games.zhenek.dev.SpaceHunter;
import com.vizor.games.zhenek.dev.entity.Meteors;
import com.vizor.games.zhenek.dev.keyboard.KeyPressed;

public class GameUtils {

    private GameUtils() {
    }

    public static void checkButtons(KeyPressed keyPressed, Sprite sprite) {
        //WASD
        keyPressed.isPressedKeyX(sprite, Input.Keys.D, GameValues.RIGHT_SPEED);
        keyPressed.isPressedKeyX(sprite, Input.Keys.A, GameValues.LEFT_SPEED);
        keyPressed.isPressedKeyY(sprite, Input.Keys.W, GameValues.UP_SPEED);
        keyPressed.isPressedKeyY(sprite, Input.Keys.S, GameValues.DOWN_SPEED);

        //ARROWS
        keyPressed.isPressedKeyX(sprite, Input.Keys.RIGHT, GameValues.RIGHT_SPEED);
        keyPressed.isPressedKeyX(sprite, Input.Keys.LEFT, GameValues.LEFT_SPEED);
        keyPressed.isPressedKeyY(sprite, Input.Keys.UP, GameValues.UP_SPEED);
        keyPressed.isPressedKeyY(sprite, Input.Keys.DOWN, GameValues.DOWN_SPEED);

    }

    public static void calculatePosition(Sprite sprite, float x, float y) {
        float maxX = Gdx.graphics.getWidth() - sprite.getWidth();
        float maxY = Gdx.graphics.getHeight() - sprite.getHeight();

        if (sprite.getX() > maxX + GameValues.WALL_DELAY) {
            sprite.setPosition(GameValues.ZERO_VALUE - sprite.getWidth(), sprite.getY());
        } else if (sprite.getX() < GameValues.ZERO_VALUE - GameValues.WALL_DELAY) {
            sprite.setPosition(Gdx.graphics.getWidth(), sprite.getY());
        } else if (sprite.getY() > maxY + GameValues.WALL_DELAY) {
            sprite.setPosition(sprite.getX(), GameValues.ZERO_VALUE - sprite.getHeight());
        } else if (sprite.getY() < GameValues.ZERO_VALUE - GameValues.WALL_DELAY) {
            sprite.setPosition(sprite.getX(), Gdx.graphics.getHeight());
        }
    }

    public static void calculateRotate(Sprite sprite){
        Vector2 spriteVector = new Vector2();
        spriteVector.x = sprite.getX();
        spriteVector.y = sprite.getY();
        Vector2 resultVector = new Vector2();
        resultVector.x = Gdx.input.getX() - spriteVector.x;
        resultVector.y = Gdx.input.getY() - spriteVector.y;
        float deg = (float) (180 / Math.PI * Math.atan2(resultVector.y, resultVector.x));
        sprite.setRotation(-deg);
    }

    public static void checkMainLogic(SpaceHunter game, Sprite shipSprite, int index){

    }

}

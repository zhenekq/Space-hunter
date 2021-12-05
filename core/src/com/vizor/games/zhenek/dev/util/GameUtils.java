package com.vizor.games.zhenek.dev.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.vizor.games.zhenek.dev.keyboard.KeyPressed;

import java.io.File;

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

    public static void calculateRotate(Sprite sprite) {
        Vector2 spriteVector = new Vector2();
        spriteVector.x = sprite.getX();
        spriteVector.y = sprite.getY();
        Vector2 resultVector = new Vector2();
        resultVector.x = spriteVector.x - Gdx.input.getX();
        resultVector.y = spriteVector.y - (Gdx.graphics.getHeight() - Gdx.input.getY());
        float deg = (float) (180 / Math.PI * Math.atan2(resultVector.y, resultVector.x));
        sprite.setRotation(deg+90);
        /*ShapeRenderer shapeRenderer = new ShapeRenderer();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(1, 1, 0, 1);
        System.out.println("MOUSE: "+Gdx.input.getX() + "," + Gdx.input.getY());
        System.out.println("OBJECT: "+sprite.getX() + "," + sprite.getY());
        shapeRenderer.line(spriteVector.x, spriteVector.y, Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
        shapeRenderer.end();*/

    }

    public static void playLoseMusic() {
        File file = new File("core/assets/sounds/lose_sound.ogg");
        Music music = Gdx.audio.newMusic(new FileHandle(file));
        music.play();
    }

}

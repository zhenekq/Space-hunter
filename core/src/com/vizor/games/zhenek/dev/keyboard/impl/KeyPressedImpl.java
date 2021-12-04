package com.vizor.games.zhenek.dev.keyboard.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.vizor.games.zhenek.dev.keyboard.KeyPressed;

public class KeyPressedImpl implements KeyPressed {
    @Override
    public void isPressedKeyX(Sprite sprite, int key, float translate) {
        if(Gdx.input.isKeyPressed(key)){
            sprite.translateX(translate);
        }
    }

    @Override
    public void isPressedKeyY(Sprite sprite, int key, float translate) {
        if(Gdx.input.isKeyPressed(key)){
            sprite.translateY(translate);
        }
    }
}

package com.vizor.games.zhenek.dev.keyboard;

import com.badlogic.gdx.graphics.g2d.Sprite;

public interface KeyPressed {

    void isPressedKeyX(Sprite sprite, int key, float translate);
    void isPressedKeyY(Sprite sprite, int key, float translate);

}

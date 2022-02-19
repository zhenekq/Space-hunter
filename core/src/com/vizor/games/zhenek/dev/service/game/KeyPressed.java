package com.vizor.games.zhenek.dev.service.game;

import com.badlogic.gdx.graphics.g2d.Sprite;

public interface KeyPressed {

    void isPressedKeyX(Sprite sprite, int key, float translate);
    void isPressedKeyY(Sprite sprite, int key, float translate);

}

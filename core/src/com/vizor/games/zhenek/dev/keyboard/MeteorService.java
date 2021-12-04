package com.vizor.games.zhenek.dev.keyboard;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public interface MeteorService {

    void createMeteor(Sprite sprite);
    void destroyMeteor(Sprite sprite, float x, float y);

}

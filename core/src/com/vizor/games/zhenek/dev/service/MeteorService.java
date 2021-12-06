package com.vizor.games.zhenek.dev.service;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.vizor.games.zhenek.dev.SpaceHunter;

import java.util.List;

public interface MeteorService {

    void createMeteor(List<Sprite> meteors, SpaceHunter game, int index);
    int drawMeteors(List<Sprite> meteors, Sprite shipSprite, SpaceHunter game, int index);
    void destroyMeteor(Sprite sprite, float x, float y);

}

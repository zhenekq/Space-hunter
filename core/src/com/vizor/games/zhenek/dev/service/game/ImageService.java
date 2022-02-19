package com.vizor.games.zhenek.dev.service.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.vizor.games.zhenek.dev.SpaceHunter;

@FunctionalInterface
public interface ImageService {
    void placeImage(SpaceHunter spaceHunter, Sprite sprite, float x, float y);
}

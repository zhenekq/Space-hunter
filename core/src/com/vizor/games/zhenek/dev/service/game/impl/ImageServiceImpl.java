package com.vizor.games.zhenek.dev.service.game.impl;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.vizor.games.zhenek.dev.SpaceHunter;
import com.vizor.games.zhenek.dev.service.game.ImageService;

public class ImageServiceImpl implements ImageService {
    @Override
    public void placeImage(SpaceHunter spaceHunter, Sprite sprite, float x, float y) {
        spaceHunter.batch.draw(sprite, x, y);
    }
}

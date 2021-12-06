package com.vizor.games.zhenek.dev.service.impl;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.vizor.games.zhenek.dev.service.KeyPressed;
import com.vizor.games.zhenek.dev.service.ShipService;
import com.vizor.games.zhenek.dev.util.GameUtils;

public class ShipServiceImpl implements ShipService {

    @Override
    public void checkPositionRotateAndButtons(Sprite sprite, KeyPressed keyPressed) {
        GameUtils.calculatePosition(sprite, sprite.getX(), sprite.getY());
        GameUtils.calculateRotate(sprite);
        GameUtils.checkButtons(keyPressed, sprite);
    }
}

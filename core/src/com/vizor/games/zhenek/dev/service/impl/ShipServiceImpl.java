package com.vizor.games.zhenek.dev.service.impl;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.vizor.games.zhenek.dev.service.KeyPressed;
import com.vizor.games.zhenek.dev.service.ShipService;
import com.vizor.games.zhenek.dev.util.GameUtil;

public class ShipServiceImpl implements ShipService {

    @Override
    public void checkPositionRotateAndButtons(Sprite sprite, KeyPressed keyPressed) {
        GameUtil.calculatePosition(sprite, sprite.getX(), sprite.getY());
        GameUtil.calculateRotate(sprite);
        GameUtil.checkButtons(keyPressed, sprite);
    }


}

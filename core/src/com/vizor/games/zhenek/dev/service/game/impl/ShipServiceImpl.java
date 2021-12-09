package com.vizor.games.zhenek.dev.service.game.impl;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.vizor.games.zhenek.dev.service.game.KeyPressed;
import com.vizor.games.zhenek.dev.service.game.ShipService;
import com.vizor.games.zhenek.dev.util.GameUtil;

public class ShipServiceImpl implements ShipService {

    @Override
    public void checkPositionRotateAndButtons(Sprite sprite, KeyPressed keyPressed) {
        GameUtil.calculatePosition(sprite, sprite.getX(), sprite.getY());
        GameUtil.calculateRotate(sprite);
        GameUtil.checkButtons(keyPressed, sprite);
    }


}

package com.vizor.games.zhenek.dev.service.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.vizor.games.zhenek.dev.SpaceHunter;
import com.vizor.games.zhenek.dev.service.FontService;
import com.vizor.games.zhenek.dev.util.GameLabels;
import com.vizor.games.zhenek.dev.util.GameValues;

public class FontServiceImpl implements FontService {
    @Override
    public void printScore(BitmapFont bitmapFont, SpaceHunter game, int score) {
        bitmapFont.setColor(1f, 2f, 0f, 3f);
        bitmapFont.getData().setScale(2);
        bitmapFont.draw(game.batch,
                GameLabels.SCORE + score,
                GameValues.DEFAULT_VALUE_SHIFT,
                Gdx.graphics.getHeight() - GameValues.ANOTHER_SHIFT);
    }
}

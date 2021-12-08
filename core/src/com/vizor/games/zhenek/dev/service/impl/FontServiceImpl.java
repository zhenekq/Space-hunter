package com.vizor.games.zhenek.dev.service.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.vizor.games.zhenek.dev.SpaceHunter;
import com.vizor.games.zhenek.dev.entity.SpaceShip;
import com.vizor.games.zhenek.dev.service.FontService;
import com.vizor.games.zhenek.dev.util.GameColor;
import com.vizor.games.zhenek.dev.util.GameLabel;
import com.vizor.games.zhenek.dev.util.GameTexturePath;
import com.vizor.games.zhenek.dev.util.GameValue;

public class FontServiceImpl implements FontService {
    @Override
    public void printScore(BitmapFont bitmapFont, SpaceHunter game, int score) {
        bitmapFont.setColor(GameColor.SCORE_LABEL_COLOR);
        bitmapFont.getData().setScale(GameValue.FONT_MULTIPLIER_SIZE);
        bitmapFont.draw(game.batch,
                GameLabel.SCORE + score,
                GameValue.DEFAULT_VALUE_SHIFT,
                Gdx.graphics.getHeight() - GameValue.ANOTHER_SHIFT);
    }

    @Override
    public void printShieldStatus(SpaceShip ship, BitmapFont font, SpaceHunter game, Sprite shield) {
        Sound sound = Gdx.audio.newSound(new FileHandle(GameTexturePath.LOSE_SHIELD_SOUND));
        font.setColor(GameColor.SHIELD_STATUS_COLOR);
        font.getData().setScale(GameValue.SHIELD_FONT_MULTIPLIER);
        if(ship.getShieldAmount() == GameValue.SHIELD_AMOUNT - 1){
            shield.set(new Sprite(new Texture(GameTexturePath.SILVER_SHIELD)));
        }
        if(ship.getShieldAmount() == GameValue.ZERO_VALUE){
            shield.set(new Sprite(new Texture(GameTexturePath.BRONZE_SHIELD)));
        }
        font.draw(game.batch, GameLabel.SHIELD_STATUS, GameValue.ANOTHER_SHIFT,Gdx.graphics.getHeight() - GameValue.DEFAULT_VALUE_SHIFT * 1.6f);
    }
}

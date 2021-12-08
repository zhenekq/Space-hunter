package com.vizor.games.zhenek.dev.service;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.vizor.games.zhenek.dev.SpaceHunter;
import com.vizor.games.zhenek.dev.entity.SpaceShip;

public interface FontService {
    void printScore(BitmapFont bitmapFont, SpaceHunter game, int score);
    void printShieldStatus(SpaceShip ship, BitmapFont font, SpaceHunter game, Sprite shield);
}

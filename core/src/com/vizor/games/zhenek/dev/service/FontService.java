package com.vizor.games.zhenek.dev.service;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.vizor.games.zhenek.dev.SpaceHunter;

public interface FontService {
    void printScore(BitmapFont bitmapFont, SpaceHunter game, int score);
}

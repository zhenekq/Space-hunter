package com.vizor.games.zhenek.dev.service;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.vizor.games.zhenek.dev.SpaceHunter;
import com.vizor.games.zhenek.dev.screen.PlayScreen;

import java.util.List;

public interface MeteorService {

    void createMeteor(List<Sprite> meteors, SpaceHunter game, int index);
    int drawMeteors(List<Sprite> meteors, Sprite shipSprite, SpaceHunter game, int index, PlayScreen screen);
    List<Integer> destroyMeteor(List<Sprite> bullets, List<Integer> removedMeteorsList, List<Sprite> meteors, List<float[]> positions, int index, int removedMeteors);

}

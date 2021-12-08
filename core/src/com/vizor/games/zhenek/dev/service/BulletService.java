package com.vizor.games.zhenek.dev.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.vizor.games.zhenek.dev.SpaceHunter;
import com.vizor.games.zhenek.dev.entity.Bullets;
import com.vizor.games.zhenek.dev.util.GameTexturePath;

import java.io.File;
import java.util.List;

public interface BulletService {
    float[] createBullet(List<Sprite> bullets, Sprite shipSprite,SpaceHunter game);
    int shotBullet(List<Sprite> bullets, List<float[]> positions, Sprite shipSprite, SpaceHunter game, int destroyedMeteors);
    void applyMovement(Sprite bullet, SpaceHunter game, float[] positions, Sprite shipSprite);
    default Music playSound(String path){
        File file = new File(path);
        Music music = Gdx.audio.newMusic(new FileHandle(file));
        return music;
    }
}

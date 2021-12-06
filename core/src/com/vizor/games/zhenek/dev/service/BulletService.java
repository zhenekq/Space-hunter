package com.vizor.games.zhenek.dev.service;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.vizor.games.zhenek.dev.entity.Bullets;

public interface BulletService {
    void createBullet(Bullets bullets, Sprite sprite);
    void shotBullet(Bullets bullets);
}

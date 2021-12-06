package com.vizor.games.zhenek.dev.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;
import java.util.List;

public class Bullets {
    private List<Sprite> bullets = new ArrayList<>();

    public Bullets(){}

    public void addBullet(Sprite bullet){
        bullets.add(bullet);
    }

    public void removeBullet(Sprite bullet){
        bullets.remove(bullet);
    }

    public List<Sprite> getBullets() {
        return bullets;
    }

    public void setBullets(List<Sprite> bullets) {
        this.bullets = bullets;
    }
}

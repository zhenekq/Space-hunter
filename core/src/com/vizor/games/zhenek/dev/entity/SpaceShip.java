package com.vizor.games.zhenek.dev.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.vizor.games.zhenek.dev.util.GameTexturePath;

public class SpaceShip extends Sprite {

    private int shieldAmount = 2;
    private Sprite shoutSprite;

    public SpaceShip() {
        shoutSprite = new Sprite(new Texture(GameTexturePath.SHOUT_SHIP_SPRITE));
    }

    public Sprite getShoutSprite() {
        return shoutSprite;
    }

    public void setShoutSprite(Sprite shoutSprite) {
        this.shoutSprite = shoutSprite;
    }

    public int getShieldAmount() {
        return shieldAmount;
    }

    public void setShieldAmount(int shieldAmount) {
        this.shieldAmount = shieldAmount;
    }

    public SpaceShip(Texture texture) {
        super(texture);
    }

    @Override
    public void setX(float x) {
        super.setX(x - getWidth() / 2);
    }

    @Override
    public void setY(float y) {
        super.setY(y - getHeight() / 2);
    }

    @Override
    public void setPosition(float x, float y) {
        super.setPosition(x - getWidth() / 2, y - getHeight() / 2);
    }

    @Override
    public float getX() {
        return super.getX() + getWidth() / 2;
    }

    @Override
    public float getY() {
        return super.getY() + getHeight() / 2;
    }
}
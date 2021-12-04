package com.vizor.games.zhenek.dev;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.vizor.games.zhenek.dev.screen.PlayScreen;

public class SpaceHunter extends Game {
    public SpriteBatch batch;
    Texture img;

    @Override
    public void create() {
        batch = new SpriteBatch();
        setScreen(new PlayScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }


    @Override
    public void pause() {
        super.pause();
    }

    /*@Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }*/
}

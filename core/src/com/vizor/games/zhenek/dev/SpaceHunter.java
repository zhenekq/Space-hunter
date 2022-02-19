package com.vizor.games.zhenek.dev;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.vizor.games.zhenek.dev.screen.MenuScreen;
import com.vizor.games.zhenek.dev.screen.PlayScreen;

public class SpaceHunter extends Game {
    public SpriteBatch batch;
    public PlayScreen gameScreen;
    public MenuScreen menuScreen;
    Texture img;

    @Override
    public void create() {
        batch = new SpriteBatch();
        gameScreen = new PlayScreen(this);
        menuScreen = new MenuScreen(this);
        setScreen(menuScreen);
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

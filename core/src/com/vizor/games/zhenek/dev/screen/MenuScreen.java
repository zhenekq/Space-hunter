package com.vizor.games.zhenek.dev.screen;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.vizor.games.zhenek.dev.SpaceHunter;
import com.vizor.games.zhenek.dev.util.GifDecoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class MenuScreen implements Screen {

    public SpaceHunter menuScreen;
    private Animation<TextureRegion> animationBackground;
    private Sprite backgroundSprite;
    float elapsed;


    public MenuScreen(SpaceHunter menuScreen) {
        this.menuScreen = menuScreen;
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File("core/assets/menu/bgGif.gif"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        animationBackground = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, inputStream);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        elapsed += Gdx.graphics.getDeltaTime();
        menuScreen.batch.begin();
        menuScreen.batch.draw(animationBackground.getKeyFrame(elapsed), 0,0);
        menuScreen.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}

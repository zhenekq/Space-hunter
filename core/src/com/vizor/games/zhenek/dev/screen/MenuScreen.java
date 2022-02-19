package com.vizor.games.zhenek.dev.screen;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.vizor.games.zhenek.dev.SpaceHunter;
import com.vizor.games.zhenek.dev.service.menu.MenuFactory;
import com.vizor.games.zhenek.dev.service.menu.MenuService;
import com.vizor.games.zhenek.dev.util.GifDecoder;
import com.vizor.games.zhenek.dev.util.MenuUtil;
import com.vizor.games.zhenek.dev.util.value.menu.MenuTexturePath;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MenuScreen implements Screen {

    private MenuService menuService = MenuFactory.getInstance().getMenuService();

    private Stage stage;
    public SpaceHunter menuScreen;
    private Animation<TextureRegion> animationBackground;
    private List<ImageTextButton> menuButtons;
    private Sprite gameLogo;
    float elapsed;
    private Music mainMenuSound;

    public MenuScreen(SpaceHunter menuScreen) {
        this.menuScreen = menuScreen;
        this.stage = new Stage(new ScreenViewport());
        menuButtons = new ArrayList<>();
        gameLogo = new Sprite(new Texture("logo.png"));
        gameLogo.setPosition(Gdx.graphics.getWidth() / 2f - 190, Gdx.graphics.getHeight() -160 );
        mainMenuSound = Gdx.audio.newMusic(new FileHandle("core/assets/sounds/main_menu_sound.mp3"));
        onCreate();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        elapsed += Gdx.graphics.getDeltaTime();
        menuScreen.batch.begin();
        //mainMenuSound.play();
        menuScreen.batch.draw(animationBackground.getKeyFrame(elapsed), 0, 0);
        gameLogo.draw(menuScreen.batch);
        if(menuButtons.get(0).isChecked()){
            System.out.println("SDFSDF");
        }
        menuScreen.batch.end();
        stage.act();
        stage.draw();

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

    private void onCreate() {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File(MenuTexturePath.BACKGROUND_GIF));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        animationBackground = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, inputStream);
        menuService.fillMenuButtons(menuButtons);
        menuService.buttonAction(menuButtons);
        MenuUtil.fillStage(menuButtons, stage);
    }
}

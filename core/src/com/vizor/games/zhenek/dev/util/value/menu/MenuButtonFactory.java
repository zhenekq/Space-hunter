package com.vizor.games.zhenek.dev.util.value.menu;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class MenuButtonFactory {
    private static MenuButtonFactory instance = new MenuButtonFactory();

    private final Skin skin = new Skin(new FileHandle(MenuTexturePath.SKIN_TEXTURE));

    public static MenuButtonFactory getInstance() {
        if (instance == null) {
            instance = new MenuButtonFactory();
        }
        return instance;
    }

    private ImageTextButton startButton = new ImageTextButton(MenuLabel.START_GAME, skin);
    private ImageTextButton optionsButton = new ImageTextButton(MenuLabel.OPTIONS, skin);
    private ImageTextButton quitButton = new ImageTextButton(MenuLabel.QUIT, skin);
    private ImageTextButton authorButton = new ImageTextButton(MenuLabel.AUTHOR, skin);

    public ImageTextButton getStartButton() {
        return startButton;
    }

    public ImageTextButton getOptionsButton() {
        return optionsButton;
    }

    public ImageTextButton getQuitButton() {
        return quitButton;
    }

    public ImageTextButton getAuthorButton() {
        return authorButton;
    }
}

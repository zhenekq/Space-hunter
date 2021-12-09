package com.vizor.games.zhenek.dev.service.menu.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.vizor.games.zhenek.dev.service.menu.MenuService;
import com.vizor.games.zhenek.dev.util.MenuUtil;
import com.vizor.games.zhenek.dev.util.value.menu.MenuButtonFactory;
import com.vizor.games.zhenek.dev.util.value.menu.MenuValue;

import java.util.ArrayList;
import java.util.List;

public class MenuServiceImpl implements MenuService {
    @Override
    public void fillMenuButtons(List<ImageTextButton> menuButtons) {
        ImageTextButton startButton = MenuButtonFactory.getInstance().getStartButton();
        ImageTextButton optionsButton = MenuButtonFactory.getInstance().getOptionsButton();
        ImageTextButton quitButton = MenuButtonFactory.getInstance().getQuitButton();
        ImageTextButton authorButton = MenuButtonFactory.getInstance().getAuthorButton();

        startButton.setSize(MenuValue.DEFAULT_BUTTON_WIDTH,MenuValue.DEFAULT_BUTTON_HEIGHT);
        startButton.setPosition(Gdx.graphics.getWidth() / 2f  - 145,280);

        optionsButton.setSize(MenuValue.DEFAULT_BUTTON_WIDTH,MenuValue.DEFAULT_BUTTON_HEIGHT);
        optionsButton.setPosition(Gdx.graphics.getWidth() / 2f  - 145,210);

        authorButton.setSize(MenuValue.DEFAULT_BUTTON_WIDTH,MenuValue.DEFAULT_BUTTON_HEIGHT);
        authorButton.setPosition(Gdx.graphics.getWidth() / 2f  - 145,140);

        quitButton.setSize(MenuValue.DEFAULT_BUTTON_WIDTH,MenuValue.DEFAULT_BUTTON_HEIGHT);
        quitButton.setPosition(Gdx.graphics.getWidth() / 2f  - 145,70);

        menuButtons.add(startButton);
        menuButtons.add(optionsButton);
        menuButtons.add(authorButton);
        menuButtons.add(quitButton);
    }

    @Override
    public void buttonAction(List<ImageTextButton> menuButtons) {
        ImageTextButton startGame = menuButtons.get(0);
        ImageTextButton options = menuButtons.get(1);
        ImageTextButton author = menuButtons.get(2);
        ImageTextButton quit = menuButtons.get(3);
        menuButtons.get(0).addListener(new InputListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("ANINSDF");
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("CLICKED");
                return true;
            }
        });
    }
}

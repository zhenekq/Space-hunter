package com.vizor.games.zhenek.dev.service.menu;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import java.util.List;

public interface MenuService {
    void fillMenuButtons(List<ImageTextButton> menuButtons);
    void buttonAction(List<ImageTextButton> menuButtons);
}

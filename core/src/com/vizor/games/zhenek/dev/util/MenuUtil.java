package com.vizor.games.zhenek.dev.util;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;

import java.util.ArrayList;
import java.util.List;

public class MenuUtil {
    private MenuUtil(){}

    public static void fillStage(List<ImageTextButton> buttons, Stage stage){
        for(Button button: buttons){
            stage.addActor(button);
        }
    }

    public static void fillImageTextButtonList(List<ImageTextButton> list, ImageTextButton... buttons){
        list = new ArrayList<>();
        for(ImageTextButton imageTextButton: buttons){
            list.add(imageTextButton);
        }
    }
}

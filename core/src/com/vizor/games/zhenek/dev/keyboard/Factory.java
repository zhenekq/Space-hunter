package com.vizor.games.zhenek.dev.keyboard;

import com.vizor.games.zhenek.dev.keyboard.impl.KeyPressedImpl;
import com.vizor.games.zhenek.dev.keyboard.impl.MeteorServiceImpl;

public class Factory {

    private static Factory instance = new Factory();


    private KeyPressed keyPressed = new KeyPressedImpl();
    private MeteorService meteorService = new MeteorServiceImpl();

    public KeyPressed getKeyPressed() {
        return keyPressed;
    }

    public static Factory getInstance() {
        if(instance == null){
            instance = new Factory();
        }
        return instance;
    }

    public MeteorService getMeteorService() {
        return meteorService;
    }
}

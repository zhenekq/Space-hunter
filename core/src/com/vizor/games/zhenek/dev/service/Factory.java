package com.vizor.games.zhenek.dev.service;

import com.vizor.games.zhenek.dev.service.impl.KeyPressedImpl;
import com.vizor.games.zhenek.dev.service.impl.MeteorServiceImpl;
import com.vizor.games.zhenek.dev.service.impl.ShipServiceImpl;

public class Factory {

    private static Factory instance = new Factory();


    private KeyPressed keyPressed = new KeyPressedImpl();
    private MeteorService meteorService = new MeteorServiceImpl();
    private ShipService shipService = new ShipServiceImpl();

    public KeyPressed getKeyPressed() {
        return keyPressed;
    }

    public static Factory getInstance() {
        if(instance == null){
            instance = new Factory();
        }
        return instance;
    }

    public ShipService getShipService() {
        return shipService;
    }

    public MeteorService getMeteorService() {
        return meteorService;
    }
}

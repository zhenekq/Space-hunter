package com.vizor.games.zhenek.dev.service;

import com.vizor.games.zhenek.dev.service.impl.BulletServiceImpl;
import com.vizor.games.zhenek.dev.service.impl.KeyPressedImpl;
import com.vizor.games.zhenek.dev.service.impl.MeteorServiceImpl;
import com.vizor.games.zhenek.dev.service.impl.ShipServiceImpl;

public class Factory {

    private static Factory instance = new Factory();

    public static Factory getInstance() {
        if(instance == null){
            instance = new Factory();
        }
        return instance;
    }

    private KeyPressed keyPressed = new KeyPressedImpl();
    private MeteorService meteorService = new MeteorServiceImpl();
    private ShipService shipService = new ShipServiceImpl();
    private BulletService bulletService = new BulletServiceImpl();

    public KeyPressed getKeyPressed() {
        return keyPressed;
    }

    public ShipService getShipService() {
        return shipService;
    }

    public MeteorService getMeteorService() {
        return meteorService;
    }

    public BulletService getBulletService() {
        return bulletService;
    }
}

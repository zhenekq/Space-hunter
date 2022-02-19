package com.vizor.games.zhenek.dev.service.game;

import com.vizor.games.zhenek.dev.service.game.impl.*;

public class GameFactory {

    private static GameFactory instance = new GameFactory();

    public static GameFactory getInstance() {
        if(instance == null){
            instance = new GameFactory();
        }
        return instance;
    }

    private KeyPressed keyPressed = new KeyPressedImpl();
    private MeteorService meteorService = new MeteorServiceImpl();
    private ShipService shipService = new ShipServiceImpl();
    private BulletService bulletService = new BulletServiceImpl();
    private FontService fontService = new FontServiceImpl();
    private ImageService imageService = new ImageServiceImpl();

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

    public ImageService getImageService() {
        return imageService;
    }

    public FontService getFontService() {
        return fontService;
    }
}

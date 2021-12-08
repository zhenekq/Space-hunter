package com.vizor.games.zhenek.dev.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.vizor.games.zhenek.dev.SpaceHunter;
import com.vizor.games.zhenek.dev.entity.Bullets;
import com.vizor.games.zhenek.dev.entity.Meteors;
import com.vizor.games.zhenek.dev.entity.SpaceShip;
import com.vizor.games.zhenek.dev.service.*;
import com.vizor.games.zhenek.dev.util.GameCondition;
import com.vizor.games.zhenek.dev.util.GameTexturePath;
import com.vizor.games.zhenek.dev.util.GameValues;

import java.util.ArrayList;
import java.util.List;

public class PlayScreen implements Screen {

    private KeyPressed keyPressed = Factory.getInstance().getKeyPressed();
    private MeteorService meteorService = Factory.getInstance().getMeteorService();
    private ShipService shipService = Factory.getInstance().getShipService();
    private BulletService bulletService = Factory.getInstance().getBulletService();
    private FontService fontService = Factory.getInstance().getFontService();
    private ImageService imageService = Factory.getInstance().getImageService();

    private List<float[]> positions = new ArrayList<>();
    private GameCondition gameCondition = GameCondition.RUN;
    private List<Sprite> meteors = Meteors.getMeteors();
    private static List<Integer> removedMeteors = new ArrayList<>();
    private static int destroyedMeteors = 0;

    private SpaceHunter game;
    private List<Sprite> bullets = Bullets.getBullets();
    Texture shipTexture;
    SpaceShip shipSprite;
    BitmapFont font;
    Texture backgroundImage;
    Sprite backgroundSprite;
    Sprite bullet;
    Sprite scoreSprite;

    public PlayScreen(SpaceHunter game) {
        this.game = game;
        shipTexture = new Texture(GameTexturePath.SHIP_TEXTURE);
        shipSprite = new SpaceShip(shipTexture);
        backgroundImage = new Texture(GameTexturePath.BACKGROUND_TEXTURE);
        backgroundSprite = new Sprite(backgroundImage);
        bullet = new Sprite(new Texture(GameTexturePath.SHOUT_SHIP_SPRITE));
        font = new BitmapFont();
        scoreSprite = new Sprite(new Texture(GameTexturePath.SCORE_SPRITE));
        removedMeteors.add(0, index);
        removedMeteors.add(1, destroyedMeteors);
    }


    @Override
    public void show() {

    }

    private float timeSeconds = 0f;
    private float period = 1f;
    private static int index = 0;

    public void reset() {
        positions = new ArrayList<>();
        bullets = new ArrayList<>();
        removedMeteors.set(1,0);
    }

    @Override
    public void render(float delta) {
        switch (gameCondition) {
            case RUN:
                draw();
                break;
            case PAUSE:
                timeSeconds = 0f;
                period = 3f;
                index = 0;
                draw();
                break;
        }
    }

    private void draw() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(backgroundSprite, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        shipService.checkPositionRotateAndButtons(shipSprite, keyPressed);
        timeSeconds += Gdx.graphics.getDeltaTime();
        if (timeSeconds > period) {
            timeSeconds -= period;
            meteorService.createMeteor(meteors, game, index);
            index++;
            if (index == GameValues.AMOUNT_OF_METEORS_TYPES) {
                index = GameValues.AMOUNT_OF_METEORS_TYPES - 1;
            }
        }
        index = meteorService.drawMeteors(meteors, shipSprite, game, index, this);
        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            positions.add(bulletService.createBullet(bullets, shipSprite, game));
        }
        bulletService.shotBullet(bullets, positions, shipSprite, game, destroyedMeteors);
        index = meteorService.destroyMeteor(bullets, removedMeteors, meteors, positions, index, destroyedMeteors).get(0);
        removedMeteors = meteorService.destroyMeteor(bullets, removedMeteors, meteors, positions, index, destroyedMeteors);
        fontService.printScore(font, game, removedMeteors.get(1));
        imageService.placeImage(game, scoreSprite, GameValues.ZERO_VALUE, Gdx.graphics.getHeight() - GameValues.DEFAULT_VALUE_SHIFT);
        shipSprite.draw(game.batch);
        game.batch.end();
    }


    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {
        this.gameCondition = GameCondition.PAUSE;
    }

    @Override
    public void resume() {
        this.gameCondition = GameCondition.RUN;
    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}

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
import com.vizor.games.zhenek.dev.service.game.*;
import com.vizor.games.zhenek.dev.util.value.game.GameTexturePath;
import com.vizor.games.zhenek.dev.util.GameUtil;
import com.vizor.games.zhenek.dev.util.value.game.GameValue;

import java.util.ArrayList;
import java.util.List;

public class PlayScreen implements Screen {

    private SpaceHunter game;

    private KeyPressed keyPressed = GameFactory.getInstance().getKeyPressed();
    private MeteorService meteorService = GameFactory.getInstance().getMeteorService();
    private ShipService shipService = GameFactory.getInstance().getShipService();
    private BulletService bulletService = GameFactory.getInstance().getBulletService();
    private FontService fontService = GameFactory.getInstance().getFontService();
    private ImageService imageService = GameFactory.getInstance().getImageService();

    private List<float[]> positions = new ArrayList<>();
    private List<Sprite> meteors = Meteors.getMeteors();
    private static List<Integer> removedMeteors = new ArrayList<>();
    private List<Sprite> bullets = Bullets.getBullets();
    private static List<Float> meteorsTranslate = new ArrayList<>();

    private SpaceShip shipSprite;
    private Sprite backgroundSprite;
    private Sprite shieldSprite;
    private Sprite scoreSprite;

    private BitmapFont score = new BitmapFont();
    private BitmapFont shieldText = new BitmapFont();

    private static int destroyedMeteors = 0;
    private float timeSeconds = GameValue.ZERO_VALUE;
    private float period = GameValue.DEFAULT_PERIOD_TIMER;
    private static int index = GameValue.ZERO_VALUE;

    public PlayScreen(SpaceHunter game) {
        this.game = game;
        shipSprite = new SpaceShip(new Texture(GameTexturePath.SHIP_TEXTURE));
        backgroundSprite = new Sprite(new Texture(GameTexturePath.BACKGROUND_TEXTURE));
        scoreSprite = new Sprite(new Texture(GameTexturePath.SCORE_SPRITE));
        shieldSprite = new Sprite(new Texture(GameTexturePath.GOLD_SHIELD));
        removedMeteors.add(GameValue.ZERO_VALUE, index);
        removedMeteors.add(GameValue.SCORE_INDEX, destroyedMeteors);
        shipSprite.setPosition(Gdx.graphics.getWidth() / 2f, GameValue.ZERO_VALUE + shipSprite.getHeight());
    }


    @Override
    public void show() {

    }

    public void reset() {
        shipSprite.setPosition(Gdx.graphics.getWidth() / 2f, GameValue.ZERO_VALUE + shipSprite.getHeight());
        positions = new ArrayList<>();
        bullets = new ArrayList<>();
        removedMeteors.set(GameValue.SCORE_INDEX, GameValue.ZERO_VALUE);
        shieldSprite = new Sprite(new Texture(GameTexturePath.GOLD_SHIELD));
        shipSprite.setShieldAmount(GameValue.SHIELD_AMOUNT);
    }

    @Override
    public void render(float delta) {
        draw();
    }

    private void draw() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(backgroundSprite, GameValue.ZERO_VALUE, GameValue.ZERO_VALUE, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        shipService.checkPositionRotateAndButtons(shipSprite, keyPressed);
        timeSeconds += Gdx.graphics.getDeltaTime();
        if (timeSeconds > period) {
            timeSeconds -= period;
            meteorsTranslate.add(GameUtil.getRandomPositiveOrNegativeValue());
            meteorService.createMeteor(meteors, game, index);
            index++;
            if (index == GameValue.AMOUNT_OF_METEORS_TYPES) {
                index = GameValue.AMOUNT_OF_METEORS_TYPES - 1;
            }
        }
        index = meteorService.drawMeteors(meteors, meteorsTranslate, shieldSprite, shipSprite, game, index, this);
        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            positions.add(bulletService.createBullet(bullets, shipSprite, game));
        }
        bulletService.shotBullet(bullets, positions, shipSprite, game, destroyedMeteors);
        index = meteorService.destroyMeteor(bullets, meteorsTranslate, removedMeteors, meteors, positions, index, destroyedMeteors).get(0);
        removedMeteors = meteorService.destroyMeteor(bullets, meteorsTranslate, removedMeteors, meteors, positions, index, destroyedMeteors);
        fontService.printScore(score, game, removedMeteors.get(1));
        imageService.placeImage(game, scoreSprite, GameValue.ZERO_VALUE, Gdx.graphics.getHeight() - GameValue.DEFAULT_VALUE_SHIFT);
        imageService.placeImage(game, shieldSprite, GameValue.DEFAULT_VALUE_SHIFT * 3.4f, Gdx.graphics.getHeight() - GameValue.DEFAULT_VALUE_SHIFT * 2.3f);
        fontService.printShieldStatus(shipSprite, shieldText, game, shieldSprite);
        shipSprite.draw(game.batch);
        game.batch.end();
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
}

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
import com.vizor.games.zhenek.dev.service.Factory;
import com.vizor.games.zhenek.dev.service.KeyPressed;
import com.vizor.games.zhenek.dev.service.MeteorService;
import com.vizor.games.zhenek.dev.service.ShipService;
import com.vizor.games.zhenek.dev.util.GameCondition;
import com.vizor.games.zhenek.dev.util.GameTexturePath;
import com.vizor.games.zhenek.dev.util.GameValues;

import java.util.List;

import static com.badlogic.gdx.math.MathUtils.random;

public class PlayScreen implements Screen {

    private KeyPressed keyPressed = Factory.getInstance().getKeyPressed();
    private MeteorService meteorService = Factory.getInstance().getMeteorService();
    private ShipService shipService = Factory.getInstance().getShipService();
    private GameCondition gameCondition = GameCondition.RUN;
    private List<Sprite> meteors = Meteors.getMeteors();

    private SpaceHunter game;
    private Bullets bullets;
    Texture shipTexture;
    SpaceShip shipSprite;
    BitmapFont score;

    Texture backgroundImage;
    Sprite backgroundSprite;
    Sprite meteorSprite;
    Sprite bullet;

    public PlayScreen(SpaceHunter game) {
        this.game = game;
        shipTexture = new Texture(GameTexturePath.SHIP_TEXTURE);
        shipSprite = new SpaceShip(shipTexture);
        backgroundImage = new Texture(GameTexturePath.BACKGROUND_TEXTURE);
        backgroundSprite = new Sprite(backgroundImage);
        meteorSprite = meteors.get(random(1, 19));
        score = new BitmapFont();
        bullet = new Sprite(new Texture(GameTexturePath.SHOUT_SHIP_SPRITE));
    }


    @Override
    public void show() {

    }

    private float timeSeconds = 0f;
    private float period = 3f;
    private static int index = 0;

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

    static int pressed = 0;

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
        index = meteorService.drawMeteors(meteors, shipSprite, game, index);
        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {

        }
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

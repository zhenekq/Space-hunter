package com.vizor.games.zhenek.dev.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.vizor.games.zhenek.dev.SpaceHunter;
import com.vizor.games.zhenek.dev.entity.Meteors;
import com.vizor.games.zhenek.dev.keyboard.Factory;
import com.vizor.games.zhenek.dev.keyboard.KeyPressed;
import com.vizor.games.zhenek.dev.keyboard.MeteorService;
import com.vizor.games.zhenek.dev.util.GameCondition;
import com.vizor.games.zhenek.dev.util.GameTexturePath;
import com.vizor.games.zhenek.dev.util.GameUtils;
import com.vizor.games.zhenek.dev.util.GameValues;

import static com.badlogic.gdx.math.MathUtils.random;

public class PlayScreen implements Screen {

    private KeyPressed keyPressed = Factory.getInstance().getKeyPressed();
    private MeteorService meteorService = Factory.getInstance().getMeteorService();
    private GameCondition gameCondition = GameCondition.RUN;

    private SpaceHunter game;
    Texture shipTexture;
    Sprite shipSprite;

    Texture backgroundImage;
    Sprite backgroundSprite;

    Texture meteorTexture;
    Sprite meteorSprite;

    public PlayScreen(SpaceHunter game) {
        this.game = game;
        shipTexture = new Texture(GameTexturePath.SHIP_TEXTURE);
        shipSprite = new Sprite(shipTexture);
        backgroundImage = new Texture(GameTexturePath.BACKGROUND_TEXTURE);
        backgroundSprite = new Sprite(backgroundImage);
        meteorSprite = Meteors.getMeteors().get(random(1, 19));
    }


    @Override
    public void show() {

    }

    private float timeSeconds = 0f;
    private float period = 2f;
    static int index = 0;

    @Override
    public void render(float delta) {
        /*switch (gameCondition){
            case RUN:
                draw();
                break;
            case PAUSE:
                timeSeconds = 0;
                period = 2;
                break;
        }*/
        draw();

    }

    private void draw(){
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(backgroundSprite, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        GameUtils.checkButtons(keyPressed, shipSprite);
        GameUtils.calculatePosition(shipSprite, shipSprite.getX(), shipSprite.getY());
        GameUtils.calculateRotate(shipSprite);
        timeSeconds += Gdx.graphics.getDeltaTime();
        if (timeSeconds > period) {
            timeSeconds -= period;
            game.batch.draw(Meteors.getMeteors().get(index), random(0, Gdx.graphics.getWidth()), random(0, Gdx.graphics.getHeight()));
            Meteors.getMeteors().get(index).setPosition(300,300);
            Meteors.getMeteors().get(index).setRotation(random(-90, 90));
            index++;
        }
        if(index <= GameValues.AMOUNT_OF_METEORS_TYPES - 1) {
            for (int i = 0; i < index; i++) {
                Sprite meteor = Meteors.getMeteors().get(i);
                GameUtils.calculatePosition(meteor, meteor.getX(), meteor.getY());
                meteor.translate(-1, -1);
                if (shipSprite.getBoundingRectangle().overlaps(meteor.getBoundingRectangle())) {
                    index = 0;
                    break;
                }
                meteor.draw(game.batch);
            }
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

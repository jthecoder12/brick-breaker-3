package jthecoder12.brickbreaker3.screens;

import jthecoder12.brickbreaker3.Main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;

/** First screen of the application. Displayed after the application is created. */
public class TitleScreen implements Screen {
    private Label titleLabel;
    private TextButton startButton;

    @Override
    public void show() {
        titleLabel = new Label("Brick Breaker", Main.INSTANCE.label60);
        startButton = new TextButton("Singleplayer", Main.INSTANCE.button40);
        startButton.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if(button == 0) Main.INSTANCE.setScreen(new SingleplayerScreen());

                return true;
            }
        });

        Main.INSTANCE.stage.addActor(titleLabel);
        Main.INSTANCE.stage.addActor(startButton);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Main.INSTANCE.backgroundColor);
    }

    @Override
    public void resize(int width, int height) {
        // If the window is minimized on a desktop (LWJGL3) platform, width and height are 0, which causes problems.
        // In that case, we don't resize anything, and wait for the window to be a normal size before updating.
        if(width <= 0 || height <= 0) return;

        titleLabel.setPosition(Gdx.graphics.getWidth() / 2f - titleLabel.getWidth() / 2f, Gdx.graphics.getHeight() - titleLabel.getHeight());
        startButton.setPosition(Gdx.graphics.getWidth() / 2f - startButton.getWidth() / 2f, Gdx.graphics.getHeight() / 1.5f);
    }

    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void hide() {
        // This method is called when another screen replaces this one.
    }

    @Override
    public void dispose() {
        // Destroy screen's assets here.
    }
}

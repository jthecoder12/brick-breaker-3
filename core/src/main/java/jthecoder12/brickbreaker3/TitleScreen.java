package jthecoder12.brickbreaker3;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.ScreenUtils;

/** First screen of the application. Displayed after the application is created. */
public class TitleScreen implements Screen {

    @Override
    public void show() {
        Label titleLabel = new Label("Brick Breaker", Main.INSTANCE.label40);

        Main.INSTANCE.stage.addActor(titleLabel);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Main.INSTANCE.backgroundColor);
    }

    @SuppressWarnings("UnnecessaryReturnStatement")
    @Override
    public void resize(int width, int height) {
        // If the window is minimized on a desktop (LWJGL3) platform, width and height are 0, which causes problems.
        // In that case, we don't resize anything, and wait for the window to be a normal size before updating.
        if(width <= 0 || height <= 0) return;

        // Resize your screen here. The parameters represent the new window size.
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

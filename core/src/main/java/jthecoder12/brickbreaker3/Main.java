package jthecoder12.brickbreaker3;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.FitViewport;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    private BitmapFont font40;

    public Stage stage;
    public Color backgroundColor;
    public Label.LabelStyle label40;

    public static Main INSTANCE;

    @Override
    public void create() {
        INSTANCE = this;

        stage = new Stage(new FitViewport(1280, 720));
        Gdx.input.setInputProcessor(stage);

        backgroundColor = new Color(100 / 255f, 100 / 255f, 100 / 255f, 1);

        font40 = new BitmapFont(Gdx.files.internal("fonts/Varela_Round40.fnt"), false);
        label40 = new Label.LabelStyle(font40, Color.WHITE);

        setScreen(new TitleScreen());
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);

        stage.getViewport().update(width, height, true);
    }

    @Override
    public void render() {
        super.render();

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void dispose() {
        super.dispose();

        font40.dispose();
        stage.dispose();
    }
}

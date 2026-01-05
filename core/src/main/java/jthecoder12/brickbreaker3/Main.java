package jthecoder12.brickbreaker3;

import jthecoder12.brickbreaker3.screens.TitleScreen;

import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    private final Array<Screen> screens = new Array<>();
    private final PooledEngine engine = new PooledEngine();

    private BitmapFont font40, font60;

    public Stage stage;
    public Color backgroundColor;
    public TextButton.TextButtonStyle button40;
    public Label.LabelStyle label60;

    public static Main INSTANCE;

    @Override
    public void create() {
        INSTANCE = this;

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        backgroundColor = new Color(100 / 255f, 100 / 255f, 100 / 255f, 1);

        font40 = new BitmapFont(Gdx.files.internal("fonts/Varela_Round/40.fnt"), false);
        button40 = new TextButton.TextButtonStyle();
        button40.font = font40;
        button40.fontColor = Color.WHITE;

        font60 = new BitmapFont(Gdx.files.internal("fonts/Varela_Round/60.fnt"), false);
        label60 = new Label.LabelStyle(font60, Color.WHITE);

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

        engine.update(Gdx.graphics.getDeltaTime());

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void dispose() {
        super.dispose();

        font40.dispose();
        font60.dispose();

        //noinspection GDXJavaUnsafeIterator
        for(Screen screen1 : screens) {
            Gdx.app.log("Screen Disposal", screen1.toString());

            screen1.dispose();
        }
        stage.dispose();
    }

    @Override
    public void setScreen(Screen screen) {
        stage.clear();
        if(!screens.contains(screen, true)) screens.add(screen);

        super.setScreen(screen);

        Gdx.app.log("Screen Change", getScreen().toString());
    }

    public PooledEngine getEngine() {
        return engine;
    }
}

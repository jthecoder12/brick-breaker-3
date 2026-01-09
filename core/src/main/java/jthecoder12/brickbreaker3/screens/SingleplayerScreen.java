package jthecoder12.brickbreaker3.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import jthecoder12.brickbreaker3.Main;
import jthecoder12.brickbreaker3.entities.Ball;
import jthecoder12.brickbreaker3.entities.Player;

public class SingleplayerScreen implements Screen {
    private ShapeRenderer shapeRenderer;
    private Player player;
    private Ball ball;

    @Override
    public void show() {
        shapeRenderer = new ShapeRenderer();
        player = new Player();
        ball = new Ball();

        Main.INSTANCE.getEngine().addEntity(player);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Main.INSTANCE.backgroundColor);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        player.render(shapeRenderer);
        ball.render(shapeRenderer);
        shapeRenderer.end();
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
        shapeRenderer.dispose();
    }
}

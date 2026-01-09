package jthecoder12.brickbreaker3.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Ball extends RenderableEntity {
    public Ball() {
        float radius = (float) (Math.sqrt(Math.pow(Gdx.graphics.getWidth(), 2) + Math.pow(Gdx.graphics.getHeight(), 2)) / 84f);
        position = new Vector2(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f);

        init(false, radius, Color.WHITE);
    }

    @Override
    protected void update() {

    }
}

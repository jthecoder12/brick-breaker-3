package jthecoder12.brickbreaker3.entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import jthecoder12.brickbreaker3.Main;
import jthecoder12.brickbreaker3.components.RectComponent;

public class Player extends Entity {
    private final Vector2 touchPos = new Vector2();

    private final float width;
    private final Vector2 position;
    private final RectComponent rectComponent;

    public Player() {
        width = Gdx.graphics.getWidth() / 4f;
        Vector2 size = new Vector2(width, Gdx.graphics.getHeight() / 36f);

        position = new Vector2(Gdx.graphics.getWidth() / 2f - width / 2f, Gdx.graphics.getHeight() / 3f);

        rectComponent = new RectComponent(position, size, Color.WHITE);
        add(rectComponent);
    }

    public void render(ShapeRenderer shapeRenderer) {
        float speed = Gdx.graphics.getDeltaTime() * 1200;

        if(Gdx.input.isKeyPressed(Input.Keys.A)) position.x -= speed;
        if(Gdx.input.isKeyPressed(Input.Keys.D)) position.x += speed;

        if(Gdx.input.isTouched()) {
            touchPos.set(Gdx.input.getX(), Gdx.input.getY());
            Main.INSTANCE.stage.getViewport().unproject(touchPos);
            position.x = touchPos.x - width / 2f;
        }

        rectComponent.render(shapeRenderer);
        rectComponent.setPosition(position);
    }
}

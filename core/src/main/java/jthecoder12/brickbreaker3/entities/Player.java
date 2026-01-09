package jthecoder12.brickbreaker3.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import jthecoder12.brickbreaker3.Main;

public class Player extends RenderableEntity {
    private boolean firstTimeTouching = true;
    private final Vector2 touchPos = new Vector2();

    private final float width;

    public Player() {
        width = Gdx.graphics.getWidth() / 4f;
        Vector2 size = new Vector2(width, Gdx.graphics.getHeight() / 36f);
        position = new Vector2(640 - width / 2f, 240);

        init(true, size, Color.WHITE);
    }

    @Override
    protected void update() {
        float speed = Gdx.graphics.getDeltaTime() * 1200;

        if(Gdx.input.isKeyPressed(Input.Keys.A)) position.x -= speed;
        if(Gdx.input.isKeyPressed(Input.Keys.D)) position.x += speed;

        if(firstTimeTouching && !Gdx.input.isTouched()) firstTimeTouching = false;

        if(Gdx.input.isTouched() && !firstTimeTouching) {
            touchPos.set(Gdx.input.getX(), Gdx.input.getY());
            Main.INSTANCE.stage.getViewport().unproject(touchPos);
            position.x = touchPos.x - width / 2f;
        }
    }
}

package jthecoder12.brickbreaker3.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class RectComponent implements Component {
    private final Vector2 position, size;
    private final Color color;

    public RectComponent(Vector2 position, Vector2 size, Color color) {
        this.position = position;
        this.size = size;
        this.color = color;
    }

    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(color);
        shapeRenderer.rect(position.x, position.y, size.x, size.y);
    }

    public void setPosition(Vector2 position) {
        this.position.set(position);
    }
}

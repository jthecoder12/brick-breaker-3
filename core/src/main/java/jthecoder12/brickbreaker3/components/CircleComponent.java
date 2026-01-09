package jthecoder12.brickbreaker3.components;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class CircleComponent extends ObjectComponent {
    private float radius;

    public CircleComponent(Vector2 position, float radius, Color color) {
        this.position = position;
        this.color = color;

        resize(radius);
    }

    @Override
    public void resize(Object nSize) {
        radius = (float) nSize;
    }

    @Override
    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(color);
        shapeRenderer.circle(position.x, position.y, radius);
    }
}

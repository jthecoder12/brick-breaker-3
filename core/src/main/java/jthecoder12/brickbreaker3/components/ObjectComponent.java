package jthecoder12.brickbreaker3.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public abstract class ObjectComponent implements Component {
    protected Vector2 position;
    protected Color color;

    public void setPosition(Vector2 nPos) {
        position.set(nPos);
    }

    public abstract void resize(Object nSize);
    public abstract void render(ShapeRenderer shapeRenderer);
}

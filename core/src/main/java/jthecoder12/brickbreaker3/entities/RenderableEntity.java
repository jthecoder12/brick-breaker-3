package jthecoder12.brickbreaker3.entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import jthecoder12.brickbreaker3.components.CircleComponent;
import jthecoder12.brickbreaker3.components.ObjectComponent;
import jthecoder12.brickbreaker3.components.RectComponent;

abstract class RenderableEntity extends Entity {
    protected ObjectComponent objectComponent;
    protected Vector2 position;

    // shapeType: True is rectangle, false is circle
    @SuppressWarnings("SameParameterValue")
    protected void init(boolean shapeType, Object size, Color color) {
        if(shapeType) objectComponent = new RectComponent(position, (Vector2) size, color);
        else objectComponent = new CircleComponent(position, (float) size, color);
    }

    protected abstract void update();

    public void render(ShapeRenderer shapeRenderer) {
        update();

        objectComponent.render(shapeRenderer);
        objectComponent.setPosition(position);
    }
}

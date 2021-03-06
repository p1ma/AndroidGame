package p1ma.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import p1ma.game.content.TextureFactory;

/**
 * Created by p1ma on 28/07/16.
 */
public class BlackCube extends Cube{

    public BlackCube(Vector2 pos){
        super(0, pos, false);
        this.color = Colors.BLACK;
    }
    @Override
    public Texture getTexture() {
        return TextureFactory.getInstance().getBlackCube();
    }

    public void move(float delta) {
        float movement = (delta * speed);
        moveDown(movement);
    }
}

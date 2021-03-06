package p1ma.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import p1ma.game.content.TextureFactory;

/**
 * Created by p1ma on 28/07/16.
 */
public class BlueCube extends Cube{

    public BlueCube(Vector2 pos){
        super(5,pos, true);
        this.color = Colors.BLUE;
    }
    @Override
    public Texture getTexture() {
        return TextureFactory.getInstance().getBlueCube();
    }

    public void move(float delta){
        float movement = (delta * speed);
        moveDown(movement);
    }
}

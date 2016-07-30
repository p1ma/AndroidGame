package p1ma.game.model;

import com.badlogic.gdx.graphics.Texture;

import p1ma.game.content.TextureFactory;

/**
 * Created by p1ma on 28/07/16.
 */
public class BlueCube extends Cube{

    public BlueCube(){
        super(0);
    }
    @Override
    public Texture getTexture() {
        return TextureFactory.getInstance().getBlueCube();
    }
}

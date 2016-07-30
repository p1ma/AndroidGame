package p1ma.game.content;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by p1ma on 30/07/16.
 */
public class TextureFactory {

    private static TextureFactory instance = new TextureFactory();

    private static final float WALKING_FRAME_DURATION = 0.06f;

    //SplashScreen's image
    private Texture splashImage;

    //Cube's images : basics one for the moment
    private Texture blackCube;
    private Texture blueCube;
    private Texture redCube;
    private Texture yellowCube;


    public static TextureFactory getInstance()
    {
        return instance;
    }

    private TextureFactory()
    {
        splashImage = new Texture(Gdx.files.internal("images/badlogic.jpg"));
        blackCube = new Texture(Gdx.files.internal("images/black.jpg"));
        blueCube = new Texture(Gdx.files.internal("images/blue.jpg"));
        redCube = new Texture(Gdx.files.internal("images/red.jpg"));
        yellowCube = new Texture(Gdx.files.internal("images/yellow.jpg"));
    }

    public Texture getSplashImage(){
        return this.splashImage;
    }

    public Texture getBlackCube() {
        return blackCube;
    }

    public Texture getYellowCube() {
        return yellowCube;
    }

    public Texture getRedCube() {
        return redCube;
    }

    public Texture getBlueCube() {
        return blueCube;
    }
}

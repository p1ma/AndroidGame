package p1ma.game.view;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;

import p1ma.game.MyGame;

/**
 * Created by p1ma on 28/07/16.
 */
public class MenuScreen extends ScreenAdapter{

    private MyGame game;

    // camera's attributes
    private OrthographicCamera camera;
    private FitViewport viewport;

    public MenuScreen(MyGame myGame) {
        super();
        this.game = myGame;
    }
}

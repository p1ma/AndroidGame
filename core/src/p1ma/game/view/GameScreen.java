package p1ma.game.view;

import com.badlogic.gdx.ScreenAdapter;

import p1ma.game.MyGame;

/**
 * Created by p1ma on 28/07/16.
 */
public class GameScreen extends ScreenAdapter{

    private MyGame game;

    public static final int WORLD_WIDTH = 100;
    public static final int WORLD_HEIGHT = 100;

    public GameScreen(MyGame myGame) {
        super();
        this.game = myGame;
    }
}

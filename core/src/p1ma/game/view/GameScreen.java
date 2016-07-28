package p1ma.game.view;

import com.badlogic.gdx.ScreenAdapter;

import p1ma.game.MyGame;

/**
 * Created by p1ma on 28/07/16.
 */
public class GameScreen extends ScreenAdapter{

    private MyGame game;

    public GameScreen(MyGame myGame) {
        super();
        this.game = myGame;
    }
}

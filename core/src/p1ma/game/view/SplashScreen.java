package p1ma.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import p1ma.game.MyGame;

/**
 * Created by p1ma on 28/07/16.
 */
public class SplashScreen extends ScreenAdapter{

    private MyGame game;
    private SpriteBatch spriteBatch;
    private long timer;
    private static long duration = 2000; // 2000 ms = 2s

    public SplashScreen(MyGame myGame){
        super();
        this.game = myGame;
        this.spriteBatch = new SpriteBatch();
        this.timer = 0;
    }

    @Override
    public void show() {
        super.show();
        this.timer = System.currentTimeMillis() + duration;
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void dispose() {
        super.dispose();
        this.spriteBatch.dispose();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        long time = System.currentTimeMillis();
        if(time <= this.timer) {
            Gdx.gl.glClearColor(0, 1, 0, 1); // R, G, B, alpha
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            time = System.currentTimeMillis();
        }else {
            System.out.println("SplashScreen's end... Menu inc");
            this.game.setMenuScreen();
        }
    }
}

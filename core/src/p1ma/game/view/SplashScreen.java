package p1ma.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import p1ma.game.MyGame;

/**
 * Created by p1ma on 28/07/16.
 */
public class SplashScreen extends ScreenAdapter{

    private MyGame game;
    private SpriteBatch spriteBatch;
    private Texture image;
    private long timer;
    private static long duration = 200000; // 2000 ms = 2s

    // camera's attributes
    private OrthographicCamera camera;
    private StretchViewport viewport;

    public SplashScreen(MyGame myGame){
        super();
        this.game = myGame;
        this.spriteBatch = new SpriteBatch();
        this.image = new Texture(Gdx.files.internal("images/badlogic.jpg"));
        this.timer = 0;

        this.camera = new OrthographicCamera();
        this.viewport = new StretchViewport(GameScreen.WORLD_WIDTH,GameScreen.WORLD_HEIGHT,camera);
        this.viewport.apply();

        this.camera.position.set((camera.viewportWidth / 2),(camera.viewportHeight / 2),0);
    }

    @Override
    public void show() {
        super.show();
        this.timer = System.currentTimeMillis() + duration;
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        viewport.update(width, height);
        camera.position.set((camera.viewportWidth / 2),(camera.viewportHeight / 2), 0);
    }

    @Override
    public void dispose() {
        super.dispose();
        this.spriteBatch.dispose();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        camera.update();
        long time = System.currentTimeMillis();
        if(time <= this.timer) {
            //drawing part
            spriteBatch.setProjectionMatrix(camera.combined);
            spriteBatch.begin();
            spriteBatch.draw(this.image,0,0,GameScreen.WORLD_WIDTH, GameScreen.WORLD_HEIGHT);
            spriteBatch.end();
        }else {
            System.out.println("SplashScreen's end... Menu inc");
            this.game.setMenuScreen();
        }
    }
}

package p1ma.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Iterator;

import p1ma.game.MyGame;
import p1ma.game.model.Cube;
import p1ma.game.model.World;

/**
 * Created by p1ma on 28/07/16.
 */
public class GameScreen extends ScreenAdapter{

    private MyGame game;

    // World
    private World world;

    // camera's attributes
    private OrthographicCamera camera;
    private Viewport viewport;

    public static final int WORLD_HEIGHT = World.HEIGHT * Cube.CUBE_DIM ;
    public static final int WORLD_WIDTH = World.WIDTH * Cube.CUBE_DIM;

    // FPS
    private FPSLogger fps;

    //Sprite and textures
    private SpriteBatch  spriteBatch;

    public GameScreen(MyGame myGame) {
        super();
        this.game = myGame;
        this.world = new World(this);

        // Camera and Viewport settings
        this.camera = new OrthographicCamera();
        System.out.println("GameScreen (Constructor) \nWorld_Width : " + WORLD_WIDTH + " World_Height : " + WORLD_HEIGHT );
        this.viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
        this.viewport.apply();
        this.camera.position.set((camera.viewportWidth / 2), (camera.viewportHeight / 2), 0);
        this.camera.update();

        // FPS
        fps = new FPSLogger();

        //Sprite and textures
        this.spriteBatch = new SpriteBatch();

    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        viewport.update(width, height);
        camera.position.set((camera.viewportWidth / 2), (camera.viewportHeight / 2), 0);
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        this.world.update(delta); // update the world
        this.camera.update();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.spriteBatch.setProjectionMatrix(camera.combined);
        this.spriteBatch.begin();
        Iterator<Cube> ite = world.cubeIterator();
        while(ite.hasNext()){
            Cube c = ite.next();
            System.out.println("GameScreen (render) : Cube " + c);
            spriteBatch.draw(c.getTexture(), c.getPosition().x * Cube.CUBE_DIM, c.getPosition().y * Cube.CUBE_DIM, Cube.CUBE_DIM, Cube.CUBE_DIM);
        }
        this.spriteBatch.end();
        fps.log();
    }
}

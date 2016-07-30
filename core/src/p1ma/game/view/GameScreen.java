package p1ma.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;

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
    private FitViewport viewport;

    public static final int WORLD_WIDTH = World.WIDTH * Cube.CUBE_WIDTH;
    public static final int WORLD_HEIGHT = World.HEIGHT  * Cube.CUBE_HEIGHT;

    // FPS
    private FPSLogger fps;

    public GameScreen(MyGame myGame) {
        super();
        this.game = myGame;
        this.world = new World(this);

        // Camera and Viewport settings
        this.camera = new OrthographicCamera();
        this.viewport = new FitViewport(GameScreen.WORLD_WIDTH,GameScreen.WORLD_HEIGHT,camera);
        this.viewport.apply();
        this.camera.position.set((camera.viewportWidth / 2), (camera.viewportHeight / 2), 0);
        this.camera.update();

        // FPS
        fps = new FPSLogger();

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
        this.camera.update(); // mets à jour la position de la caméra
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        fps.log();
    }
}

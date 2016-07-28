package p1ma.game.view;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.FitViewport;

import p1ma.game.MyGame;
import p1ma.game.model.TextTranslation;

/**
 * Created by p1ma on 28/07/16.
 */
public class MenuScreen extends ScreenAdapter{

    private MyGame game;
    private SpriteBatch spriteBatch;

    // camera's attributes
    private OrthographicCamera camera;
    private FitViewport viewport;

    //Skin and Stage
    private Skin skin; //TODO
    private Stage stage;

    //Buttons
    private TextButton playButton;
    private TextButton levelButton;
    private TextButton optionsButton;

    //level table
    private String[] levels;

    public MenuScreen(MyGame myGame) {
        super();
        this.game = myGame;
        this.spriteBatch = new SpriteBatch();

        this.camera = new OrthographicCamera();
        this.viewport = new FitViewport(GameScreen.WORLD_WIDTH,GameScreen.WORLD_HEIGHT,camera);
        this.viewport.apply();

        this.camera.position.set((camera.viewportWidth / 2), (camera.viewportHeight / 2), 0);

        // Skin and Stage
        this.skin = new Skin(); //TODO
        this.stage = new Stage();

        //Buttons
        String play = TextTranslation.getTranslation().getTextPlay();
        this.playButton = new TextButton(play, skin, "default");

        this.levels = new String[4];
        this.levels = TextTranslation.getTranslation().getTextLevel();
        this.levelButton = new TextButton(levels[0], skin, "default");

        String option = TextTranslation.getTranslation().getTextOptions();
        this.optionsButton = new TextButton(option, skin, "default");
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        camera.update();
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        viewport.update(width, height);
        camera.position.set((camera.viewportWidth / 2), (camera.viewportHeight / 2), 0);
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}

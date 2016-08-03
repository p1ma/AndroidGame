package p1ma.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;

import p1ma.game.MyGame;
import p1ma.game.content.TextTranslation;
import p1ma.game.model.World;

/**
 * Created by p1ma on 28/07/16.
 *
 * TODO :  SKIN AND GRAPHIC DESIGN
 */
public class MenuScreen extends ScreenAdapter{

    private MyGame game;
    private SpriteBatch spriteBatch;
    private static int indice = 0;

    public static final String FONT_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;,{}\"´`'<>";


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
        //this.skin = new Skin(Gdx.files.internal("ui/uiskin.json")); //TODO
        //this.skin = new Skin();
        this.stage = new Stage();

        //Buttons

        // TEST
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = new BitmapFont();
        //style.font = TrueTypeFontFactory.createBitmapFont(Gdx.files.internal("data/Candy Shop Black.ttf"), FONT_CHARACTERS, 12.5f, 7.5f, 1.0f, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        String play = TextTranslation.getTranslation().getTextPlay();
        this.playButton = new TextButton(play, style); //, skin, "default");

        this.levels = new String[4];
        this.levels = TextTranslation.getTranslation().getTextLevel();
        this.levelButton = new TextButton(levels[indice], style); // skin, "default");

        String option = TextTranslation.getTranslation().getTextOptions();
        this.optionsButton = new TextButton(option, style); // skin, "default");

        //Buttons configuration

        /*

             ______________________________
            |                               |
            |                               |
            |   [//// PLAY BUTTON ////]     |
            |   [//// LEVEL CHOICE ////]    |
            |   [//// OPTIONS ////]         |
            |                               |
            |_______________________________|

            And yes, that is a smartphone's screen. Kind of...
         */
        int width,height;
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();

        //Play button configuration
        this.playButton.setWidth(250.0f);
        this.playButton.setHeight(25.0f);
        this.playButton.setPosition(width/2, height * 3/4, Align.center);
        this.playButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                // user clicked on 'Play', the game will begin
                game.setGameScreen();
            }
        });

        //Level button configuration
        this.levelButton.setWidth(250.0f);
        this.levelButton.setHeight(25.0f);
        this.levelButton.setPosition(width/2, height * 1/2, Align.center);
        this.levelButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                // user decided to change the game level,
                /* 0 -> easy , 1 -> medium , 2 -> hard, 3 -> robot : so mod4

                            NORMAL FREEZE
                    EASY     3.5    2.0
                    NORMAL   4.5    3.0
                    HARD     5.5    4.0
                    ROBOT    6.5    5.0
                */
                indice++;
                World.speed = (1.0f * (indice%4)) + 3.5f;
                System.out.println("Speed : " + World.speed + " - Level : " + levels[(indice % 4)]);
                levelButton.setText(levels[(indice % 4)]);
            }
        });

        //Options button configuration
        this.optionsButton.setWidth(250.0f);
        this.optionsButton.setHeight(25.0f);
        this.optionsButton.setPosition(width/2, height * 1/4, Align.center);
        this.optionsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // user clicked on 'Option'
                //TODO
            }
        });

        //Add buttons to the stage
        stage.addActor(this.playButton);
        stage.addActor(this.levelButton);
        stage.addActor(this.optionsButton);

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0, 0,0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
    }


    @Override
    public void show() {
        super.show();
        camera.update();
        Gdx.input.setInputProcessor(stage);
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
        this.spriteBatch.dispose();
        this.stage.dispose();
        this.playButton.clear();
        this.levelButton.clear();
        this.optionsButton.clear();
    }
}

package p1ma.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import p1ma.game.view.GameScreen;
import p1ma.game.view.MenuScreen;
import p1ma.game.view.SplashScreen;

/**
 * Created by p1ma on 28/07/16.
 */
public class MyGame extends Game {

	// Names are explicites enough...
	SplashScreen splashScreen;
	GameScreen gameScreen;
	MenuScreen menuScreen;

	public MyGame() {
		super();
	}

	@Override
	public void create () {
		splashScreen = new SplashScreen(this);
		gameScreen = null;
		menuScreen = new MenuScreen(this);
		setScreen(menuScreen);
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		this.splashScreen.dispose();
	}

	public void setSplashScreen(){
		setScreen(splashScreen);
	}

	public void setGameScreen(){
		if(gameScreen != null){
			gameScreen.dispose();
		}
		gameScreen = new GameScreen(this);
		setScreen(gameScreen);
	}

	public void setMenuScreen(){
		setScreen(menuScreen);
	}
}

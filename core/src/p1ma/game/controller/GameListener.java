package p1ma.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.Viewport;

import p1ma.game.model.World;
import p1ma.game.view.GameScreen;

/**
 * Created by p1ma on 28/07/16.
 */
public class GameListener implements InputProcessor{

    private World world;
    private GameScreen screen;

    public GameListener(GameScreen gameScreen){
        this.world = gameScreen.getWorld();
        this.screen = gameScreen;
        System.out.println("GameListener (constructor) Worked !");
    }
    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        System.out.println("GameListener (touchDown) (screenX,screenY) : ( " + screenX + " , " + screenY + " )");
        Camera camera = screen.getCamera();
        //camera.update();
        Vector3 position = new Vector3(screenX,screenY,0);
        camera.unproject(position);
        System.out.println("GameListener (touchDown) unprojected position : "+position);
        world.verify(position.x, position.y);
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}

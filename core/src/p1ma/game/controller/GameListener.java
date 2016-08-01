package p1ma.game.controller;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

import p1ma.game.model.World;

/**
 * Created by p1ma on 28/07/16.
 */
public class GameListener implements InputProcessor{

    private World world;

    public GameListener(World wd){
        this.world = wd;
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
        world.verify(screenX,screenY);
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
        System.out.println("GameListener (touchDown) (screenX,screenY) : ( " + screenX + " , " + screenY + " )");
        world.verify(screenX, screenY);
        return true;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
